package id.agis.databaseinspectorsample.database

import androidx.lifecycle.LiveData
import androidx.room.*
import id.agis.databaseinspectorsample.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNoteList(): LiveData<List<Note>>

    @Query("SELECT * FROM note WHERE id =:id")
    fun getNoteById(id: Int): LiveData<Note>

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

}