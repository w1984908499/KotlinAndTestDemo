package demo.myssybc.com.demo0508application.Demo0508.mvpdemo02

/**
 * 第二步创建一个View接口
 * 写控制view的方法
 */
interface IMineUserView {
    fun getMineUserId(): Int
    fun getMineUsername(): String
    fun getMineUserAge(): Int
    fun setMineUsername(username: String)
    fun serMineUserAge(age: Int)
    fun onSaveMineUserSuccess()
    fun onLoadMineUserSuccess()


}