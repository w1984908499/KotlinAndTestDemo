package demo.myssybc.com.demo0508application.Demo0508

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.widget.ArrayAdapter
import android.widget.Toast
import demo.myssybc.com.demo0508application.Demo0508.Fragment.FragmentOne
import demo.myssybc.com.demo0508application.Demo0508.Fragment.ThreeFragment
import demo.myssybc.com.demo0508application.Demo0508.Fragment.TwoFragment
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_guide.*
import kotlinx.android.synthetic.main.frag_one_layout.*
import kotlinx.android.synthetic.main.frag_three_layout.*
import kotlinx.android.synthetic.main.frag_two_layout.*
import java.util.ArrayList

/**
 * 使用Fragment的引导页
 */
class GuideActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)


        var list = ArrayList<Fragment>()
        list.add(FragmentOne())
        list.add(TwoFragment())
        list.add(ThreeFragment())

        var twoFragment = TwoFragment()


        val fragmentList = listOf<Fragment>(FragmentOne(),
                TwoFragment(), ThreeFragment())
        viewpager_guide.adapter = viewPagerAdapter(supportFragmentManager, fragmentList)
        viewpager_guide.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> cb_frag_one.isChecked = true
//                    1 -> cb_frag_two.isChecked = true
//                    1 -> setList()
                    2 -> cb_frag_three.isChecked = true
                }

            }

        })

    }

    private fun setList() {
        var data = ArrayList<String>()
        for (i in 0..15) {
            data.add("条码" + i)
        }

        listview_frag_two.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        listview_frag_two.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, data.get(position), Toast.LENGTH_SHORT).show()
        }

    }

    class viewPagerAdapter(fm: FragmentManager?, var list: List<Fragment>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}
