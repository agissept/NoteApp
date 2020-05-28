package id.agis.databaseinspectorsample.ui.notelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.agis.databaseinspectorsample.R
import id.agis.databaseinspectorsample.model.Note
import id.agis.databaseinspectorsample.ui.insertnote.InsertNoteActivity
import id.agis.databaseinspectorsample.viewmodel.NotesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class NotesActivity : AppCompatActivity() {
    private val listNote = mutableListOf<Note>()
    private val adapter =
        NotesAdapter(listNote)
    private val viewModel by lazy { ViewModelProviders.of(this).get(NotesViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = adapter

        viewModel.getNotes()
        viewModel.noteList.observe(this, Observer {
            listNote.clear()
            listNote.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add) {
            val intent = Intent(this, InsertNoteActivity::class.java)
            startActivity(intent)
        }
        return true
    }
}
