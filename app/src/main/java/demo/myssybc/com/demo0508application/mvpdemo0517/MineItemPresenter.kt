package demo.myssybc.com.demo0508application.mvpdemo0517

class MineItemPresenter(val view: IMineItemView) : IMineItemPresenter {

    //新建一个MineItemModel
    private val mineItemModel = MineItemModel()

    override fun saveMineItem(id: Int, name: String, age: Int) {
        mineItemModel.setId(id)
        mineItemModel.setMineItemName(name)
        mineItemModel.setMineItemAge(age)
        mineItemModel.save()
        view.onSaveMineItemSuccess()
    }

    override fun loadMineItem(id: Int) {
        val mineItem = mineItemModel.load(id)
        view.setMineItemName(mineItem.name)
        view.setMineItemAge(mineItem.age)
        view.onLoadMineItemSuccess()    


    }
}