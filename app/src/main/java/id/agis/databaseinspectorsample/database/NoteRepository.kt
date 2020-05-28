package id.agis.databaseinspectorsample.database

import android.app.Application
import id.agis.databaseinspectorsample.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class NoteRepository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var noteDao: NoteDao? = null

    init {
        val db = NoteDatabase.getDatabase(application)
        noteDao = db?.noteDao()
    }

    fun getNoteList() = noteDao?.getNoteList()

    fun getNoteById(id: Int) = noteDao?.getNoteById(id)


    fun insertNote(note: Note) {
        launch {
            withContext(Dispatchers.IO) {
                noteDao?.insertNote(note)
            }
        }
    }

    fun deleteNote(note: Note) {
        launch {
            withContext(Dispatchers.IO) {
                noteDao?.deleteNote(note)
            }
        }
    }

    fun updateNote(note: Note) {
        launch {
            withContext(Dispatchers.IO) {
                noteDao?.updateNote(note)
            }
        }
    }


}