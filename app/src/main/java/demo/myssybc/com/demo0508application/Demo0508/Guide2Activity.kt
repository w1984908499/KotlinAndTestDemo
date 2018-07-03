package demo.myssybc.com.demo0508application.Demo0508

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import demo.myssybc.com.demo0508application.Demo0508.adapter.MyViewPagerAdapter
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_guide2.*
import kotlinx.android.synthetic.main.frag_three_layout.*
import kotlinx.android.synthetic.main.frag_two_layout.*

/**
 * 使用View的引導頁
 */
class Guide2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide2)
        var viewList = ArrayList<View>()
        viewList.add(layoutInflater.inflate(R.layout.frag_one_layout, null))
        viewList.add(layoutInflater.inflate(R.layout.frag_two_layout, null))
        viewList.add(layoutInflater.inflate(R.layout.frag_three_layout, null))

        viewpager_guide_02.adapter = MyViewPagerAdapter(this, viewList)
        viewpager_guide_02.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    1->setData()
                    2 ->img_frag_three_bg.setOnClickListener {
                        startActivity(Intent(this@Guide2Activity,Demo02Activity::class.java))
                    }
                }
            }

        })


    }

    private fun showMsg(key: String) {
        Toast.makeText(this, key, Toast.LENGTH_SHORT).show()
    }

    fun setData() {
        var data = ArrayList<String>()
        for (i in 0..20) {
            data.add("ABC" + i)
        }

        listview_frag_two.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        listview_frag_two.setOnItemClickListener { parent, view, position, id ->
            showMsg(data.get(position))
        }
    }

}
