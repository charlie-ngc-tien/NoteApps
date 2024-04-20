package com.ngctien.noteapps.features.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngctien.noteapps.R
import com.ngctien.noteapps.databinding.ActivityNoteDetailBinding
import com.ngctien.noteapps.databinding.CustomToolBarBinding

class NoteDetailActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityNoteDetailBinding.inflate(layoutInflater)
    }

    private val toolBarBinding by lazy (LazyThreadSafetyMode.NONE) {
        CustomToolBarBinding.bind(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        toolBarBinding.backButton.setOnClickListener{
            finish()
        }
    }
}