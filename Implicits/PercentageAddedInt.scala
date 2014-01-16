class PercentageAddedInt(val x:Int){
     def +%(implicit y:Int) = x + (y * x)/100
}

object PercentageAddedInt {
   implicit def convertIntToPercentageAddedInt(n:Int):PercentageAddedInt = new PercentageAddedInt(n)
}
