package com.ngctien.noteapps.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.ngctien.noteapps.R
import java.text.SimpleDateFormat
import java.util.Date

fun FragmentActivity.replaceFragment(
    fragment: Fragment,
    needAddToStack: Boolean = false
) {
    supportFragmentManager.commit {
        replace(R.id.main_fragment, fragment)
        setReorderingAllowed(true)
        if (needAddToStack) {
            addToBackStack(fragment::class.simpleName)
        }
    }
}

fun Fragment.popBackStack() {
    requireActivity().supportFragmentManager.popBackStack()
}

fun Fragment.popBackStackUntilRoot() {
    requireActivity().supportFragmentManager.popBackStack(
        this::class.simpleName,
        FragmentManager.POP_BACK_STACK_INCLUSIVE
    )
}

fun Date.format(): String {
    return SimpleDateFormat("dd MMMM YYYY, hh:mm a").format(this)
}