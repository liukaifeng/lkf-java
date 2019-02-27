package com.lkf.sort


object ScalaBubbleSort {
  def main(args: Array[String]): Unit = {
    println(sort(Array(1, 9, 3, 4, 0, 7, 5, 6)))
  }

  def sort(arrs: Array[Int]): Array[Int] = {
    for (i <- arrs.indices) {
      var noExchange=true
      for (j <- 0 until arrs.length - i - 1) {
        if (arrs(j) > arrs(j + 1)) {
          val temp = arrs(j)
          arrs.update(j, arrs(j + 1))
          arrs.update(j + 1, temp)
          noExchange=false
        }
        
      }
    }
    arrs
  }
}
