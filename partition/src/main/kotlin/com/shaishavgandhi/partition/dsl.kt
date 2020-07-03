package com.shaishavgandhi.partition

fun table(builder: TableBuilder.() -> TableBuilder): Table {
  val tableBuilder = TableBuilder()
  return tableBuilder.builder().build()
}
