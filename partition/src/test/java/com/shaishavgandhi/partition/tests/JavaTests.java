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
package com.shaishavgandhi.partition.tests;

import static com.google.common.truth.Truth.assertThat;

import com.shaishavgandhi.partition.*;
import org.junit.Test;

public class JavaTests {
  @Test
  public void test() {
    Table table =
        new TableBuilder()
            .header(
                new Cell("Command"),
                new Cell("Description", Alignment.CENTER),
                new Cell("Alias", Alignment.END))
            .row("git status", "List all new or modified files", "s")
            .row("git diff", "Show file differences that haven't been staged", "d")
            .build();

    assertThat(table.toString())
        .isEqualTo(
            "| Command | Description | Alias |\n"
                + "| -- | :--: | --: |\n"
                + "| git status | List all new or modified files | s |\n"
                + "| git diff | Show file differences that haven't been staged | d |"
                + "\n");
  }


  @Test
  public void testToBuilder() {
    TableBuilder tableBuilder =
        new TableBuilder()
            .header(
                new Cell("Command"),
                new Cell("Description", Alignment.CENTER),
                new Cell("Alias", Alignment.END))
            .row("git status", "List all new or modified files", "s")
            .row("git diff", "Show file differences that haven't been staged", "d");

    assertThat(tableBuilder.build().toBuilder()).isEqualTo(tableBuilder);
  }
}
