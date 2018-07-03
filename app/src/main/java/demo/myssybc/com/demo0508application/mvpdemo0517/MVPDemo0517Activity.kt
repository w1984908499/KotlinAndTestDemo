package demo.myssybc.com.demo0508application.mvpdemo0517

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import demo.myssybc.com.demo0508application.R
import kotlinx.android.synthetic.main.activity_mvp_demo.*
import org.jetbrains.anko.toast

class MVPDemo0517Activity : AppCompatActivity(), IMineItemView {
    override fun getId(): Int {
        var id = activity_mvp_edit_user_id.text.toString().trim()
        if (id.isNotEmpty())
            return 0
        else
            return id.toInt()
    }

    override fun getMineItemName(): String = activity_mvp_edit_user_name.text.toString()

    override fun getMineItemAge(): Int {
        var age = activity_mvp_edit_user_age.text.toString().trim()
        if (age.isNotEmpty())
            return 0
        else
            return age.toInt()
    }

    override fun setMineItemName(name: String) {
        activity_mvp_edit_user_name.setText(name)
    }

    override fun setMineItemAge(age: Int) {
        activity_mvp_edit_user_age.setText(age.toString())
    }

    override fun onSaveMineItemSuccess() {
        activity_mvp_edit_user_id.setText("")
        activity_mvp_edit_user_name.setText("")
        activity_mvp_edit_user_age.setText("")
        this.toast("MineItem保存成功")
    }

    override fun onLoadMineItemSuccess() {
        this.toast("MineItem载入失败")
    }

    private var mMineItemPresenter: MineItemPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_demo)
        mMineItemPresenter = MineItemPresenter(this)
        activity_mvp_btn_save.setOnClickListener {
            mMineItemPresenter!!.saveMineItem(getId(), getMineItemName(), getMineItemAge())
        }

        activity_mvp_btn_load.setOnClickListener {
            mMineItemPresenter!!.loadMineItem(getId())
        }

    }
}
