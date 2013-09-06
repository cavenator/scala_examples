object EitherExample {

	def findMe(array:Array[Int], number: Int):Int Either Int = {

		var min = java.lang.Integer.MAX_VALUE
		var indexClosestTo = 0
		for (i <- 0 until array.length){
			val delta = Math.abs(number - array(i))
			if (delta == 0){
				return Right(i)
			} else if (delta < min){
				min = delta
				indexClosestTo = i
			} else {
				return Left(indexClosestTo)
			}
		}
		return Left(indexClosestTo)
 	}

	def evaluate(verdict:Either[Int, Int]) = {
		verdict match { 
			case Left(x) => println("Index that comes closest is "+x)
			case Right(x) => println("Index found: "+x)
		}
	}

      def main(args:Array[String]):Unit = {
	 val array = Array(-15, -12, -9)
	 val number = args(0).toInt
	 val verdict = findMe(array,number)
	evaluate(verdict)
      }
}
