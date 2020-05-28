package id.agis.databaseinspectorsample.viewmodel

import android.app.Application
import androidx.lifecycle.*
import id.agis.databaseinspectorsample.database.NoteRepository
import id.agis.databaseinspectorsample.model.Note

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var _noteList: LiveData<List<Note>>
    val noteList get() = _noteList
    private lateinit var _note: LiveData<Note>
    val note get() = _note
    private val noteRepository = NoteRepository(application)

    fun insertNote(note: Note) {
        noteRepository.insertNote(note)
    }

    fun getNotes() {
        noteRepository.getNoteList()?.let {
            _noteList = it
        }
    }

    fun getNoteById(id: Int) {
        noteRepository.getNoteById(id)?.let {
            _note = it
        }
    }

    fun deleteNote(note: Note) {
        noteRepository.deleteNote(note)
    }

    fun updateNote(note: Note) {
        noteRepository.updateNote(note)
    }


}