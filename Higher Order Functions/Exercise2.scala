object Exercise2 {
	def main(args:Array[String]) = {
		val array = Array(10,40,30,50,20)
		val largest = findLargest(array)
		println(largest)
	}

	def findLargest(values:Array[Int]):Int = {
		import scala.math._
		values.reduceLeft(max(_,_))
	}
}
