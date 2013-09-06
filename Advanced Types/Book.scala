object Title
object Author

class Book {
    var title:String = "" 
    var author:String = ""
    private var argsToUse:Any = null

    def set(obj:Title.type):this.type = { argsToUse = obj; this }
    def set(obj:Author.type):this.type = {argsToUse = obj; this }
    def to(args: String) = {
	argsToUse match {
	    case Title => title = args
	    case Author => author = args
	}
	this
    }

    override def toString:String = {
	"%s by %s".format(title, author)
    }
}
