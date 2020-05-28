package id.agis.databaseinspectorsample.ui.notelist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.agis.databaseinspectorsample.R
import id.agis.databaseinspectorsample.model.Note
import id.agis.databaseinspectorsample.ui.detailnote.DetailNoteActivity
import id.agis.databaseinspectorsample.util.formatDate
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(private val noteList: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = noteList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = noteList[position]
        with(holder.itemView) {
            tv_title.text = note.title
            tv_note.text = note.note
            tv_date.text = formatDate(note.date)
            setOnClickListener {
                val intent = Intent(it.context, DetailNoteActivity::class.java)
                intent.putExtra("noteId", note.id)
                it.context.startActivity(intent)
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}