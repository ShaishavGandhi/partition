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

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class Tests {

  @Test
  fun `rows with first as default header`() {
    val table = TableBuilder()
      .row("Hello", "World")
      .row("Shaishav", "Gandhi")
      .build()

    assertThat(table.toString()).isEqualTo("""
      || Hello | World |
      || -- | -- |
      || Shaishav | Gandhi |
      |""".trimMargin())
  }

  @Test
  fun `rows with explicit header`() {
    val table = TableBuilder()
      .header("Time", "Size")
      .row("1ms", "1kb")
      .row("0.5ms", "2kb")
      .build()

    assertThat(table.toString()).isEqualTo("""
      || Time | Size |
      || -- | -- |
      || 1ms | 1kb |
      || 0.5ms | 2kb |
      |""".trimMargin())
  }

  @Test
  fun `table with one column`() {
    val table = TableBuilder()
      .header("Time")
      .row("1ms")
      .row("0.5ms")
      .build()

    assertThat(table.toString()).isEqualTo("""
      || Time |
      || -- |
      || 1ms |
      || 0.5ms |
      |""".trimMargin())
  }

  @Test
  fun `table with more headers than columns`() {
    val table = TableBuilder()
      .header("Time", "Size")
      .row("1ms")
      .row("0.5ms")
      .build()

    assertThat(table.toString()).isEqualTo("""
      || Time | Size |
      || -- | -- |
      || 1ms |
      || 0.5ms |
      |""".trimMargin())
  }

  @Test
  fun `table with more columns than headers`() {
    val table = TableBuilder()
      .header("Time")
      .row("1ms", "1kb")
      .row("0.5ms", "2kb")
      .build()

    assertThat(table.toString()).isEqualTo("""
      || Time |
      || -- |
      || 1ms | 1kb |
      || 0.5ms | 2kb |
      |""".trimMargin())
  }

  @Test
  fun `dsl`() {
    val table = table {
      header("Hello", "World")
      row("Shaishav", "Gandhi")
    }

    assertThat(table.toString()).isEqualTo("""
      || Hello | World |
      || -- | -- |
      || Shaishav | Gandhi |
      |""".trimMargin())
  }
}
