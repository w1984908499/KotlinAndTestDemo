package demo.myssybc.com.demo0508application.Demo0508.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import demo.myssybc.com.demo0508application.Demo0508.entity.MenuItem
import demo.myssybc.com.demo0508application.Demo0508.view.PhotoView
import demo.myssybc.com.demo0508application.R

public class MyRecyclerViewAdapter(list: List<MenuItem>, context: Context, onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)

        var viewHolder: ViewHolder = ViewHolder(view)


        return viewHolder
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list!!.get(position).url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).into(holder.logo)
        holder.title.text = list!!.get(position).who
        holder.time.text = list!!.get(position).type


        holder.recycler_view_item_root.setOnClickListener {
            onItemClickListener!!.onclick(holder.recycler_view_item_root, position)
        }


    }


    var list: List<MenuItem>? = null
    var context: Context? = null

    init {
        this.context = context
        this.list = list
        this.onItemClickListener = onItemClickListener

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var logo: PhotoView = itemView.findViewById(R.id.img_recyler_view_logo) as PhotoView
        var title: TextView = itemView.findViewById(R.id.tv_recycler_title) as TextView
        val time: TextView = itemView.findViewById(R.id.tv_recycler_time) as TextView
        var recycler_view_item_root: ConstraintLayout = itemView.findViewById(R.id.recycler_view_item_root) as ConstraintLayout

    }


    interface OnItemClickListener {
        fun onclick(view: View, position: Int)
    }


}