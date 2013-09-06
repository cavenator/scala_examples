import scala.util.parsing.combinator._

class ListParser extends RegexParsers {

	val number = "[0-9]+".r

	def expr:Parser[List[Int]] = "(" ~> nums <~ ")"
	def nums: Parser[List[Int]] = num ~ rep("," ~ num ^^ { 
			case "," ~ a => a.toInt
		 }) ^^ {
		case a ~ List() => List(a)
		case a ~ b => List(a) ++ b
	}
	def num: Parser[Int] = number ^^ { _.toInt }
}

