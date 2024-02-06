package sekolahbeta.lubisa.wartakotawae

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class dataNews(
    val titleNews : String,
    val imageNews : String,
    val sourceNews : String,
    val dateNews : String,
    val descNews : String,
    val contentNews : String,
    val urlNews : String ) : Parcelable
