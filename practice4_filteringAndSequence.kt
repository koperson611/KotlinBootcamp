fun main(args: Array<String>){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    val curries = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println("Sort by length & contains curry : $curries")

//    spices.filter{it.startsWith('c')}.filter{it.endsWith('e')}
    val eagerSpice = spices.filter { it[0] == 'c' && it.last() == 'e' }
    println("Eager filter : $eagerSpice")

//    spices.filter { {it.startsWith('c') && it.endsWith('e') }
    val lazySpice = spices.asSequence().filter { it.startsWith('c') && it.last() == 'e' }.toList()
    println("Lazy filter : $lazySpice")

    val threeSpice = spices.asSequence().take(3).filter { it.startsWith('c') }.toList()
    println("Take 3 start with c : $threeSpice")
}