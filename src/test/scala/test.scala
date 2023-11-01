import org.scalatest.funsuite.AnyFunSuite
class test extends AnyFunSuite {
  test("Num is double and has valid value"){
    assert(ArithmeticExpression.evaluate(ArithmeticExpression.Num(7)) === 7.0)
  }
  test("Minus is double and has valid negative value"){
    assert(ArithmeticExpression.evaluate(ArithmeticExpression.Minus(ArithmeticExpression.Num(4))) === -4.0)
  }
  test("Pow is double and has valid value"){
    assert(ArithmeticExpression.evaluate(ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(6))) === 64.0)
  }
  test("Pretty for Mult is pretty"){
    assert(ArithmeticExpression.pretty(ArithmeticExpression.Mult(ArithmeticExpression.Num(4), ArithmeticExpression.Num(4))) === "4.0 * 4.0")
  }
  test("Pretty for Minus is pretty"){
    assert(ArithmeticExpression.pretty(ArithmeticExpression.Minus(ArithmeticExpression.Num(10))) === "-10.0")
  }
  test("Pretty for Pow is pretty"){
    assert(ArithmeticExpression.pretty(ArithmeticExpression.Pow(ArithmeticExpression.Num(2), ArithmeticExpression.Num(6))) === "2.0 ^ 6.0")
  }
}
