package id.agis.databaseinspectorsample.ui.insertnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import id.agis.databaseinspectorsample.R
import id.agis.databaseinspectorsample.model.Note
import id.agis.databaseinspectorsample.util.toast
import id.agis.databaseinspectorsample.viewmodel.NotesViewModel
import kotlinx.android.synthetic.main.activity_insert_note.*
import java.text.SimpleDateFormat
import java.util.*

class InsertNoteActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(NotesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_note)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault())
        val currentDate = sdf.format(Date())

        btn_insert.setOnClickListener {
            val note = Note(null, ed_title.text.toString(), ed_note.text.toString(), currentDate)
            viewModel.insertNote(note)
            toast("Note Berhasil Disimpan")
            finish()
        }
    }

}