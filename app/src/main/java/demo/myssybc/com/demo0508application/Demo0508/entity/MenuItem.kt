package demo.myssybc.com.demo0508application.Demo0508.entity

class MenuItem {
    var _id: String = ""
    var createdAt: String = ""
    var desc: String = ""
    var publishedAt: String = ""
    var source: String = ""
    var type: String = ""
    var url: String = ""
    var used: Boolean = false
    var who: String = ""


    override fun toString(): String {
        return "MenuItem(_id='$_id', createdAt='$createdAt', desc='$desc', publishedAt='$publishedAt', source='$source', type='$type', url='$url', used=$used, who='$who')"
    }


}