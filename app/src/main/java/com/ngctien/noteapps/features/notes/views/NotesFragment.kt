package com.ngctien.noteapps.features.notes.views

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.ngctien.noteapps.R
import com.ngctien.noteapps.databinding.CustomToolBarBinding
import com.ngctien.noteapps.common.BaseFragment
import com.ngctien.noteapps.core.viewmodels.MainViewModel
import com.ngctien.noteapps.data.Note
import com.ngctien.noteapps.databinding.FragmentNotesBinding
import com.ngctien.noteapps.features.addnote.views.AddNoteFragment
import com.ngctien.noteapps.features.detail.views.NoteDetailFragment
import com.ngctien.noteapps.features.notes.adapter.NoteListAdapter
import com.ngctien.noteapps.utils.ArgumentsKey.KEY_NOTE
import com.ngctien.noteapps.utils.replaceFragment

class NotesFragment : BaseFragment<FragmentNotesBinding>() {
    private val noteListAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NoteListAdapter(onItemClick = ::handleOnClickItem)
    }

    private val viewModel by activityViewModels<MainViewModel>()

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
        observeData()
    }

    private fun initViews() {
        toolBarBinding?.apply {
            backButton.visibility = View.GONE
            toolbarTitle.visibility = View.VISIBLE
            toolbarTitle.text = "All Notes"
            toolbarTitle.gravity = Gravity.START
        }
        binding?.apply {
            recyclerViewNotes.apply {
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
        val fragment = NoteDetailFragment()
        val bundle = Bundle()
        bundle.putSerializable(KEY_NOTE, note)
        fragment.arguments = bundle
        requireActivity().replaceFragment(fragment, true)
    }

    private fun handleAddNoteButtonClicked() {
        requireActivity().replaceFragment(AddNoteFragment(), true)
    }

    private fun observeData() {
        viewModel.notesLiveData.observe(viewLifecycleOwner) {
            noteListAdapter.submitList(it)
            binding?.apply {
                recyclerViewNotes.visibility = if (it.isNotEmpty()) View.VISIBLE else View.GONE
                emptyStateView.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
            }
        }
    }
}