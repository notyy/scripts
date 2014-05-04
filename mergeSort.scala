@scala.annotation.tailrec
def merge(xs:List[Int], ys: List[Int], rs: List[Int]): List[Int] = (xs,ys) match {
	case (Nil,_) => rs ++ ys
	case (_,Nil) => rs ++ xs
	case (hx::tx, hy::ty) => {
		if(hx <= hy) {
			merge(tx, ys, rs :+ hx)
		} else {
			merge(xs, ty, rs :+ hy)
		}
	}
}

def mergeSort(xs: List[Int]):List[Int] = xs match {
	case List(x) => List(x)
	case List(x,y) => if(x <= y) List(x,y) else List(y,x)
	case _ => {
		val (l,r) = xs.splitAt(xs.size / 2)
		merge(mergeSort(l), mergeSort(r), Nil)
	}
}