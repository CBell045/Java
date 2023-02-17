public class Budget {
    String budgetName;
    double budgetAmount;

    public Budget(String name, double amount) {
        budgetName = name;
        budgetAmount = amount;
    }

    public static void main(String[] args) {
        Budget myBudget = new Budget("My First Budget", 350.00);

        System.out.println("Budget Name: " + myBudget.budgetName + "\nBudget Amount: " + myBudget.budgetAmount );
    }
}
