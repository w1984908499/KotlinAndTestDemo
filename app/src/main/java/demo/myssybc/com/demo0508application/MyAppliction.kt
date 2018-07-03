package demo.myssybc.com.demo0508application

import android.app.Application
import demo.myssybc.com.demo0508application.Demo0508.entity.MenuItem
import org.xutils.x

class MyAppliction : Application() {

    var itemsList: List<MenuItem>? = null

    companion object {
        var application: MyAppliction? = null
    }


    override fun onCreate() {
        super.onCreate()
        x.Ext.init(this)
        application = this

    }
}