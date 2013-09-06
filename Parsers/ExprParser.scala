import scala.util.parsing.combinator._

class ExprParser extends RegexParsers {
	val number = "[0-9]+".r

	def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
	def term: Parser[Any] = factor ~ rep(("*" | "/" | "%") ~ factor)
	def factor: Parser[Any] = exponent  |"(" ~ expr ~ ")"
	def exponent:Parser[Any] = number ~ opt("^" ~ exponent)
}
