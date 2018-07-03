package demo.myssybc.com.demo0508application.mvpdemo0517

/**
 * 第五步创建Presenter接口
 */
interface IMineItemPresenter {
    fun saveMineItem(id: Int, name: String, age: Int)
    fun loadMineItem(id: Int)
}