# Partition

A small library for generating markdown tables. Inspired by [picnic](https://github.com/JakeWharton/picnic)

## Download

Snapshots are currently deployed

```groovy
implementation 'com.shaishavgandhi.partition:partition:0.1.0-SNAPSHOT'
```

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

## Features

* Explicit table headers
* Cell alignment
* Different markdown providers (upcoming)

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
