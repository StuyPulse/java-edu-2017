public class BankAccount {
    public String ownerName;
    public double balance;
    public int accountNumber;

    public BankAccount(String name, double startingValue, int accountNum) {
        ownerName = name;
        balance = startingValue;
        accountNumber = accountNum;
    }

    public void deposit(double amountToDeposit) {
        balance += amountToDeposit;
    }

    public void sayHello() {
        // We can use + to combine values into a bigger String:
        System.out.println("Good morning " + ownerName + "!");
        System.out.println("You have " + balance + " dollars in the bank.");
    }

    // The "main" method is the starting point for any Java program (the
    // thing that actually runs when you say "execute this program"). Don't
    // worry about the "static" and "String[]" for now.
    public static void main(String[] args) {
        BankAccount fredsAccount = new BankAccount("Fred Smith", 0.0, 98537485);

        // We've started fredsAccount with 0.0 dollars. Let's give him more:
        fredsAccount.deposit(100.0);
        fredsAccount.sayHello();

        // We can access fredsAccount's fields with the dot operator '.'
        double hisBalance = fredsAccount.balance;

        // And we can display them to the screen
        System.out.println(fredsAccount.ownerName);
        System.out.println(fredsAccount.balance);
    }
}
