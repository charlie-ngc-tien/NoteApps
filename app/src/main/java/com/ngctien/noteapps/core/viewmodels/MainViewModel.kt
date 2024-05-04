package com.ngctien.noteapps.core.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ngctien.noteapps.data.Note
import java.util.Calendar
import java.util.UUID

class MainViewModel : ViewModel() {
    private val _notesLiveData: MutableLiveData<List<Note>> = MutableLiveData(emptyList())
    val notesLiveData: LiveData<List<Note>> get() = _notesLiveData

    fun saveNote(title: String, content: String) {
        val note = Note(
            id = UUID.randomUUID().toString(),
            title = title,
            content = content,
            createdDate = Calendar.getInstance().time
        )
        _notesLiveData.postValue(notesLiveData.value?.plus(note) ?: listOf(note))
    }
}