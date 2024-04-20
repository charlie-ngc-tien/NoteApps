package com.ngctien.noteapps.features.authentication.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ngctien.noteapps.databinding.ActivitySignInBinding
import com.ngctien.noteapps.features.notes.views.NotesActivity

class SignInActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivitySignInBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.txtSignUp.setOnClickListener(::goToSignUp)
        binding.btnLogin.setOnClickListener(::goToNotesPage)
    }

    private fun goToNotesPage(view: View?) {
        // TODO: checking account
        Intent(this, NotesActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }

    private fun goToSignUp(view: View) {
        Intent(this, SignUpActivity::class.java).run {
            startActivity(this)
        }
    }
}