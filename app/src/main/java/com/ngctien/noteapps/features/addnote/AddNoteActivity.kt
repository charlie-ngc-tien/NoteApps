package com.ngctien.noteapps.features.addnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ngctien.noteapps.R
import com.ngctien.noteapps.databinding.ActivityAddNoteBinding
import com.ngctien.noteapps.databinding.CustomToolBarBinding

class AddNoteActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityAddNoteBinding.inflate(layoutInflater)
    }

    private val toolbarBinding by lazy(LazyThreadSafetyMode.NONE) {
        CustomToolBarBinding.bind(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        toolbarBinding.backButton.setOnClickListener {
            finish()
        }
        toolbarBinding.title.apply {
            text = "Add Notes"
            visibility = View.VISIBLE
        }
        toolbarBinding.leftSideActions.visibility = View.GONE
    }
}