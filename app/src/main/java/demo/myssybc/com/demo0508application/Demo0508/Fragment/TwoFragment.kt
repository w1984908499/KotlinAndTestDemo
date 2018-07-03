package demo.myssybc.com.demo0508application.Demo0508.Fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import demo.myssybc.com.demo0508application.Demo0508.activity.PhotoViewActivity
import demo.myssybc.com.demo0508application.Demo0508.adapter.MyKotlinListViewAdapter
import demo.myssybc.com.demo0508application.Demo0508.entity.MenuItem
import demo.myssybc.com.demo0508application.MyAppliction
import demo.myssybc.com.demo0508application.R
import demo.myssybc.com.demo0508application.Utils.MenuCacheUtil
import kotlinx.android.synthetic.main.frag_two_layout.*
import org.json.JSONArray
import org.json.JSONObject
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x

class TwoFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_save_list -> {

                MenuCacheUtil(this@TwoFragment.requireContext(), "name").setDataList("itemList", menuList)
                MyAppliction.application?.itemsList = menuList
            }
            R.id.btn_load_list -> {
                MyAppliction.application?.itemsList = null
                var list: List<MenuItem> = MyAppliction.application?.itemsList
                        ?: MenuCacheUtil(this@TwoFragment.requireContext(), "name").getDataList("itemList")
                listview_frag_two.adapter = MyKotlinListViewAdapter(list, this@TwoFragment.requireContext())
            }
        }
    }

    //静态常量
    companion object {
        const val url: String = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/2"
        const val MESSAGE_WHAT = 1001
        const val FLAG_KEY = "FLAG"
        const val INDEX_KEY = "INDEX"
        const val NAME_KEY = "NAME"
    }

    var menuList = ArrayList<MenuItem>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.frag_two_layout, container, false)
        var btn_save_list: Button = view.findViewById(R.id.btn_save_list) as Button
        var btn_load_list: Button = view.findViewById(R.id.btn_load_list) as Button
        btn_save_list.setOnClickListener(this)
        btn_load_list.setOnClickListener(this)
        setData()
//        getData(url)

        volleyGet(url)

        return view
    }

    private fun setData() {
        var data = ArrayList<String>()
        for (i in 0..10) {
            data.add("ListView \t" + i)
        }
    }

    /**
     * Kotlin xUtils Get请求
     */
    private fun xUtilsGet(url: String?) {
        var requestParams = RequestParams(url)
        //添加请求参数
//        requestParams.addQueryStringParameter("","")
        x.http().get(requestParams, object : Callback.CommonCallback<String> {
            override fun onFinished() {
            }

            override fun onCancelled(p0: Callback.CancelledException?) {
            }

            override fun onSuccess(p0: String?) {
                Log.e("onSuccess", p0)
            }

            override fun onError(p0: Throwable?, p1: Boolean) {
                Log.e("onError", p0?.message)
            }

        })
    }

    /**
     * kotlin 使用Volley通过发送Get请求
     */
    private fun volleyGet(url: String?) {
        var requestQueue = Volley.newRequestQueue(this@TwoFragment.context)
        var jsonObject = JSONObject()
//        jsonObject.put("","")

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener<JSONObject> { p0 ->
            Log.e("volleyGet onSuccess", p0.toString())
            val jsonObject = JSONObject(p0.toString())
            val key: String = jsonObject.optString("results")
            val jsonArray = JSONArray(key)

            for (i in 0..(jsonArray.length() - 1)) {
                var obj: JSONObject = jsonArray.getJSONObject(i) as JSONObject
//                var _id: String = obj.optString("_id")
//                var url: String = obj.optString("url")
                var menuItem = MenuItem()
                menuItem.url = obj.optString("url")
                menuItem._id = obj.optString("_id")
                menuList.add(menuItem)

            }


//            listview_frag_two.adapter = MyKotlinListViewAdapter(menuList, this@TwoFragment.requireContext())


            listview_frag_two.setOnItemClickListener { parent, view, position, id ->
                var intent = Intent(this@TwoFragment.activity, PhotoViewActivity::class.java)
                intent.putExtra("imgurl", menuList.get(position).url)
                startActivity(intent)
            }

        }, Response.ErrorListener { p0 ->
            Log.e("volley onErrorResponse", p0?.message)
            mHandler.sendEmptyMessage(MESSAGE_WHAT)
        })

        jsonObjectRequest.retryPolicy = DefaultRetryPolicy(5 * 1000, 0, 1.0f)

        jsonObjectRequest.tag = 1000

        requestQueue.add(jsonObjectRequest)


    }

    /**
     * Kotlin Handler 的写法
     */
    private val mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
                MESSAGE_WHAT -> {
                    Log.e("Kotlin", "接收通过sendEmptyMessage()发送过来的消息")
                }
            // 这里的else相当于Java中switch的default;
                else -> {
                    val mBundle = msg?.data
                    Log.e("接收到的数据", mBundle?.getInt(INDEX_KEY).toString())
                    Log.e("接收到的数据", mBundle?.getString(NAME_KEY))
                    Log.e("接收到的数据", mBundle?.getBoolean(FLAG_KEY).toString())
                }
            }
        }
    }
}