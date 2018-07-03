package demo.myssybc.com.demo0508application.HttpUtils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class VolleyUtils(context: Context) {

    var context: Context? = null
    var requestQueue: RequestQueue? = null
    var CANNLE_TAG = 1000

    init {
        this.context = context
        requestQueue = Volley.newRequestQueue(context)
    }


    fun VolleyGet(url: String?, mListner: Response.Listener<JSONObject>, errorListener: Response.ErrorListener) {

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, mListner, errorListener)

        jsonObjectRequest.retryPolicy = DefaultRetryPolicy(5 * 1000, 0, 1.0f)

//        jsonObjectRequest.tag = tag
//        CANNLE_TAG = tag
        requestQueue!!.add(jsonObjectRequest)
    }


    fun VolleyPost(url: String?, jsonObject: JSONObject, mListner: Response.Listener<JSONObject>, errorListener: Response.ErrorListener) {
        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject, mListner, errorListener)

        jsonObjectRequest.retryPolicy = DefaultRetryPolicy(5 * 1000, 0, 1.0f)

//        jsonObjectRequest.tag = tag
//        CANNLE_TAG = tag
        requestQueue!!.add(jsonObjectRequest)
    }


    private val mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg!!.what) {

            }
        }
    }

}