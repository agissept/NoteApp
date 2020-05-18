package id.agis.databaseinspectorsample.ui.notelist

import android.app.Application
import androidx.lifecycle.*
import id.agis.databaseinspectorsample.database.NoteRepository
import id.agis.databaseinspectorsample.model.Note

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var _noteList: LiveData<List<Note>>
    val noteList get() = _noteList
    private val noteRepository = NoteRepository(application)

    fun getNotes() {
        noteRepository.getNoteList()?.let {
            _noteList = it
        }
    }


}