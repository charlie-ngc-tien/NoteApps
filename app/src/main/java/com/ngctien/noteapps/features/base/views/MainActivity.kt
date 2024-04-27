package com.ngctien.noteapps.features.base.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngctien.noteapps.databinding.ActivityMainBinding
import com.ngctien.noteapps.features.authentication.views.SignInFragment
import com.ngctien.noteapps.utils.replaceFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(SignInFragment(), false)
    }
}