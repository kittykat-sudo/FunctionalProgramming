object Main extends App {
    //part1
    def reverseString(str: String): String = {
        if (str.isEmpty) ""
        else reverseString(str.tail) + str.head
    }

    val originalString = "Hello, World!"
    val reversedString = reverseString(originalString)
    println(s"Original: $originalString")
    println(s"Reversed: $reversedString")

    //part2
    def filterStringByLength(strings: List[String], minLength: Int = 5): List[String] = {
        strings.filter(_.length > minLength)
    }

    val strings = List("Scala", "Java", "Python", "C", "JavaScript")
    val minLength = 5
    val filteredStrings = filterStringByLength(strings, minLength)
    
    println(s"Original List: $strings")
    println(s"Filtered List (length > $minLength): $filteredStrings")

    //part3
    def arithmeticMean(num1: Int, num2: Int): Double = {
        val mean = (num1 + num2) / 2.0
        BigDecimal(mean).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

    val num1 = 5
    val num2 = 10
    val mean = arithmeticMean(num1, num2)

    println(s"The arithmetic mean of $num1 and $num2 is $mean")

    //part4
    def sumOfEvenNumbers(numbers: List[Int]): Int = {
        numbers.filter(_ % 2 == 0).sum //_ is a placeholder for each element in the collection as it is being iterated over. 
    }

    // Test the function
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val sum = sumOfEvenNumbers(numbers)

    println(s"The sum of all even numbers in the list is $sum")
}


def filterstringbylength (strings: List[String], minLength: Int=5): List[String] = {
    strings.filter(_.length > minLength) //is a predicate function passed to filter. For each string in the strings list, it checks whether the string's length (_.length) is greater than minLength.
}