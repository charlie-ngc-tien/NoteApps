package com.ngctien.noteapps.features.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngctien.noteapps.R
import com.ngctien.noteapps.databinding.ActivityNoteDetailBinding

class NoteDetailActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityNoteDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {

    }
}