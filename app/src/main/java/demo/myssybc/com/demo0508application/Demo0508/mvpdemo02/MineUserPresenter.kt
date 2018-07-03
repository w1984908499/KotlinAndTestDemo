package demo.myssybc.com.demo0508application.Demo0508.mvpdemo02

class MineUserPresenter(val view: IMineUserView) : IMineUserPresenter {

    private val mineUserModel = MineUserModel()


    override fun saveMineUser(id: Int, username: String, age: Int) {
        mineUserModel.setMineUserId(id)
        mineUserModel.setMineUserName(username)
        mineUserModel.setMineUserAge(age)
        mineUserModel.saveMineUser()
        view.onSaveMineUserSuccess()


    }

    override fun loadMineUser(id: Int) {
        val user = mineUserModel.loadMineUser(id)
        view.setMineUsername(user.name)
        view.serMineUserAge(user.age)
        view.onLoadMineUserSuccess()

    }

}