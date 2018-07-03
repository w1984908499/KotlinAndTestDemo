package demo.myssybc.com.demo0508application.Demo0508.mvpdemo02

/**
 * 创建Presenter接口
 */
interface IMineUserPresenter {
    fun saveMineUser(id: Int, username: String, age: Int)
    fun loadMineUser(id: Int)
}