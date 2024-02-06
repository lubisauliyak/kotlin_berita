package sekolahbeta.lubisa.wartakotawae

import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sekolahbeta.lubisa.wartakotawae.data.APIService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btGeneral = findViewById<Button>(R.id.bt_general)
        val btBusiness = findViewById<Button>(R.id.bt_business)
        val btEntertain = findViewById<Button>(R.id.bt_entertain)
        val btHealth = findViewById<Button>(R.id.bt_health)
        val btScience = findViewById<Button>(R.id.bt_science)
        val btSport = findViewById<Button>(R.id.bt_sport)
        val btTech = findViewById<Button>(R.id.bt_tech)
        val svSearch = findViewById<SearchView>(R.id.sv_search)

        val rvNews = findViewById<RecyclerView>(R.id.rv_news)

        val coroutineExceptionHandler =
            CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }

        GlobalScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            val resp = retrofitService().getNewsList(
                getString(R.string.country),
                "general",
                "",
                getString(R.string.api_key)
            )

            if (resp.isSuccessful) {
                val newNewsData = resp.body()?.articles
                rvNews.adapter = NewsListAdapter().apply {
                    setNewData(newNewsData.orEmpty())
                }
            }
        }
    }

    fun retrofitService(): APIService {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
            .create(APIService::class.java)
    }
}