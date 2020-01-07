import java.util.*

// 람다식
// 코틀린에서 람다식은 중괄호로 묶이고 변수에 선언가능하다 > 변수를 사용하려면 함수처럼 ()를 붙여줘야함
// { 내용 }()
// 내용에 인수를 넣을 수 있는데 ' -> '를 사용하여 왼쪽에 매개변수 오른쪽에 람다의 몸체 즉, 일반 함수의 몸체처럼 작동할 코드가 온다
// -> 사용해서 매개변수에 유형을 지정하기도 하지만 " val a: (Int) -> Int = { ba -> ~~~} 처럼도 가능 : 의미는 a는 Int를 가져와서 Int를 반환하는 모든 함수일 수 있다는 의미
// 람다는 고차함수(함수를 인수로 취하는 함수)에서 진정한 힘을 발휘한다.
// 람다에서 마지막 {}는 ()밖에다 사용가능 즉, filter, repeat 등은 람다를 활용한 것
// 함수의 맨 마지막 인자가 람다라면 () 안에서 빼내서 밖에 람다를 표현할 수 있다. func({~~}) == func(){~~} == func {~~}
// 인자가 하나라면 그 인자는 람다식 내부에서 it으로 받을 수 있다. filter { it~~~}
// 인자가 하나이면서 그 인자가 람다타입 이라면 ()를 생략할 수 있다. filter { ~~ }
// val a = random()은 컴파일 시간에 할당되어 다시 변화 X / val b = {random()}은 호출될 떄마다 random값 얻어서 매번 새로운 값이 나옴

fun main(args: Array<String>){
    //rollDice
    var rollDice = { Random().nextInt(12) + 1}

    //diceSide
    var diceSide = {sides: Int -> Random().nextInt(sides) + 1}

    // return 0?
    var return0 = {sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    // rollDice2
    val rollDice2 : (Int)-> Int = {sides ->
        Random().nextInt(12) + 1
    }

    // 1. Why would you want to use the function type notation instead of just the lambda
    // 함수의 인자가 어떤 타입인지 얘기할 필요가 없다. 그리고 ()밖에도 {}를 쓸 수 있어 더 편리. 인자를 여러개 받기도 편함 >>> XXXXX
    // Function type notation is more readable, which reduces errors, clearly showing the what type is passed in and what type is returned.
    // > 함수형 표기법이 더 가독성이 좋아서 에러를 줄여주고 어떠한 타입이 들어가고 어떠한 타입이 리턴되는지 명확하게 보여준다.

    // 2. Create a function gamePlay() that takes a roll of the dice as an argument and prints it out.
    fun gamePlay(sides : Int, operation :(Int)-> Int) : Int{
         return operation(sides)
    }

    // 3. Pass your rollDice2 function as an argument to gamePlay() to generate a dice roll every time gamePlay() is called.
    var sides = 6
    fun test(sides: Int) = sides + 6
    gamePlay(sides, rollDice2) //rollDice2는 람다이니 이렇게 불러도 됨
    gamePlay(sides, ::test) // test는 람다가 아니라서 ::(리플렉션)으로 불러야함...
}