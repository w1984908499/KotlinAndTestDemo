package demo.myssybc.com.demo0508application.Demo0516

class KotlinTest0515 {
    val x = kotlin.run {
        print("Hello world!")
        return@run
    }

     fun main(args: Array<String>) {
        print(x)
    }


}