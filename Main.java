package oth.ics.pg2.polynomial;

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
                //Scanner sc = new Scanner(System.in);
    }
}