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
 * DSL entry point for Kotlin consumers.
 */
fun table(builder: TableBuilder.() -> TableBuilder): Table {
  val tableBuilder = TableBuilder()
  return tableBuilder.builder().build()
}

/**
 * DSL entry point for Kotlin consumers to create a [Cell].
 */
fun cell(builder: CellBuilder.() -> Unit): Cell = CellBuilder().apply(builder).build()
