package com.ngctien.noteapps.features.addnote.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngctien.noteapps.databinding.CustomToolBarBinding
import com.ngctien.noteapps.common.BaseFragment
import com.ngctien.noteapps.databinding.FragmentAddNoteBinding
import com.ngctien.noteapps.utils.popBackStack

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
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
            title.apply {
                text = "Add Notes"
                visibility = View.VISIBLE
            }
            leftSideActions.visibility = View.GONE
        }
    }
}