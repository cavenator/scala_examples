import scala.xml._
import scala.util.parsing.combinator._

class XmlParser extends RegexParsers {

   val tag = """[a-zA-Z_]\w*""".r
   def expr:Parser[scala.xml.Elem] = "<xml>" ~ tags ~ "</xml>" ^^ {
	case a ~ b ~ c => XML.loadString(a+b+c)
   }
   def tags:Parser[String] = rep( openTag | closedTag ) ^^ {

	case List() => ""
	case parsedNodes => parsedNodes.foldRight(""){ _ + _ }
   }

   def openTag:Parser[String] = "<" ~ tag ~ "></" ~ tag ~ ">" ^^ {
	case "<" ~a ~ "></" ~ b ~ ">" => "<"+a+"></"+b+">"
   }
   def closedTag:Parser[String] = "<" ~> tag <~ "/>" ^^ {
	case a => "<"+a+"/>"
   }

}


