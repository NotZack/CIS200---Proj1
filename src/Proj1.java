import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Proj1.java
 * Zackary Nichol / Friday 3:30PM lab session
 *
 * PART 1: Asks the user for which item then cost of that item that they would like to purchase.
 * Then calculates a finance plan for the item purchase. Prints out all to the console.
 *
 * PART 2: Asks the user for which brand, model, and price of computer they would like to purchase, then calculates the
 * cost of sales tax upon the input price. Prints out all to the console.
 */

public class Proj1 {

    private static final double FINANCE_RATE = 0.03;
    private static final int NUM_OF_MONTHS = 12;

    private static final double TAX_RATE = 0.0615;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        collectItem(input);
        calculatePayment(collectItemPrice(input));
        collectComputerInfo(input);
    }

    private static void collectItem(Scanner input) {
        System.out.print("Enter the item to be purchased: ");
        input.nextLine();
    }

    private static double collectItemPrice(Scanner input) {
        System.out.print("Enter the amount of the purchase: ");
        return Double.parseDouble(input.nextLine());
    }

    private static void calculatePayment(double itemPrice) {
        DecimalFormat form = new DecimalFormat("#,###.##");
        double monthlyPayment = ((itemPrice * FINANCE_RATE) + itemPrice) / NUM_OF_MONTHS;
        double totalPayment = itemPrice + (itemPrice * FINANCE_RATE);

        System.out.println("Your monthly payment is $" + form.format(monthlyPayment));
        System.out.println("Your total payment is $" + form.format(totalPayment));
        System.out.println("Amount paid in financing is $" + form.format(totalPayment - itemPrice) + '\n');
    }

    private static void collectComputerInfo(Scanner input) {
        DecimalFormat form = new DecimalFormat("#,###.##");

        System.out.print("What brand of computer do you wish to purchase? ");
        String brand = input.nextLine();
        System.out.print("Which model? ");
        String model = input.nextLine();
        System.out.print("Enter the cost of the computer: ");
        double cost = Double.parseDouble(input.nextLine());
        System.out.print("\n");

        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Sales tax: $" + form.format(TAX_RATE * cost));
        System.out.println("Total Cost: $" + form.format(cost + (TAX_RATE * cost)));
    }
}
