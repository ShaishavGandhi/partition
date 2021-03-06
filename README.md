# Partition

A small library for generating markdown tables. Inspired by [picnic](https://github.com/JakeWharton/picnic)

## Usage

Here's a simple example with Builder APIs
```kotlin
val table = TableBuilder()
    .header("Command", "Description")
    .row("git status", "List all new or modified files")
    .row("git diff", "Show file differences that haven't been staged")
    .build()
    
println(table.toString())
```
that would emit
| Command | Description |
| -- | -- |
| git status | List all new or modified files |
| git diff | Show file differences that haven't been staged |

### DSL

For a more Kotlin-esque API, you can use DSL-like syntax
```kotlin
val table = table {
  header("Command", "Description")
  row("git status", "List all new or modified files")
  row("git diff", "Show file differences that haven't been staged")
}
```

### Cell Alignment

Partition supports cell alignment by specifying it in your table header
```kotlin
val table = table {
  header(
    cell {
      value = "Command"
      alignment = Alignment.START
    },
    cell {
      value = "Description"
      alignment = Alignment.CENTER
    },
    cell {
      value = "Alias"
      alignment = Alignment.END
    }
  )
  row("git status", "List all new or modified files", "s")
  row("git diff", "Show file differences that haven't been staged", "d")
}
```
which yields

| Command | Description | Alias |
| :-- | :--: | --: |
| git status | List all new or modified files | s |
| git diff | Show file differences that haven't been staged | d |

### Regular Markdown

Of course, you can also just use regular markdown in your Cell values as well. 

```kotlin
val table = table {
  header(
    cell {
      value = "Command"
      alignment = Alignment.START
    },
    cell {
      value = "Description"
      alignment = Alignment.CENTER
    },
    cell {
      value = "Alias"
      alignment = Alignment.END
    }
  )
  row("_git status_", "List all new or modified files", "s")
  row("_git diff_", "Show file differences that haven't been staged", "d")
}
```
which yields (notice the italics for the commands)

| Command | Description | Alias |
| :-- | :--: | --: |
| _git status_ | List all new or modified files | s |
| _git diff_ | Show file differences that haven't been staged | d |

## Features

* Explicit table headers
* Cell alignment
* Different markdown providers (upcoming)

## Download

[![Maven Central](https://img.shields.io/maven-central/v/com.shaishavgandhi.partition/partition.svg)](https://mvnrepository.com/artifact/com.shaishavgandhi.partition/partition)

```groovy
implementation 'com.shaishavgandhi.partition:partition:x.y.z'
```

## License

```
Copyright 2020 Shaishav Gandhi.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
