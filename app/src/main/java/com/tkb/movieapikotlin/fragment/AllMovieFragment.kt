package com.tkb.movie.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.processors.PublishProcessor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.tkb.movie.adapter.AllMovieAdapter
import com.tkb.movieapikotlin.R

class AllMovieFragment : Fragment() {
    private val paginator = PublishProcessor.create<Int>()
    private var loading = false
    private var progressBar: ProgressBar? = null
    internal var paginationAdapter: AllMovieAdapter? = null
    private var pageNumber = 1
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private var gridLayoutManager: GridLayoutManager? = null
    private val VISIBLE_THRESHOLD = 1
    internal var model: AllMovieViewModel? = null
    internal var songRecyclerView: RecyclerView? = null
    internal var position: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_all_movie, container, false)

        progressBar = view.findViewById(R.id.progressBar)


        // getActivity().setTitle(Constant.getFragments().get(position));
        songRecyclerView = view.findViewById(R.id.song_list)
        gridLayoutManager = GridLayoutManager(context, 3)
        songRecyclerView?.layoutManager = gridLayoutManager
        songRecyclerView?.setHasFixedSize(true)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = if (arguments != null) arguments!!.getInt("position") else 1
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        paginationAdapter = AllMovieAdapter(activity!!)
        songRecyclerView?.adapter = paginationAdapter
        setUpLoadMoreListener()
        subscribeForData()
    }

    private fun setUpLoadMoreListener() {
        songRecyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView,
                                    dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                totalItemCount = gridLayoutManager!!.itemCount
                lastVisibleItem = gridLayoutManager!!
                        .findLastVisibleItemPosition()
                if (!loading && totalItemCount <= lastVisibleItem + VISIBLE_THRESHOLD) {
                    pageNumber++
                    paginator.onNext(pageNumber)
                    loading = true

                    progressBar!!.visibility = View.VISIBLE
                    loadData()
                }
            }
        })
    }

    private fun subscribeForData() {
        loading = true
        progressBar!!.visibility = View.VISIBLE
        paginator.onNext(pageNumber)

        loadData()
    }

    private fun loadData() {
       /* model = ViewModelProviders.of(this).get(AllMovieViewModel::class.java!!)
        model?.getMovie(position, pageNumber)?.observe(this, { movieList ->

            paginationAdapter.addItems(movieList.get(position))

            paginationAdapter.notifyDataSetChanged()
            loading = false
            progressBar!!.visibility = View.INVISIBLE
        })*/
    }

    companion object {

        fun newInstance(num: Int): AllMovieFragment {
            val f = AllMovieFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putInt("position", num)
            f.arguments = args

            return f
        }
    }
}
