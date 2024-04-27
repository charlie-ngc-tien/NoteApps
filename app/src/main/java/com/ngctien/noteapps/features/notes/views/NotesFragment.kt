package com.ngctien.noteapps.features.notes.views

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.ngctien.noteapps.R
import com.ngctien.noteapps.databinding.CustomToolBarBinding
import com.ngctien.noteapps.common.BaseFragment
import com.ngctien.noteapps.data.NOTES
import com.ngctien.noteapps.data.Note
import com.ngctien.noteapps.databinding.FragmentNotesBinding
import com.ngctien.noteapps.features.addnote.views.AddNoteFragment
import com.ngctien.noteapps.features.detail.views.NoteDetailFragment
import com.ngctien.noteapps.features.notes.adapter.NoteListAdapter
import com.ngctien.noteapps.utils.replaceFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NotesFragment : BaseFragment<FragmentNotesBinding>() {
    private val noteListAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NoteListAdapter(onItemClick = ::handleOnClickItem)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        toolBarBinding = CustomToolBarBinding.bind(binding!!.root)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        lifecycleScope.launch {
            delay(1000)
            noteListAdapter.submitList(NOTES)
            binding?.apply {
                notes.visibility = View.VISIBLE
                emptyStateView.visibility = View.GONE
            }
        }
    }

    private fun initViews() {
        toolBarBinding?.apply {
            backButton.visibility = View.GONE
            title.visibility = View.VISIBLE
            title.text = "All Notes"
            title.gravity = Gravity.START
        }
        binding?.apply {
            notes.apply {
                val divider =
                    MaterialDividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                        dividerColor = context.getColor(R.color.divider_color)
                        dividerThickness =
                            context.resources.getDimensionPixelSize(R.dimen.divider_size)
                        isLastItemDecorated = false
                    }
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = noteListAdapter
                addItemDecoration(divider)
            }
            addNote.setOnClickListener {
                handleAddNoteButtonClicked()
            }
        }

    }

    private fun handleOnClickItem(note: Note) {
        requireActivity().replaceFragment(NoteDetailFragment(), true)
    }

    private fun handleAddNoteButtonClicked() {
        requireActivity().replaceFragment(AddNoteFragment(), true)
    }
}