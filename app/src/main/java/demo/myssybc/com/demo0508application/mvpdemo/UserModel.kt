package demo.myssybc.com.demo0508application.mvpdemo

import android.util.SparseArray

/**
 * 创建Model实现类
 */
class UserModel : IUserModel {
    private var mId: Int = 0
    private var mUsername: String = ""
    private var mAge: Int = 0
    private var mUserArray = SparseArray<User>()

    override fun setId(id: Int) {
        mId = id
    }

    override fun setUsername(username: String) {
        mUsername = username
    }

    override fun setAge(age: Int) {
        mAge = age
    }

    override fun save() {
        mUserArray.append(mId, User(mUsername, mAge))
    }

    override fun load(id: Int): User {
        mId = id
        return mUserArray.get(mId, User("not found", 0))
    }


}