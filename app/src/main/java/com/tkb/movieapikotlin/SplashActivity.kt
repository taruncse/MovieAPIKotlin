package com.tkb.movie

import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.tkb.movieapikotlin.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val SPLASH_DISPLAY_LENGTH = 3000

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val actionBar = supportActionBar
        actionBar?.hide()

        Handler().postDelayed({
            val startActivityIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(startActivityIntent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }

    companion object {

        private val TAG = SplashActivity::class.java!!.getSimpleName()
    }
}
