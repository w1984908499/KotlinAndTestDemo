package demo.myssybc.com.demo0508application.Demo0508.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_photo_view.*

class PhotoViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_view)

        var imgurl: String = intent.extras.get("imgurl") as String

        Glide.with(this).load(imgurl).error(R.mipmap.ic_launcher_round).placeholder(R.mipmap.ic_launcher).into(activity_photo_view_img_main)


    }
}
