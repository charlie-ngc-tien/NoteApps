package com.ngctien.noteapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ngctien.noteapps.features.authentication.views.SignInActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        openSignInActivity()
    }

    private fun openSignInActivity() {
        Intent(this, SignInActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}