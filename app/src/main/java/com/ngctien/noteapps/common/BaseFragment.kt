package com.ngctien.noteapps.common

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ngctien.noteapps.databinding.CustomToolBarBinding

open class BaseFragment<T : ViewBinding> : Fragment() {
    protected var binding: T? = null
    protected var toolBarBinding: CustomToolBarBinding? = null

    override fun onDestroyView() {
        binding = null
        toolBarBinding = null
        super.onDestroyView()
    }
}