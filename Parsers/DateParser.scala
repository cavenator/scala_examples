import scala.util.parsing.combinator._
import java.util._

class DateParser extends RegexParsers {
	val number = "[0-9]+".r
	val yearRegex = "[0-9]{4}".r

	def expr: Parser[java.util.Date] = yearMonthDay ^^ {
		case a => new java.util.Date(a._1, a._2, a._3)
	}
	def yearMonthDay:Parser[(Int, Int, Int)] = year ~ month ~ day ^^ {
		case a ~ b ~ c => (a, b, c)
	}
	def year:Parser[Int] = yearRegex ^^ { _.toInt }
	def month:Parser[Int] = "-" ~> number ^^ { _.toInt }
	def day:Parser[Int] = "-" ~> number ^^ { _.toInt }
}
