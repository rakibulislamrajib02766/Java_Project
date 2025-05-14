package oth.ics.pg2.polynomial;
import java.util.*;
public class Polynomial
{

        private static int counter = 0;
        private final int id;
        private final double []coefficient;
        private String equation;

        public Polynomial(double[]coefficient)
        {
            //this(new double[]{0});
            this.id = ++counter;
            this.coefficient = coefficient.clone();
            this.equation = toString();
        }
        public int getId()
        {
            return id;
        }
        public double[] getcoefficient()
        {
            return coefficient.clone();
        }
        public String getEquation()
        {
            return equation;
        }

    public String toString() {
        String polynom = "[" + id + "] Y = ";
        boolean first = true;

        for (int i = coefficient.length - 1; i >= 0; i--) {
            if (coefficient[i] == 0) {
                continue; // skip zero terms
            }

            if (!first) {
                if (coefficient[i] > 0) {
                    polynom += " + ";
                } else {
                    polynom += " - ";
                }
            } else {
                if (coefficient[i] < 0) {
                    polynom += "-";
                }
                first = false;
            }

            double absVal = Math.abs(coefficient[i]);
            if (absVal != 1 || i == 0) {
                polynom += absVal;
            }

            if (i > 0) {
                polynom += "x";
                if (i > 1) {
                    polynom += "^" + i;
                }
            }
        }

        if (first) {
            polynom += "0"; // when all coefficients are zero
        }

        return polynom;
    }

    public Polynomial derivative() {
        if (coefficient.length <= 1) {
            return new Polynomial(new double[]{0}); // derivative of constant is 0
        }

        double[] derivedCoefficients = new double[coefficient.length - 1];
        for (int i = 1; i < coefficient.length; i++) {
            derivedCoefficients[i - 1] = coefficient[i] * i;
        }
        return new Polynomial(derivedCoefficients);
    }

        /*public String derivative()
        {
            String dq="["+id + "] Y' = ";
            for (int i = coefficient.length - 1; i >= 1; i--)
            {
                if (i >= 0 && i < coefficient.length - 1 && coefficient[i] >= 0) {
                    dq += " + ";
                }
                dq += coefficient[i] * i + "x^" + (i - 1);
            } ;

            return dq;
        }*/

        public double evaluate( double x)
        {
            double result=0;
            for (int i = coefficient.length - 1; i >= 0; i--)
            {
                result += coefficient[i] * Math.pow(x, i);
            }
            return result;
        }

        public int degree()
        {
            for (int i = coefficient.length - 1; i >= 0; i--)
            {
               if (coefficient[i] !=0)
               {
                   return i;
               }

            }
            return 0;
        }

        public Polynomial ad(Polynomial other)
        {
            double [] a = this.coefficient;
            double [] b = other.getcoefficient();
            int max = Math.max(a.length, b.length);
            double [] ad = new double[max];
            for (int i=0; i <max; i++)
            {
                if (i < a.length)
                    ad[i] += a[i];
                if (i < b.length)
                    ad[i] += b[i];
            }
            return new Polynomial(ad);
        }

       /* public void something()
        {
            List<Polynomial> polyList = new ArrayList<>();
        }
        */

    public Polynomial add(Polynomial other) {
        int max = Math.max(this.coefficient.length, other.coefficient.length);
        double[] result = new double[max];

        for (int i = 0; i < max; i++) {
            if (i < this.coefficient.length) {
                result[i] += this.coefficient[i];
            }
            if (i < other.coefficient.length) {
                result[i] += other.coefficient[i];
            }
        }

        return new Polynomial(result);
    }
}
