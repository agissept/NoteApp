package id.agis.databaseinspectorsample.ui.insertnote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import id.agis.databaseinspectorsample.database.NoteRepository
import id.agis.databaseinspectorsample.model.Note

class InsertNoteViewModel(application: Application) : AndroidViewModel(application) {
    private val noteRepository = NoteRepository(application)

    fun insertNote(note: Note){
        noteRepository.insertNote(note)
    }
}