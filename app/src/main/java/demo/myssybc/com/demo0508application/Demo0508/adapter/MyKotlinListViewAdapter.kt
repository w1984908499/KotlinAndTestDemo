package demo.myssybc.com.demo0508application.Demo0508.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import demo.myssybc.com.demo0508application.Demo0508.entity.MenuItem
import demo.myssybc.com.demo0508application.Demo0508.view.PhotoView
import demo.myssybc.com.demo0508application.R

/**
 * Kotlin 写ListViewAdapter
 */
class MyKotlinListViewAdapter(list: List<MenuItem>?, context: Context) : BaseAdapter() {

    var list: List<MenuItem>? = null
    var context: Context? = null

    //初始化
    init {
        this.list = list
        this.context = context
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var viewHolder: ViewHolder
        var view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_list_view, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.logo.enable()
        viewHolder.name.text = list!!.get(position)._id
        Glide.with(context).load(list!!.get(position).url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).into(viewHolder.logo)
        var info = viewHolder.logo.info
        viewHolder.logo.animaTo(info, object : Runnable {
            override fun run() {

            }

        })

        viewHolder.logo.animaDuring = 2000
        viewHolder.logo.maxScale = 3.0f


        return view
    }

    override fun getItem(position: Int): Any {

        return list!!.get(position)
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {
        return list!!.size
    }

    class ViewHolder(var viewItem: View) {
        var name: TextView = viewItem.findViewById(R.id.tv_list_item_name) as TextView
        var logo: PhotoView = viewItem.findViewById(R.id.img_list_item_logo) as PhotoView
    }
}