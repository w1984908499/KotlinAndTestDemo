package demo.myssybc.com.demo0508application.mvpdemo

/**
 * 创建View接口
 */
interface IUserView {
    fun getID(): Int
    fun getUsername(): String
    fun getAge(): Int
    fun setUsername(username: String)
    fun setAge(age: Int)
    fun onSaveSuccess()

}