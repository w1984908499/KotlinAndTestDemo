package demo.myssybc.com.demo0508application.Demo0508.mvpdemo02

/**
 * 第三步创建Model接口
 * 创建model的方法
 */
interface IMineUserModel {
    fun setMineUserId(id: Int)
    fun setMineUserName(username: String)
    fun setMineUserAge(age: Int)
    fun saveMineUser()
    fun loadMineUser(id: Int): MineUser


}