package demo.myssybc.com.demo0508application.Demo0508.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import demo.myssybc.com.demo0508application.R

class FragmentOne : Fragment() {

    var url: String = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/2"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.frag_one_layout, container, false)

        getData()

        return view
    }

    private fun getData() {
//        val gson = Gson()
//        async{
//
//        }

//        Request(url).run()

    }
}