fun main(args: Array<String>) {
    var fort : String
    for (i in 1..10){
        fort = getFortuneCookie(getBirthday())
        println("\nYour fortune is: $fort")
        if(fort.contains("Take it easy")) break
    }
}

fun getBirthday() : Int{
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}
fun getFortuneCookie(birthday : Int) : String {
    // val index = when(....){...} 처럼도 가능하다
    return when(birthday){
        in 1..10 -> "You will have a great day!"
        in 11..20 -> "Things will go well for you today."
        in 21..27 -> "Today is a good day for exercising restraint."
        28 -> "Take it easy and enjoy life!"
        else -> "Treasure your friends, because they are your greatest fortune."
    }
}