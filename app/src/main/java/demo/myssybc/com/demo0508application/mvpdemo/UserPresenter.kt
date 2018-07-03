package demo.myssybc.com.demo0508application.mvpdemo

import android.util.Log

class UserPresenter(val view: IUserView) : IUserPresenter {

    private val mUserModel: UserModel = UserModel()

    override fun saveUser(id: Int, username: String, age: Int) {
        Log.e("MVP_test_log", "saveUser:$id,$username,$age")
        mUserModel.setId(id)
        mUserModel.setUsername(username)
        mUserModel.setAge(age)
        mUserModel.save()
        view.onSaveSuccess()

    }

    override fun loadUser(id: Int) {
        Log.e("MVP_test_log","loadUseer:$id")
        val user=mUserModel.load(id)
        view.setUsername(user.name)
        view.setAge(user.age)
        


    }

}