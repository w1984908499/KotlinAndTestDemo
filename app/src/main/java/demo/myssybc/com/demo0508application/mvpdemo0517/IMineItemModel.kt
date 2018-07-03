package demo.myssybc.com.demo0508application.mvpdemo0517

/**
 * 第三步创建model接口
 */
interface IMineItemModel {
    fun setId(id: Int)
    fun setMineItemName(name: String)
    fun setMineItemAge(age: Int)
    fun save()
    fun load(id: Int): MineItem

}