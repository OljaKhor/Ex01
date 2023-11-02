
enum ArithmeticExpression:
  case Num(value: Int)
  case Minus(value: ArithmeticExpression)
  case Plus(left: ArithmeticExpression, r: ArithmeticExpression)
  case Mult(left: ArithmeticExpression, r: ArithmeticExpression)
  case Div(left: ArithmeticExpression, r: ArithmeticExpression)

  case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression)
object ArithmeticExpression {
  @main def hello(): Unit = {
    //println(evaluate(Pow(Num(2), Minus(Num(2)))))
    val listOfExp = List(Num(6), Minus(Num(89)), Plus(Num(10), Num(2)), Pow(Num(5), Minus(Num(1))))
    val listOfDouble = evaluate(listOfExp)
    println(listOfDouble)
    val string: String = showResults(listOfExp)
    println(string)
  }

  def evaluate(expression: ArithmeticExpression): Double = expression match
    case Num(value: Int) => value.toDouble
    case Minus(value: ArithmeticExpression) => -evaluate(value)
    case Plus(l: ArithmeticExpression, r: ArithmeticExpression) => evaluate(l) + evaluate(r)
    case Mult(l: ArithmeticExpression, r: ArithmeticExpression) => evaluate(l) * evaluate(r)
    case Div(l: ArithmeticExpression, r: ArithmeticExpression) => evaluate(l) / evaluate(r)

    case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression) => {
      if ((evaluate(exponent) == 0) && (evaluate(base) != 0)) 1.0
      else if (evaluate(exponent) > 0) evaluate(base) * evaluate(Pow(Num(evaluate(base).toInt), Num(evaluate(exponent).toInt - 1)))
      else (1 / evaluate(base)) * evaluate(Pow(Num(evaluate(base).toInt), Num(evaluate(exponent).toInt + 1)))
    }

  def pretty(expression: ArithmeticExpression): String =
    expression match
      case Num(value: Int) => s"${evaluate(Num(value))}"
      case Minus(value) =>
        s"-${pretty(value)}"
      case Plus(l, r) =>
        s"${pretty(l)} + ${pretty(r)}"
      case Mult(l, r) =>
        s"${pretty(l)} * ${pretty(r)}"
      case Div(l, r) =>
        s"${pretty(l)} / ${pretty(r)}"
      case Pow(b, e) =>
        s"${pretty(b)} ^ ${pretty(e)}"


  def evaluate(expressions: List[ArithmeticExpression]): List[Double] =
    expressions match {
      case Nil => Nil
      case head :: tail =>
        val kopf = head match {
          case Num(value) => value.toDouble
          case Minus(exp) => -evaluate(List(exp)).head
          case Plus(exp1, exp2) =>
            evaluate(List(exp1)).head + evaluate(List(exp2)).head
          case Mult(exp1, exp2) =>
            evaluate(List(exp1)).head * evaluate(List(exp2)).head
          case Div(exp1, exp2) =>
            evaluate(List(exp1)).head / evaluate(List(exp2)).head
          case Pow(basis, exp) =>
            if (evaluate(List(exp)).head == 0 && evaluate(List(basis)).head != 0) 1.0
            else if (evaluate(List(exp)).head > 0)
              evaluate(List(basis)).head * evaluate(List(Pow(basis, Num(evaluate(List(exp)).head.toInt - 1)))).head
            else
              1 / evaluate(List(basis)).head * evaluate(List(Pow(basis, Num(evaluate(List(exp)).head.toInt + 1)))).head
        }
        kopf :: evaluate(tail)
    }
  def showResults(expressions: List[ArithmeticExpression]): String =
    expressions match{
      case Nil => ""
      case head :: tail => "\n" + pretty(expressions.head) + s" = ${evaluate(expressions.head)}" + showResults(expressions.tail)
  }
}





