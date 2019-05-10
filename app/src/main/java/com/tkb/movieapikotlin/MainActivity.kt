package com.tkb.movie

import android.os.Bundle
import com.google.android.material.navigation.NavigationView

import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.tkb.movie.fragment.PopularMovieFragment
import com.tkb.movieapikotlin.FragmentsManager
import com.tkb.movieapikotlin.R

class MainActivity : AppCompatActivity() {

    private var fragmentManager: FragmentManager? = null
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()



        fragmentManager = supportFragmentManager
        //final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (savedInstanceState != null) {
            fragment = supportFragmentManager.findFragmentByTag("PopularMovieFragment")
        } else {
            fragment = PopularMovieFragment()
            supportFragmentManager.beginTransaction().add(R.id.main_container_wrapper, fragment!!, "PopularMovieFragment").commit()

        }
        /*//fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
        //fragmentTransaction.commit();*/

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val header = navigationView.inflateHeaderView(R.layout.nav_header_music)
        val profileName = header.findViewById<TextView>(R.id.profile_name)
        profileName.text = "Adele"

        navigationView.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            fragment = FragmentsManager.getFragment(id)

            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.main_container_wrapper, fragment!!)
            transaction.commit()

            val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
            assert(drawer != null)
            drawer!!.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.movie, menu)

        val mSearch = menu.findItem(R.id.action_search)

        val mSearchView = mSearch.actionView as SearchView
        mSearchView.queryHint = "Search"

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                //mAdapter.getFilter().filter(newText);
                return true
            }
        })


        return true
    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
    }
}
