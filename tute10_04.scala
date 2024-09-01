// Define the Account class
case class Account(accountNumber: String, balance: Double)

object Bank {

  // 4.1 List of Accounts with negative balances
  def accountsWithNegativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def totalBalance(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  // 4.3 Calculate the final balances after applying interest
  def finalBalancesAfterInterest(accounts: List[Account]): List[Account] = {
    accounts.map { account =>
      if (account.balance > 0)
        account.copy(balance = account.balance * 1.05) // Deposit interest of 5%
      else
        account.copy(balance = account.balance * 1.1)  // Overdraft interest of 10%
    }
  }

  def main(args: Array[String]): Unit = {
    // Sample list of accounts
    val accounts = List(
      Account("A001", 500.0),
      Account("A002", -100.0),
      Account("A003", 1200.0),
      Account("A004", -50.0)
    )

    // 4.1: List accounts with negative balances
    val negativeAccounts = accountsWithNegativeBalances(accounts)
    println("Accounts with negative balances:")
    negativeAccounts.foreach(println)

    // 4.2: Calculate total balance of all accounts
    val total = totalBalance(accounts)
    println(s"\nTotal balance of all accounts: $total")

    // 4.3: Calculate final balances after applying interest
    val finalBalances = finalBalancesAfterInterest(accounts)
    println("\nFinal balances after applying interest:")
    finalBalances.foreach(println)
  }
}
