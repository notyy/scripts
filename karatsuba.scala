def len(x:Int):Int = x.toString.length

def multi(x:Int, y:Int): Int = {
	println(s"calc $x * $y")
	if(len(x)<=1) x*y else {
		val (a,b) = sep(x)
		val (c,d) = sep(y)
		val n = len(x)
		import math.pow
		val ac = multi(a,c)
		val bd = multi(b,d)
		pow(10,n).toInt*ac + pow(10, n/2).toInt*((a+b)*(c+d) -ac - bd) + bd
	}
}

def sep(x:Int):(Int,Int) = {
	val s = x.toString
	val i = s.length / 2
	(s.take(i).toInt, s.drop(i).toInt)
}

