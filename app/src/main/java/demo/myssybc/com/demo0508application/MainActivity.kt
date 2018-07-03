package demo.myssybc.com.demo0508application

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Response
import demo.myssybc.com.demo0508application.Demo0508.Fragment.TwoFragment
import demo.myssybc.com.demo0508application.Demo0508.Guide2Activity
import demo.myssybc.com.demo0508application.Demo0508.GuideActivity
import demo.myssybc.com.demo0508application.Demo0508.entity.MenuItem
import demo.myssybc.com.demo0508application.Demo0508.mvpdemo02.MvpDemo02Activity
import demo.myssybc.com.demo0508application.Demo0619.FingerPrintDemo2Activity
import demo.myssybc.com.demo0508application.Demo0619.KotlinFingerPrintTestActivity
import demo.myssybc.com.demo0508application.HttpUtils.HttpTools
import demo.myssybc.com.demo0508application.HttpUtils.VolleyUtils
import demo.myssybc.com.demo0508application.R.id.*
import kotlinx.android.synthetic.main.activity_main.*;
import kotlinx.coroutines.experimental.async
import org.json.JSONObject
import java.net.URL
import org.jetbrains.anko.toast
import org.xutils.common.Callback
import org.xutils.http.RequestParams

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.activity_main_tv_volley_get -> {
                VolleyUtils(this).VolleyGet(moneyUrl, Response.Listener {
                    Log.e("理财VolleyGet", it.toString())
                }, Response.ErrorListener {
                    //            VolleyUtils(this).requestQueue!!.cancelAll(10001)
                    Log.e("理财VolleyGetError", it.toString())

                })
            }
            R.id.activity_main_tv_volley_post -> {
                var jsonObject = JSONObject()
                jsonObject.put("_MChannelId", "PMBS")
                jsonObject.put("_locale", "zh_CN")
                jsonObject.put("LoginType", "T")
                VolleyUtils(this).VolleyPost(moneyUrl, jsonObject, Response.Listener {
                    Log.e("理财VolleyPost", it.toString())
                }, Response.ErrorListener {
                    //            VolleyUtils(this).requestQueue!!.cancelAll(10001)
                    Log.e("理财VolleyPostError", it.toString())

                })
            }

            R.id.activity_main_tv_xutils_get -> {

                HttpTools().xUtilsGet(moneyUrl, object : Callback.CommonCallback<String> {
                    override fun onFinished() {
                    }

                    override fun onSuccess(p0: String?) {
                        Log.e("理财xUtilsGetonSuccess", p0)
                    }

                    override fun onCancelled(p0: Callback.CancelledException?) {
                    }

                    override fun onError(p0: Throwable?, p1: Boolean) {
                        Log.e("理财xUtilsGetError", p0!!.message)
                    }

                })
            }
            R.id.activity_main_tv_xutils_post -> {

                var requestParams = RequestParams(moneyUrl)
                requestParams.addQueryStringParameter("_MChannelId", "PMBS")
                requestParams.addQueryStringParameter("_locale", "zh_CN")
                requestParams.addQueryStringParameter("LoginType", "T")
                HttpTools().xUtilsPost(requestParams, object : Callback.CommonCallback<String> {
                    override fun onFinished() {
                    }

                    override fun onSuccess(p0: String?) {
                        Log.e("理财xUtilsPostonSuccess", p0)
                    }

                    override fun onCancelled(p0: Callback.CancelledException?) {
                    }

                    override fun onError(p0: Throwable?, p1: Boolean) {
                        Log.e("理财xUtilsPostError", p0!!.message)
                    }

                })

            }
            R.id.btn_go_mvp_demo_01 -> {
                startActivity(Intent(this, MvpDemo02Activity::class.java))
            }

        }
    }

    companion object {
        var moneyUrl: String = "http://119.6.121.123:9091/pweb/FinProDetailQry.do"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get()
        btn_go_demo_02.text = "跳转到Demo2"
        btn_go_demo_02.setOnClickListener {
            jump()

        }
        tv_go_demo_01.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, GuideActivity::class.java)
            intent.putExtra("key", "wang")
            startActivity(intent)
        }

        tv_go_guide_02.setOnClickListener {
            startActivity(Intent(this, FingerPrintDemo2Activity::class.java))
        }


        tv_go_demo_03.setOnClickListener {
            startActivity(Intent(this, KotlinFingerPrintTestActivity::class.java))
        }
        activity_main_tv_volley_get.setOnClickListener(this)
        activity_main_tv_volley_post.setOnClickListener(this)
        activity_main_tv_xutils_get.setOnClickListener(this)
        activity_main_tv_xutils_post.setOnClickListener(this)
        btn_go_mvp_demo_01.setOnClickListener(this)

    }

    private fun jump() {
        val intent = Intent();
        intent.action = "demo.myssybc.com.demo0508application.DEMO2ACTION"
        startActivity(intent)


    }


    fun getUrl() {
        async {
            val forecastJsonStr = URL(TwoFragment.url).readText()
            Log.e("forecastJsonStr", forecastJsonStr)
//            runOnUiThread {
//                btn_go_demo_02.text=forecastJsonStr
//            }
            btn_go_demo_02.text = forecastJsonStr
        }
    }

    fun get() {

    }


}
