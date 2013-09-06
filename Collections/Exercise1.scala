import scala.collection.mutable._

object Exercise1 {
   def main(args:Array[String]):Unit = {

	if (args.size == 1){
		printoutput(args(0))
	} else {
		printoutput("Mississippi")
	}
   }

   def printoutput(inputString: String) = {
	val mapOfIndex = indexes(inputString)
	mapOfIndex.map(println)
   }

	def indexes(string:String) = {
	val hashMap = new scala.collection.mutable.HashMap[Char, Set[Int]]()
     	   for (i <- 0 until string.size) {
     		hashMap(string(i)) = hashMap.getOrElse(string(i), LinkedHashSet(i)) + i
     	   }
     	hashMap
        }
}
