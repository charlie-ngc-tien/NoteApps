package com.ngctien.noteapps.features.base.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ngctien.noteapps.core.viewmodels.MainViewModel
import com.ngctien.noteapps.databinding.ActivityMainBinding
import com.ngctien.noteapps.features.notes.views.NotesFragment
import com.ngctien.noteapps.utils.replaceFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            replaceFragment(NotesFragment(), false)
        }
    }
}