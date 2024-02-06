package sekolahbeta.lubisa.wartakotawae

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val ivCover = view.findViewById<ImageView>(R.id.iv_cover)
    val tvTitle = view.findViewById<TextView>(R.id.tv_title)
    val tvSource = view.findViewById<TextView>(R.id.tv_source)
}