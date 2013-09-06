import scala.util.parsing.combinator._

class MathExprParser extends RegexParsers {
	val number = "[0-9]+".r

	def expr: Parser[Int] = term ~ rep(("+"|"-") ~ term ^^ {
		case "+" ~ t => t
		case "-" ~ t => -t
	}) ^^ {
		case a ~ list => list.foldLeft(a){(initial, x) => initial + x }
	}
	def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ {
		case a ~ List() => a
		case a ~ b => a * b.product
	}
	def factor: Parser[Int] = number ^^ (n => n.toInt) | "(" ~> expr <~ ")"
}
