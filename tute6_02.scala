import scala.io.StdIn.readLine

object StudentRecords {

  def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      return (false, Some("Name cannot be empty"))
    }
    val marksInt = marks.toIntOption
    val totalMarksInt = totalMarks.toIntOption
    if (marksInt.isEmpty || totalMarksInt.isEmpty) {
      return (false, Some("Marks and total possible marks must be integers"))
    }
    if (marksInt.get < 0 || totalMarksInt.get < 0) {
      return (false, Some("Marks and total possible marks must be positive"))
    }
    if (marksInt.get > totalMarksInt.get) {
      return (false, Some("Marks cannot exceed total possible marks"))
    }
    (true, None)
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val name = readLine("Enter student's name: ")
    val marks = readLine("Enter student's marks: ")
    val totalMarks = readLine("Enter total possible marks: ")

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
    if (!isValid) {
      println(s"Invalid input: ${errorMessage.get}")
      return getStudentInfo()
    }

    val marksInt = marks.toInt
    val totalMarksInt = totalMarks.toInt
    val percentage = (marksInt.toDouble / totalMarksInt) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (name, marksInt, totalMarksInt, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks / $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var record: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')
    while (!valid) {
      val name = readLine("Enter student's name: ")
      val marks = readLine("Enter student's marks: ")
      val totalMarks = readLine("Enter total possible marks: ")

      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        valid = true
        val marksInt = marks.toInt
        val totalMarksInt = totalMarks.toInt
        val percentage = (marksInt.toDouble / totalMarksInt) * 100
        val grade = percentage match {
          case p if p >= 90 => 'A'
          case p if p >= 75 => 'B'
          case p if p >= 50 => 'C'
          case _ => 'D'
        }
        record = (name, marksInt, totalMarksInt, percentage, grade)
      } else {
        println(s"Invalid input: ${errorMessage.get}")
      }
    }
    record
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}