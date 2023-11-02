import ArithmeticExpression.{Div, Minus, Mult, Num, Plus, Pow, showResults}
import org.scalatest.funsuite.AnyFunSuite
class test extends AnyFunSuite {
  test("Num is double and has the valid value"){
    assert(ArithmeticExpression.evaluate(ArithmeticExpression.Num(7)) === 7.0)
  }
  test("Minus is double and has the valid negative value"){
    assert(ArithmeticExpression.evaluate(ArithmeticExpression.Minus(ArithmeticExpression.Num(4))) === -4.0)
  }
  test("Pow is double and has the valid value"){
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
  test("evaluate for List of expressions functions correctly"){
    assert(ArithmeticExpression.evaluate(List(Minus(Num(89)), Plus(Num(10), Num(2)), Pow(Num(5), Minus(Num(1))))) === List(-89.0, 12.0, 0.2))
  }
  test("showResults functions correctly"){
    assert(showResults(List(Num(6), Minus(Num(89)), Plus(Num(10), Num(2)), Pow(Num(5), Minus(Num(1))))) === "\n6.0 = 6.0\n-89.0 = -89.0\n10.0 + 2.0 = 12.0\n5.0 ^ -1.0 = 0.2")
  }
}
