class Account(var balance: Double) {
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdraw amount must be positive")
    if (amount <= balance) {
      balance -= amount
    } else {
      throw new IllegalArgumentException("Insufficient funds")
    }
  }

  def transfer(amount: Double, to: Account): Unit = {
    this.withdraw(amount)
    to.deposit(amount)
  }

  override def toString: String = s"Balance: $balance"
}

object Main {
  def main(args: Array[String]): Unit = {
    // Example usage
    val acc1 = new Account(1000)
    val acc2 = new Account(500)

    println("Initial balances:")
    println(s"Account 1: $acc1")
    println(s"Account 2: $acc2")

    acc1.transfer(200, acc2)

    println("Balances after transfer:")
    println(s"Account 1: $acc1")
    println(s"Account 2: $acc2")
  }
}