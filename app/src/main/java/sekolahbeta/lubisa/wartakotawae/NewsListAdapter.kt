package sekolahbeta.lubisa.wartakotawae

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sekolahbeta.lubisa.wartakotawae.data.ArticlesItem

class NewsListAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    val newsArticlesList: MutableList<ArticlesItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_news_holder, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val dataArticles = newsArticlesList[position]
        holder.tvTitle.text = dataArticles.title
        holder.tvSource.text = dataArticles.source?.name
        Picasso.get().load("${dataArticles.urlToImage}").into(holder.ivCover)

        holder.itemView.setOnClickListener {
            val newsIntent = dataNews(
                dataArticles.title.toString(),
                dataArticles.urlToImage.toString(),
                dataArticles.source?.name.toString(),
                dataArticles.publishedAt.toString(),
                dataArticles.description.toString(),
                dataArticles.content.toString(),
                dataArticles.url.toString()
            )

            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DETAIL_NEWS, newsIntent)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsArticlesList.size
    }

    fun setNewData(data: List<ArticlesItem>) {
        newsArticlesList.clear()
        newsArticlesList.addAll(data)
        notifyDataSetChanged()
    }
}