package demo.myssybc.com.demo0508application.Demo0508.mvpdemo02

import android.util.SparseArray
import java.util.ArrayList

/**
 * 第四步创建model实现类
 * 具体逻辑实现
 */
class MineUserModel : IMineUserModel {

    private var id: Int = 0
    private var username: String = ""
    private var age: Int = 0
    private val mUserArray = SparseArray<MineUser>()

    override fun setMineUserId(id: Int) {
        this.id = id
    }

    override fun setMineUserName(username: String) {
        this.username = username
    }

    override fun setMineUserAge(age: Int) {
        this.age = age
    }

    override fun saveMineUser() {

        mUserArray.append(id, MineUser(username, age))
    }

    override fun loadMineUser(id: Int): MineUser {
        return mUserArray.get(id, MineUser("not found", 0))
    }

}