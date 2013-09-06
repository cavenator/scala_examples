import scala.util.parsing.combinator._
import java.util.Date

class DateParser extends RegexParsers {

	val yearRegex = "[0-9]{4}".r
	val daysRegex = "(01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31)".r
	val monthRegex = "(01|02|03|04|05|06|07|08|09|10|11|12)".r
	val minutesAndSecondsRegex = "(00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59)".r
	val hoursRegex = "(00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23)".r

	def expr:Parser[java.util.Date] = yearMonthDay ^^ {
		case tup => new java.util.Date(tup._1, tup._2, tup._3)
	}
	def yearMonthDay:Parser[(Int, Int, Int, Int, Int, Int)] = year ~ monthDay ^^ {
		case a ~ b => (a, b._1, b._2, b._3, b._4, b._5)
	}
	def monthDay:Parser[(Int, Int, Int, Int, Int)] = opt("-" ~> month ~ day) ^^ {
		case Some(a ~ b) => (a, b._1, b._2, b._3, b._4)
		case None => (0, 1, 0, 0, 0)
	}
	def year:Parser[Int] = yearRegex ^^ { (_.toInt - 1900) }
	def month:Parser[Int] = monthRegex ^^ { _.toInt - 1 }
	def day:Parser[(Int, Int, Int, Int)] = opt("-" ~> daysRegex ~ timePortion) ^^ {
		case None => (1, 0, 0, 0)
		case Some(day ~ time) => (day.toInt, time._1, time._2, time._3)
	}
	def timePortion:Parser[(Int, Int, Int)] = opt("T" ~> hours ~ minutes ~ seconds) ^^ {
		case None => (0, 0, 0)
		case Some(hour ~ minute ~ second) => (hour, minute, second)
	}
	def hours:Parser[Int] = hoursRegex ^^ { _.toInt }
	def minutes:Parser[Int] = ":" ~> minutesAndSecondsRegex ^^ { _.toInt }
	def seconds:Parser[Int] = opt("" ~> minutesAndSecondsRegex) ^^ {
		case None => 0
		case Some(second) => second.toInt
	}
}

