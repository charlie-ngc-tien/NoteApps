package com.ngctien.noteapps.features.notes.views

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.ngctien.noteapps.R
import com.ngctien.noteapps.data.NOTES
import com.ngctien.noteapps.data.Note
import com.ngctien.noteapps.databinding.ActivityNotesBinding
import com.ngctien.noteapps.features.detail.NoteDetailActivity
import com.ngctien.noteapps.features.notes.adapter.NoteListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class NotesActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityNotesBinding.inflate(layoutInflater)
    }

    private val noteListAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NoteListAdapter(onItemClick = ::handleOnClickItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            noteListAdapter.submitList(NOTES)
            withContext(Dispatchers.Main){
                binding.notes.visibility = View.VISIBLE
                binding.emptyStateView.visibility = View.GONE
            }
        }
    }

    private fun setupViews() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        binding.toolbar.bringToFront()
        binding.notes.apply {
            val divider = MaterialDividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                dividerColor = getColor(R.color.divider_color)
                dividerThickness = context.resources.getDimensionPixelSize(R.dimen.divider_size)
                isLastItemDecorated = false
            }
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = noteListAdapter
            addItemDecoration(divider)
        }
    }
    private fun handleOnClickItem(note: Note) {
        Intent(this, NoteDetailActivity::class.java).run {
            startActivity(this)
        }
    }
}