case class Book(title: String, author: String, isbn: String)

object Library {
  var books: Set[Book] = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "2345678901"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "3456789012")
  )

  def addBook(book: Book): Unit = {
    books += book
  }

  def removeBook(isbn: String): Unit = {
    books = books.filterNot(_.isbn == isbn)
  }

  def isBookInLibrary(isbn: String): Boolean = {
    books.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchBookByTitle(title: String): Option[Book] = {
    books.find(_.title.equalsIgnoreCase(title))
  }

  def displayBooksByAuthor(author: String): Unit = {
    books.filter(_.author.equalsIgnoreCase(author)).foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
  }

  def main(args: Array[String]): Unit = {
    println("Initial Library Collection:")
    displayLibrary()

    println("\nAdding a new book:")
    addBook(Book("Brave New World", "Aldous Huxley", "4567890123"))
    displayLibrary()

    println("\nRemoving a book by ISBN:")
    removeBook("2345678901")
    displayLibrary()

    println("\nChecking if a book is in the library by ISBN:")
    println(isBookInLibrary("1234567890")) // true
    println(isBookInLibrary("2345678901")) // false

    println("\nSearching for a book by title:")
    searchBookByTitle("1984").foreach(book => println(s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))

    println("\nDisplaying all books by a specific author:")
    displayBooksByAuthor("George Orwell")
  }
}