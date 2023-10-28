enum ArithmeticExpression:
  case Num(value: Int)
  case Minus(expression: ArithmeticExpression)
  case Plus(left: ArithmeticExpression, right: ArithmeticExpression)
  case Mult(left: ArithmeticExpression, right: ArithmeticExpression)
  case Div(left: ArithmeticExpression, right: ArithmeticExpression)

/* type Num = Int
  type Minus = ArithmeticExpression
  type Plus = ArithmeticExpression
  type Mult = ArithmeticExpression
  type Div = ArithmeticExpression
 */

