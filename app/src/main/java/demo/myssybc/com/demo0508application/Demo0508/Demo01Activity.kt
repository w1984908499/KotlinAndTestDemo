package demo.myssybc.com.demo0508application.Demo0508

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import demo.myssybc.com.demo0508application.Demo0508.Fragment.TwoFragment
import demo.myssybc.com.demo0508application.Demo0508.adapter.MyRecyclerViewAdapter
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_demo01.*
import kotlinx.coroutines.experimental.async
import java.net.URL
import org.jetbrains.anko.toast

class Demo01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        hideActionBar()
        setContentView(R.layout.activity_demo01)
//        val key = intent.extras["key"]!!
//        tv_demo01_show_msg.text = key.toString()

        tv_demo01_show_msg.setOnClickListener {
            getUrl()

        }
        recycler_view_01.layoutManager=LinearLayoutManager(this)
//        recycler_view_01.adapter=MyRecyclerViewAdapter(null,this)
        recycler_view_01.adapter



    }

    fun getUrl() {
        async {
            val forecastJsonStr = URL(TwoFragment.url).readText()
            Log.e("forecastJsonStr", forecastJsonStr)

            runOnUiThread {
                tv_demo01_show_msg.text = forecastJsonStr
                this@Demo01Activity.toast(forecastJsonStr)
            }
        }
    }

    fun hideActionBar() {
        if (actionBar.isShowing) {
            actionBar.hide()
        }
    }
}
