// Function to filter even numbers
def filterEvenNumbers(numbers: List[Int]): List[Int] = {
  numbers.filter(n => n % 2 == 0)
}

// Function to calculate the square of each number
def calculateSquare(numbers: List[Int]): List[Int] = {
  numbers.map(n => n * n)
}

// Helper function to check if a number is prime
def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 until n).exists(i => n % i == 0)
}

// Function to filter prime numbers
def filterPrime(numbers: List[Int]): List[Int] = {
  numbers.filter(n => isPrime(n))
}

// Main object to run the example usage
object Main {
  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val evenNumbers = filterEvenNumbers(input)
    println(evenNumbers)  // Output: List(2, 4, 6, 8, 10)

    val squaredNumbers = calculateSquare(input)
    println(squaredNumbers)  // Output: List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

    val primeNumbers = filterPrime(input)
    println(primeNumbers)  // Output: List(2, 3, 5, 7)
  }
}