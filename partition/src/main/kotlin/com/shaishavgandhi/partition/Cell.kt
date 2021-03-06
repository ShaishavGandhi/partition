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

/**
 * A general purpose data structure to represent a single Cell in a table.
 *
 * Cells can have [Alignment] but in reality that only applies if you provide it within a header since
 * Markdown only provides alignment of entire columns and not individual cells.
 */
class Cell @JvmOverloads constructor(
  internal val value: String,
  internal val alignment: Alignment = Alignment.NONE
) {

  override fun toString(): String {
    return value
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Cell

    if (value != other.value) return false
    if (alignment != other.alignment) return false

    return true
  }

  override fun hashCode(): Int {
    var result = value.hashCode()
    result = 31 * result + alignment.hashCode()
    return result
  }
}
