fun main(args: Array<String>){
    println(whatShouldIDoToday(readLine()!!))
    println(whatShouldIDoToday(mood ="sad", weather = "rainy", temperature = 0))
}

//mood : String 를 디폴트로 값을 받지말고 매개변수로 readLine()을 넘겨줘도 된다. 다만 !!로 강제로 null이 아니게 함
fun whatShouldIDoToday(mood : String , weather : String = "Sunny", temperature : Int = 24) : String{

    return when{
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        isSad(mood) && isRainy(weather) && isCold(temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "Stay at home and take a rest."
    }
}
fun isSad(mood: String) = mood == "sad"
fun isRainy(weather: String) = weather == "rainy"
fun isCold(temperature: Int) = temperature == 0
fun isHot(temperature: Int) = temperature > 35