package demo.myssybc.com.demo0508application.mvpdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_mvp_demo.*
import org.jetbrains.anko.toast


class MVPDemoActivity : AppCompatActivity(), IUserView, View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.activity_mvp_btn_save -> mUserPresenter?.saveUser(getID(), getUsername(), getAge())
            R.id.activity_mvp_btn_load -> mUserPresenter?.loadUser(getID())

        }
    }

    private var mUserPresenter: UserPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_demo)

        mUserPresenter = UserPresenter(this)
        activity_mvp_btn_save.setOnClickListener(this)
        activity_mvp_btn_load.setOnClickListener(this)

    }


    override fun getID(): Int {
        val id = activity_mvp_edit_user_id.text.toString().trim()
        if (id.isNotEmpty())
            return id.toInt()
        else
            return 0

    }

    override fun getUsername(): String = activity_mvp_edit_user_name.text.toString()


    override fun getAge(): Int {
        val age = activity_mvp_edit_user_age.text.toString().trim()
        if (age.isNotEmpty())
            return age.toInt()
        else
            return 0
    }

    override fun setUsername(username: String) {
        Log.e("MVP_Activity", "setUserName:$username")
        activity_mvp_edit_user_name.text = toEditable(username)

    }

    override fun setAge(age: Int) {
        Log.e("MVP_Activity", "setAge:$age")
        activity_mvp_edit_user_age.text = toEditable(age.toString())


    }

    override fun onSaveSuccess() {
        activity_mvp_edit_user_id.setText("")
        activity_mvp_edit_user_name.setText("")
        activity_mvp_edit_user_age.setText("")
        this.toast("保存成功")


    }


    /**
     * String 转Editable
     */
    private fun toEditable(text: String): Editable {
        val editable: Editable = SpannableStringBuilder(text)
        return editable
    }

}
