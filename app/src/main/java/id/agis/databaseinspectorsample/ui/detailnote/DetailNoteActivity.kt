package id.agis.databaseinspectorsample.ui.detailnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import id.agis.databaseinspectorsample.R
import id.agis.databaseinspectorsample.model.Note
import id.agis.databaseinspectorsample.ui.updatenote.UpdateNoteActivity
import id.agis.databaseinspectorsample.util.toast
import id.agis.databaseinspectorsample.viewmodel.NotesViewModel
import kotlinx.android.synthetic.main.activity_detail_note.*

class DetailNoteActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProviders.of(this).get(NotesViewModel::class.java) }
    lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)

        val noteId = intent.getIntExtra("noteId", 0)
        viewModel.getNoteById(noteId)
        viewModel.note.observe(this, observer)
    }

    private val observer = Observer { it: Note ->
        tv_title.text = it.title
        tv_note.text = it.note
        tv_date.text = it.date
        note = it
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_delete) {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Anda yakin akan menghapus note ini")
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton("Ya") { _, _ ->
                    viewModel.deleteNote(note)
                    viewModel.note.removeObserver(observer)
                    toast("Note Berhasil Dihapus")
                    finish()
                }
                .show()
        } else if (item.itemId == R.id.action_update) {
            val intent = Intent(this, UpdateNoteActivity::class.java)
            intent.putExtra("note", note)
            startActivity(intent)
        }
        return true
    }
}