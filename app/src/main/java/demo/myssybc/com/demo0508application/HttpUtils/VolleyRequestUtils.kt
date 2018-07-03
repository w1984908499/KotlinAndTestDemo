package demo.myssybc.com.demo0508application.HttpUtils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

object VolleyRequestUtils {
    const val Flag = "OK"
    const val MESSAGE_WHAT = 1001
    var CANNEL_FLAG: Int? = 1000
    val nowDateTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }


    fun volleyGet(url: String?, jsonObject: JSONObject, cancleFlag: Int, context: Context) {
        var requestQueue = Volley.newRequestQueue(context)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, jsonObject, Response.Listener<JSONObject> {


        }, Response.ErrorListener {
            mHandler.sendEmptyMessage(MESSAGE_WHAT)
        })

        jsonObjectRequest.retryPolicy = DefaultRetryPolicy(5 * 1000, 0, 1.0f)

        jsonObjectRequest.tag = cancleFlag
        CANNEL_FLAG = cancleFlag
        requestQueue.add(jsonObjectRequest)


    }


    private val mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
//                MESSAGE_WHAT->requestQueue
            }

        }
    }
}