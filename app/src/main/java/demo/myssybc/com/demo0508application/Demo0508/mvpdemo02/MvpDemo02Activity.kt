package demo.myssybc.com.demo0508application.Demo0508.mvpdemo02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.View
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_mvp_demo.*
import org.jetbrains.anko.toast

class MvpDemo02Activity : AppCompatActivity(), IMineUserView, View.OnClickListener {
    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.activity_mvp_btn_save -> {
                mineUserPresenter?.saveMineUser(getMineUserId(), getMineUsername(), getMineUserAge())


            }
            R.id.activity_mvp_btn_load -> {
                mineUserPresenter?.loadMineUser(getMineUserId())
            }
        }


    }


    private var mineUserPresenter: MineUserPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_demo)
        mineUserPresenter = MineUserPresenter(this)

        activity_mvp_btn_save.setOnClickListener(this)
        activity_mvp_btn_load.setOnClickListener(this)


    }


    override fun getMineUserId(): Int {
        val id = activity_mvp_edit_user_id.text.toString().trim()
        if (id.isNotEmpty())
            return id.toInt()
        else
            return 0
    }

    override fun getMineUsername(): String {
        val username = activity_mvp_edit_user_name.text.toString()
        if (username.isNotEmpty())
            return username
        else
            return "no found"

    }

    override fun getMineUserAge(): Int {
        val age = activity_mvp_edit_user_age.text.toString().trim()
        if (age.isNotEmpty())
            return age.toInt()
        else
            return 0
    }

    override fun setMineUsername(username: String) {
        activity_mvp_edit_user_name.setText(username)
    }

    override fun serMineUserAge(age: Int) {

        activity_mvp_edit_user_age.setText(age.toString())
    }

    override fun onSaveMineUserSuccess() {
        activity_mvp_edit_user_id.setText("")
        activity_mvp_edit_user_name.setText("")
        activity_mvp_edit_user_age.setText("")
        this.toast("保存成功")
    }

    override fun onLoadMineUserSuccess() {
        this.toast("载入成功")
    }

    private fun toEditable(text: String): Editable {
        val editable = SpannableStringBuilder(text)
        return editable
    }

}
