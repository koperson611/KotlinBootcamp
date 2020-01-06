import java.util.*

fun main(args: Array<String>){
    println("Hello, ${args[0]}!")

    feedTheFish()
}

//이렇게 여러 매개변수가 있을 때, 명시적으로 어떤 매개변수를 대입할 것인지 적어야함 > shouldChangeWater(day = "Monday") O > shouldChangeWater("Monday") X
fun shouldChangeWater(
    day : String,
    temperature : Int = 22,
    dirty : Int = 20) : Boolean{
    return true
}

//랜덤으로 날짜를 받아서 날마다 다른 먹이를 주는 함수
fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    shouldChangeWater(day, dirty = 50)
    if(shouldChangeWater(day)){
        println("Change the Water today")
    }
}
fun swim(speed : String = "fast"){ //함수의 디폴트 인자를 설정할 수 있다. swim()으로 호출하면 자동으로 fast가 들어감
    println("Swimming $speed")
}
fun randomDay() : String{
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(7)] //get 0~6
}
fun fishFood(day : String) : String{
    return when(day){
        "Monday" -> "fasta"
        "Friday" -> "swarm"
        "Sunday" -> "all"
        else -> "fasting"
    }
}