#!/bin/sh
exec scala -nc "$0" "$@"
!#

import scala.io._

def processChooseBlock(block: List[String]): List[String] = {
  println("processing choose block:")
  block.foreach(println)
  val rs = if(block(1).contains("<c:when test=\"${ mobileLevel eq 'high' }\">")) {
    if(block.find(_.contains("<choose>")).isEmpty){
      block.dropWhile(x => !(x.contains("<c:when test=\"${ mobileLevel eq 'high' }\">"))).
	takeWhile(x => !(x.contains("</c:when>")))
    }else {throw new Error("can't process recursive choose block")}
  }else block 
  rs.tail.reverse
}

val fileName = if(args.length>0) args(0) else Source.stdin.getLines.next
val source =  Source.fromFile(fileName).getLines
println("processing " + fileName)
val t = source.foldLeft((List[String](),List[String]())){
  case ((target, block), s) if s.contains("<c:choose>") => (target, s ::block)
  case ((target, block), s) if s.contains("</c:choose>") => (processChooseBlock((s::block).reverse) ++ target, Nil)
  case ((target, block), s) if ! block.isEmpty => (target, s :: block)
  case ((target, Nil), s) => (s:: target, Nil)
}

println("content of target:")
t._1.reverse.foreach(println)
println("process ok")
