package demo.myssybc.com.demo0508application.mvpdemo0517

import android.util.SparseArray

/**
 * 第四步创建Model实现类
 */
class MineItemModel : IMineItemModel {

    //要用private修饰符
    private var id: Int = 0
    private var name: String = ""
    private var age: Int = 0
    private val mSparseArray = SparseArray<MineItem>()

    override fun setId(id: Int) {
        this.id = id
    }

    override fun setMineItemName(name: String) {
        this.name = name
    }

    override fun setMineItemAge(age: Int) {
        this.age = age
    }

    override fun save() {
        mSparseArray.append(id, MineItem(name, age))
    }

    override fun load(id: Int): MineItem {
        return mSparseArray.get(id)
    }
}