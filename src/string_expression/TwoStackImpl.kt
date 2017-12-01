package string_expression

/**
 * Created by szholdiyarov on 11/28/17.
 *
 *
 */

fun main(args: Array<String>) {
    var expression1 = "10*1*2"
    var expression2 = "10+1*2"
    var expression3 = "10*1+2"
    var exporession4 = "10*(1+2)"
    print(infixToPostfix(exporession4))
}


fun infixToPostfix(expression: String): String {
    var result: String = ""
    val operandsStack = Stack<Char>(arrayListOf())

    val expressionCharacters = expression.toCharArray()
    var tempNumber = ""
    var counter = 0;
    expressionCharacters.forEach {
        counter++
        if (it.isDigit()) {
            tempNumber += it
            if (counter >= expressionCharacters.size) { // to parse last element
                result += tempNumber
            } else {
            }
        } else {

            if (it.equals(')')) {
                while (!operandsStack.isEmpty() && operandsStack.peek() != '(') {
                    val currentLastStackElement = operandsStack.peek()
                    if (currentLastStackElement != '(')
                        result += operandsStack.pop()
                }
            } else {
                if (tempNumber.isNotEmpty()) {
                    result += tempNumber + "|"
                    tempNumber = ""
                }

                if (operandsStack.isEmpty()) {
                    operandsStack.push(it)
                } else {
                    if (operandsStack.peek()!!.hasHigherPrecedence(it)) { // multiply preceeds plus
                        result += operandsStack.pop()

                        if (operandsStack.peek() != '(')
                        operandsStack.push(it)
                    } else {
                        operandsStack.push(it)
                    }
                }
            }
        }
    }

    if (!operandsStack.isEmpty()) { // output all operands from the stack
        operandsStack.forEach {
            result += it
        }
    }


    return result
}

fun Char.hasHigherPrecedence(anotherChar: Char): Boolean {
    if (anotherChar.equals('(')){
        return false
    }

    if (this.equals(anotherChar)) {
        return false
    }

    if (this.equals('+') && (anotherChar.equals('*') || anotherChar.equals('/'))) {
        return false
    }

    if (this.equals('-') && (anotherChar.equals('*') || anotherChar.equals('/'))) {
        return false
    }

    return true
}
