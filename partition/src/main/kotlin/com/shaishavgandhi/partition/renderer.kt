/*
 * Copyright (C) 2020. Shaishav Gandhi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shaishavgandhi.partition

import java.lang.StringBuilder

internal fun render(table: Table): String {
  val stringBuilder = StringBuilder()

  // Render the header first
  val header = table.rows.first()
  render(header, stringBuilder, true)

  // Render remaining rows
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

  // Add separators for headers
  if (isHeader) {
    stringBuilder.append("|")
    for (cell in row.cells) {
      when (cell.alignment) {
        Alignment.START -> stringBuilder.append(" :-- ")
        Alignment.CENTER -> stringBuilder.append(" :--: ")
        Alignment.END -> stringBuilder.append(" --: ")
        Alignment.NONE -> stringBuilder.append(" -- ")
      }
      stringBuilder.append("|")
    }
    stringBuilder.append("\n")
  }
}
