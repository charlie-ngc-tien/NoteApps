package com.ngctien.noteapps.features.detail.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngctien.noteapps.databinding.CustomToolBarBinding
import com.ngctien.noteapps.common.BaseFragment
import com.ngctien.noteapps.data.Note
import com.ngctien.noteapps.databinding.FragmentNoteDetailBinding
import com.ngctien.noteapps.utils.ArgumentsKey.KEY_NOTE
import com.ngctien.noteapps.utils.format
import com.ngctien.noteapps.utils.popBackStack

class NoteDetailFragment : BaseFragment<FragmentNoteDetailBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        toolBarBinding = CustomToolBarBinding.bind(binding!!.root)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        toolBarBinding?.apply {
            backButton.setOnClickListener {
                popBackStack()
            }
            leftSideActions?.apply {
                visibility = View.VISIBLE
            }
        }
        arguments?.let {
            requireArguments().run {
                if (containsKey(KEY_NOTE)) {
                    val note = getSerializable(KEY_NOTE, Note::class.java)!!
                    binding?.apply {
                        noteTitle.text = note.title
                        noteContent.text = note.content
                        noteCreatedDate.text = note.createdDate.format()
                    }
                }
            }
        }
    }
}