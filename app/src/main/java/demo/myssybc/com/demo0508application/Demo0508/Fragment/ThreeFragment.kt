package demo.myssybc.com.demo0508application.Demo0508.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import demo.myssybc.com.demo0508application.R

class ThreeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.frag_three_layout, container, false)
        return view

    }




}