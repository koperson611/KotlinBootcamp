import java.util.*

fun main(args: Array<String>){
    println("Hello, ${args[0]}!")

    feedTheFish()
}


fun getDirtySensorReading() = 20
//이렇게 여러 매개변수가 있을 때, 명시적으로 어떤 매개변수를 대입할 것인지 적어야함 > shouldChangeWater(day = "Monday") O > shouldChangeWater("Monday") X
fun shouldChangeWater(
    day : String,
    temperature : Int = 22,
    dirty : Int = getDirtySensorReading()) : Boolean{ //함수를 매개변수의 인자로 넘길 수 있다
    //이런 식으로 사용도 가능하고 한줄 함수로 만들어도 됨. 한 줄 함수로 만들때 함수명으로 리턴타입 유추 가능
    //한줄 함수 구문을 사용하면 helper 함수를 간단하게 할 수 있다.
    fun isToHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    return when{
        isToHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
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

// Sequence 연산은 필터링과 map연산을 진행할 때, 중간 결과를 저장하는 컬렉션이 생기지 않아 리스트의 원소가 많을 떄 성능이 좋아짐.
// 대신에 마지막에 toList()와 같은 연산을 추가해주면 그 때 계산이 됨.
// asSequence를 사용하면 리스트의 항목(원소)를 하나씩 접근해서 계산하고 collection은 리스트 전체를 한번에 계산함.

var dirty = 20

val waterFilter : (Int) -> Int = { dirty -> dirty/2}
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation:(Int)->Int) : Int{
    return operation(dirty)
}
//고차 함수 예
fun dirtyProcessor(){
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty){
        dirty -> dirty + 50
    }// 이때 람다는 updateDirty의 인수임.
}