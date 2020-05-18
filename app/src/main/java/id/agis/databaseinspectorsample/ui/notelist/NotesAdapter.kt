package id.agis.databaseinspectorsample.ui.notelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.agis.databaseinspectorsample.R
import id.agis.databaseinspectorsample.model.Note
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.SimpleDateFormat
import java.util.*


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
            val date = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault()).parse(note.date)
            val formattedDate =
                SimpleDateFormat("hh:mm EEE, d MMMM", Locale.getDefault()).format(date!!)
            tv_date.text = formattedDate
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}