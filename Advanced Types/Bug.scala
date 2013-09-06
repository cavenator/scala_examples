object show
object then
object around

class Bug {

   var distance = 0
   var orientation = 1

   def move(units:Int) = {
	orientation match {
	   case 1 => distance = distance + units
	   case 0 => distance = distance - units
	}
	this
   }

   def turn(arg:around.type) = {
	orientation match {
	   case 1 => orientation = 0
	   case 0 => orientation = 1
	}
	this
   }

   def and(arg:show.type) = {
	println(distance)
	this
   }

   def and(arg:then.type) = {
	this
   }
}

object Bug extends App {
    val bugsy = new Bug
    bugsy move 4 and show and then move 6 and show turn around move 5 and show
}
