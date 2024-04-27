package com.ngctien.noteapps.features.authentication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngctien.noteapps.databinding.CustomToolBarBinding
import com.ngctien.noteapps.databinding.FragmentSignUpBinding
import com.ngctien.noteapps.common.BaseFragment
import com.ngctien.noteapps.utils.popBackStack

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
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
        }
        binding?.apply {
            txtSignIn.setOnClickListener {
                popBackStack()
            }
        }
    }
}