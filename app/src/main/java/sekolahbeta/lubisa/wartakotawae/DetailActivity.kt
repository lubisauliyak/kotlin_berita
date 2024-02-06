package sekolahbeta.lubisa.wartakotawae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle = findViewById<TextView>(R.id.tv_title_detail)
        val tvDate = findViewById<TextView>(R.id.tv_date)
        val tvSource = findViewById<TextView>(R.id.tv_source_detail)
        val ivCover = findViewById<ImageView>(R.id.iv_cover_detail)
        val tvDesc = findViewById<TextView>(R.id.tv_desc)
        val tvContent = findViewById<TextView>(R.id.tv_content)
        val btShare = findViewById<Button>(R.id.bt_share)
        val btMore = findViewById<Button>(R.id.bt_more)
        val news = intent.getParcelableExtra<dataNews>(DETAIL_NEWS)

        tvTitle.text = news?.titleNews
        tvDate.text = news?.dateNews
        tvSource.text = news?.sourceNews
        Picasso.get().load("${news?.imageNews}").into(ivCover)
        tvDesc.text = news?.descNews
        tvContent.text = news?.contentNews
    }

    companion object {
        const val DETAIL_NEWS = "detail_news"
    }
}