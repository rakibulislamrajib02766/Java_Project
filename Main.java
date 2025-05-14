package oth.ics.pg2.polynomial;
import oth.ics.pg2.polynomial.list.PolynomialList;
public class Main
{
    public static void main(String[] args)
    {
                Polynomial fip = new Polynomial(new double[]{7, 3, -2});
                Polynomial fip1 = new Polynomial(new double[]{3, -1});
                Polynomial sum = fip.ad(fip1);
                System.out.println(fip.getEquation());
                System.out.println("Result = "+fip.evaluate(3));
                System.out.println("Degree = "+fip.degree());
                System.out.println(fip.derivative());
                System.out.println(sum);

                PolynomialList pol = new PolynomialList();
                pol.add(new Polynomial(new double[]{1, 2}));
                pol.add(new Polynomial(new double[]{3, 4, 5}));
                System.out.println("Total Polynomials Stored: "+pol.size());
                pol.printFullList();

                int idToDelete = pol.getByIndex(0).getId();
                boolean deleted = pol.deleteById(idToDelete);
                System.out.println("Deleted: "+ deleted);
                System.out.println("After deleted, the list: ");
                pol.printFullList();
                //Scanner sc = new Scanner(System.in);
    }
}