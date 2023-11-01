enum ArithmeticExpression:
  case Num(value: Int)
  case Minus(value: ArithmeticExpression)
  case Plus(left: ArithmeticExpression, r: ArithmeticExpression)
  case Mult(left: ArithmeticExpression, r: ArithmeticExpression)
  case Div(left: ArithmeticExpression, r: ArithmeticExpression)

  case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression)
object ArithmeticExpression {
  /*@main def hello(): Unit = {
    println(evaluate(Pow(Num(2), Minus(Num(2)))))
  }
  */
  def evaluate(expression: ArithmeticExpression): Double = expression match
    case Num(value: Int) => value.toDouble
    case Minus(value: ArithmeticExpression) => -evaluate(value)
    case Plus(l: ArithmeticExpression, r: ArithmeticExpression) => evaluate(l) + evaluate(r)
    case Mult(l: ArithmeticExpression, r: ArithmeticExpression) => evaluate(l) * evaluate(r)
    case Div(l: ArithmeticExpression, r: ArithmeticExpression) => evaluate(l) / evaluate(r)

    case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression) => {
      if ((evaluate(exponent) == 0) && (evaluate(base) != 0))  1.0
      else if (evaluate(exponent) > 0)  evaluate(base) * evaluate(Pow(Num(evaluate(base).toInt), Num(evaluate(exponent).toInt - 1)))
      else (1 / evaluate(base)) * evaluate(Pow(Num(evaluate(base).toInt), Num(evaluate(exponent).toInt + 1)))
    }
    /*case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression) => (base, exponent) match{
      case (_, Num(0)) if evaluate(base).toInt != 0 => 1.0
      case (Num(0), _) if evaluate(exponent).toInt != 0 => 0.0
      case _ if evaluate(exponent).toInt > 0 => evaluate(base) * Pow(base, exponent-1)
    }
    */

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

}





