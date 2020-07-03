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

    assertThat(table.output()).isEqualTo("""
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

    assertThat(table.output()).isEqualTo("""
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

    assertThat(table.output()).isEqualTo("""
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

    assertThat(table.output()).isEqualTo("""
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

    assertThat(table.output()).isEqualTo("""
      || Time |
      || -- |
      || 1ms | 1kb |
      || 0.5ms | 2kb |
      |""".trimMargin())
  }
}