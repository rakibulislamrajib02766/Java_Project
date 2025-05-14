package oth.ics.pg2.polynomial.cli;
import java.io.PrintStream; import java.util.Locale; import java.util.Scanner; import oth.ics.pg2.polynomial.list.PolynomialList; import oth.ics.pg2.polynomial.Polynomial;

public class PolynomialCLI {

    private final PrintStream consoleOut;
    private final Scanner consoleIn;
    private final PolynomialList polynomialList;

    public PolynomialCLI(PrintStream consoleOut, Scanner consoleIn) {
        this.consoleOut = consoleOut;
        this.consoleIn = consoleIn;
        this.consoleIn.useDelimiter("\n");
        this.consoleIn.useLocale(Locale.ENGLISH);
        this.polynomialList = new PolynomialList();
    }

    public static void main(String[] args) {
        new PolynomialCLI(System.out, new Scanner(System.in)).run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            running = showMainMenu();
        }
    }

    private boolean showMainMenu() {
        consoleOut.println("""
    (1) Show current polynomials
    (2) Evaluate a polynomial
    (3) Create new polynomial from input
    (4) Add two polynomials
    (5) Calculate derivative of a polynomial
    (6) Delete a polynomial
    (9) Exit
    """);

        if (consoleIn.hasNextInt()) {
            switch (consoleIn.nextInt()) {
                case 1 -> showPolynomials();
                case 2 -> evaluatePolynomial();
                case 3 -> createPolynomialFromInput();
                case 4 -> addPolynomials();
                case 5 -> derivePolynomial();
                case 6 -> deletePolynomial();
                case 9 -> {
                    return false;
                }
                default -> consoleOut.println("Invalid option.");
            }
        } else {
            consoleOut.println("Invalid input: " + consoleIn.next());
        }
        return true;
    }

    private void showPolynomials() {
        for (int i = 0; i < polynomialList.size(); i++) {
            Polynomial p = polynomialList.getByIndex(i);
            consoleOut.println("[" + p.getId() + "] y = " + p);
        }
    }

    private void evaluatePolynomial() {
        consoleOut.print("ID of polynomial to evaluate: ");
        int id = consoleIn.nextInt();
        Polynomial p = polynomialList.getById(id);
        if (p != null) {
            consoleOut.print("Value of x: ");
            double x = consoleIn.nextDouble();
            consoleOut.println("y = " + p.evaluate(x));
        } else {
            consoleOut.println("Polynomial not found.");
        }
    }

    private void createPolynomialFromInput() {
        consoleOut.print("Degree of new polynomial: ");
        int degree = consoleIn.nextInt();
        double[] coefficients = new double[degree + 1];

        for (int i = 0; i <= degree; i++) {
            consoleOut.print("Coefficient for factor x^" + i + ": ");
            coefficients[i] = consoleIn.nextDouble();
        }

        Polynomial p = new Polynomial(coefficients);
        polynomialList.add(p);
        consoleOut.println("Created polynomial [" + p.getId() + "] y = " + p);
    }

    private void addPolynomials() {
        consoleOut.print("ID of first polynomial to add: ");
        int id1 = consoleIn.nextInt();
        Polynomial p1 = polynomialList.getById(id1);

        consoleOut.print("ID of second polynomial to add: ");
        int id2 = consoleIn.nextInt();
        Polynomial p2 = polynomialList.getById(id2);

        if (p1 != null && p2 != null) {
            Polynomial sum = p1.add(p2);
            polynomialList.add(sum);
            consoleOut.println("Created polynomial [" + sum.getId() + "] y = " + sum);
        } else {
            consoleOut.println("One or both polynomials not found.");
        }
    }

    private void derivePolynomial() {
        consoleOut.print("ID of polynomial to calculate derivative for: ");
        int id = consoleIn.nextInt();
        Polynomial p = polynomialList.getById(id);
        if (p != null) {
            Polynomial derivative = p.derivative();
            polynomialList.add(derivative);
            consoleOut.println("Created polynomial [" + derivative.getId() + "] y = " + derivative);
        } else {
            consoleOut.println("Polynomial not found.");
        }
    }

    private void deletePolynomial() {
        consoleOut.print("ID of polynomial to delete: ");
        int id = consoleIn.nextInt();
        boolean deleted = polynomialList.deleteById(id);
        if (deleted) {
            consoleOut.println("Deleted polynomial [" + id + "]");
        } else {
            consoleOut.println("Polynomial not found.");
        }
    }

}
//Some of the concept i have learned from AI.