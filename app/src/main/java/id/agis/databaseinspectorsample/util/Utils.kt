package id.agis.databaseinspectorsample.util

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun formatDate(strDate: String): String {
    val date = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault()).parse(strDate)
    return if (date != null) {
        SimpleDateFormat("hh:mm EEE, d MMMM", Locale.getDefault()).format(date)
    } else {
        ""
    }
}