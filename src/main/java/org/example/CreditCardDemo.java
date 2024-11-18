package org.example;

/**
 This program demonstrates the CreditCard class.
 */
public class CreditCardDemo
{
    public static void main(String[] args)
    {
// Named constants
        final Money CREDIT_LIMIT = new Money(1000);
        final Money FIRST_AMOUNT = new Money(200);
        final Money SECOND_AMOUNT = new Money(10.02);
        final Money THIRD_AMOUNT = new Money(25);
        final Money FOURTH_AMOUNT = new Money(990);
// Create an instance of the Person class.
        Person owner = new Person("Christie", "Diane", new Address("237J Harvey Hall", "Menomonie", "WI", "54751"));
// Create an instance of the CreditCard class.
        CreditCard visa = new CreditCard(owner, CREDIT_LIMIT);
// Display the credit card information.
        System.out.println(visa.getPersonals());
        System.out.println("Balance: " + visa.getBalance());
        System.out.println("Credit Limit: " + visa.getCreditLimit());
        System.out.println(); // To print a new line
// Attempt to charge the first amount and
// display the results.
        System.out.println("Attempting to charge " + FIRST_AMOUNT);
        visa.charge(FIRST_AMOUNT);
        System.out.println("Balance: " + visa.getBalance());
        System.out.println(); // To print a new line
// Attempt to charge the second amount and
// display the results.
        System.out.println("Attempting to charge " + SECOND_AMOUNT);
        visa.charge(SECOND_AMOUNT);
        System.out.println("Balance: " + visa.getBalance());
        System.out.println(); // To print a new line
// Attempt to pay using the third amount and
// display the results.
        System.out.println("Attempting to pay " + THIRD_AMOUNT);
        visa.payment(THIRD_AMOUNT);
        System.out.println("Balance: " + visa.getBalance());
        System.out.println(); // To print a new line
// Attempt to charge using the fourth amount and
// display the results.
        System.out.println("Attempting to charge " + FOURTH_AMOUNT);
        visa.charge(FOURTH_AMOUNT);
        System.out.println("Balance: " + visa.getBalance());
    }
}

class CreditCard{

    private Person owner = null;
    private Money creditLimit = null;
    private Money balance = null;

    CreditCard(Person owner, Money creditLimit){
        this.owner = owner;
        this.creditLimit = creditLimit;
        this.balance = new Money(0);
    }

    public Money getBalance(){
        return balance;
    }
    public Money getCreditLimit(){
        return creditLimit;
    }
    public String getPersonals(){
        return owner.toString();
    }
    public void charge(Money amount){
        if (balance.add(amount).compareTo(creditLimit) <= 0) {
            balance = balance.add(amount);
        } else {
            System.out.println("Exceeds credit limit");
        }
    }
    public void payment(Money amount){
        balance = balance.subtract(amount);
    }

}