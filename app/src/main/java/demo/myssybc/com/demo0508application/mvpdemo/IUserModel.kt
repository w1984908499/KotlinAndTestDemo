package demo.myssybc.com.demo0508application.mvpdemo

/**
 * 创建Model接口
 */
interface IUserModel {
    fun setId(id: Int)
    fun setUsername(username: String)
    fun setAge(age: Int)
    fun save()
    fun load(id: Int): User
}