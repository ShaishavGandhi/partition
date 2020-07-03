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

fun cell(builder: CellBuilder.() -> Unit): Cell = CellBuilder().apply(builder).build()

class CellBuilder {
  var value: String = ""
    @JvmName("value")
    set
    @JvmName("value")
    get

  var alignment: Alignment = Alignment.NONE
    @JvmName("alignment")
    set
    @JvmName("alignment")
    get

  fun build(): Cell {
    return Cell(value, alignment)
  }
}
