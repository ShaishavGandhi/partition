package com.shaishavgandhi.partition

import java.lang.StringBuilder

fun render(table: Table): String {
  val stringBuilder = StringBuilder()
  val header = table.rows.first()
  render(header, stringBuilder, true)
  table.rows.listIterator(1).forEach {
    render(it, stringBuilder)
  }
  return stringBuilder.toString()
}

private fun render(row: Row, stringBuilder: StringBuilder, isHeader: Boolean = false) {
  stringBuilder.append("|")
  for (cell in row.cells) {
    stringBuilder.append(" $cell ")
    stringBuilder.append("|")
  }
  stringBuilder.append("\n")
  if (isHeader) {
    stringBuilder.append("|")
    for (cell in row.cells) {
      stringBuilder.append(" -- ")
      stringBuilder.append("|")
    }
    stringBuilder.append("\n")
  }
}