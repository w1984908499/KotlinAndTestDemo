package demo.myssybc.com.demo0508application.HttpUtils

import android.util.Log
import java.net.URL

public class Request(val url: String) {
    public fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.e("请求返回数据", forecastJsonStr)
    }
}