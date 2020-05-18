package id.agis.databaseinspectorsample.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.agis.databaseinspectorsample.model.Note

@Dao
interface NoteDao{
    @Query("SELECT * FROM note")
     fun getNoteList(): LiveData<List<Note>>

    @Insert
    fun insertNote(note: Note)
}