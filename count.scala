#!/bin/sh                                                                                                                                                                                    
exec scala -nc "$0" "$@"
!#

import scala.io._

val source = Source.stdin.getLines
println("total "+ source.length + " lines")
