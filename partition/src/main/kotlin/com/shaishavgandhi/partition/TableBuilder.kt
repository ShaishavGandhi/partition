package com.shaishavgandhi.partition

class TableBuilder {

  private val rows: MutableList<Row> = mutableListOf()

  fun header(row: Row): TableBuilder {
    rows.add(0, row)
    return this
  }

  fun header(vararg values: String): TableBuilder {
    return header(Row(values.toList()))
  }

  fun row(row: Row): TableBuilder {
    rows.add(row)
    return this
  }

  fun row(vararg values: String): TableBuilder {
    return row(Row(values.toList()))
  }

  fun build(): Table {
    return Table(rows)
  }
}