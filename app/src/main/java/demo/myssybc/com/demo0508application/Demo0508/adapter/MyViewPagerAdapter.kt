package demo.myssybc.com.demo0508application.Demo0508.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class MyViewPagerAdapter(context: Context, list: List<View>) : PagerAdapter() {

    private var context: Context
    private var list: List<View>

    init {
        this.context = context
        this.list = list

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container?.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container?.addView(list.get(position))
        return list.get(position)
    }
}