package demo.myssybc.com.demo0508application.mvpdemo0517

/**
 * 第二步創建View接口
 */
interface IMineItemView {
    fun getId():Int
    fun getMineItemName(): String
    fun getMineItemAge(): Int
    fun setMineItemName(name: String)
    fun setMineItemAge(age: Int)
    fun onSaveMineItemSuccess()
    fun onLoadMineItemSuccess()

}