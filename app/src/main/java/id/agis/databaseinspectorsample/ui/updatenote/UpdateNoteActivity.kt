package id.agis.databaseinspectorsample.ui.updatenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import id.agis.databaseinspectorsample.R
import id.agis.databaseinspectorsample.model.Note
import id.agis.databaseinspectorsample.util.toast
import id.agis.databaseinspectorsample.viewmodel.NotesViewModel
import kotlinx.android.synthetic.main.activity_update_note.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateNoteActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProviders.of(this).get(NotesViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        var note = intent.getParcelableExtra<Note>("note")
        note?.let {
            ed_title.setText(it.title)
            ed_note.setText(it.note)
        }


        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault())
        val currentDate = sdf.format(Date())

        btn_update.setOnClickListener {
            note = Note(note.id, ed_title.text.toString(), ed_note.text.toString(), currentDate)
            note?.let {
                viewModel.updateNote(note)
            }
            toast("Note Berhasil Diupdate")
            finish()
        }
    }
}