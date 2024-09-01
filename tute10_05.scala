object WordLengthCounter {

  def countLetterOccurrences(words: List[String]): Int = {
    // Step 1: Use map to get the length of each word
    val wordLengths = words.map(_.length)

    // Step 2: Use reduce to sum the lengths and get the total count of letter occurrences
    val totalLetters = wordLengths.reduce(_ + _)

    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val totalCount = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalCount")
  }
}
