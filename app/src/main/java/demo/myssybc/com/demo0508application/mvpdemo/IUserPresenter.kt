package demo.myssybc.com.demo0508application.mvpdemo

/**
 * 创建Presenter接口
 */
interface IUserPresenter {
    fun saveUser(id: Int, username: String, age: Int)
    fun loadUser(id: Int)
}