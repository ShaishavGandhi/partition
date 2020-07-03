package com.shaishavgandhi.partition

class Table(
  val rows: List<Row>
) {

  fun output(): String {
    return render(this)
  }
}