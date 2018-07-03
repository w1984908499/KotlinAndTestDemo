package demo.myssybc.com.demo0508application.HttpUtils

import android.content.Context
import org.json.JSONObject
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x

class HttpTools {
    fun xUtilsGet(url: String, callback: Callback.CommonCallback<String>) {
        var requestParams = RequestParams(url)
        x.http().get(requestParams, callback)
    }

    fun xUtilsPost(requestParams: RequestParams, callback: Callback.CommonCallback<String>) {
        x.http().post(requestParams, callback)
    }
}