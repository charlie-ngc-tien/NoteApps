package com.ngctien.noteapps.features.authentication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngctien.noteapps.databinding.FragmentSignInBinding
import com.ngctien.noteapps.common.BaseFragment
import com.ngctien.noteapps.features.notes.views.NotesFragment
import com.ngctien.noteapps.utils.popBackStackUntilRoot
import com.ngctien.noteapps.utils.replaceFragment

class SignInFragment : BaseFragment<FragmentSignInBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding?.apply {
            txtSignUp.setOnClickListener {
                requireActivity().replaceFragment(SignUpFragment(), true)
            }
            btnLogin.setOnClickListener {
                popBackStackUntilRoot()
                requireActivity().replaceFragment(NotesFragment(), true)
            }
        }
    }
}