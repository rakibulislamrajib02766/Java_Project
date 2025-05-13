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

        public String toString()
        {
            String polynom = "["+id + "] Y = ";
            for (int i = coefficient.length - 1; i >= 0; i--)
            {
                if (i >= 0 && i <= coefficient.length - 1 && coefficient[i] >= 0)
                {
                    polynom+= " + ";
                }
                polynom += coefficient[i] + "x^" + i;
            } ;
            return polynom;
        }

        public String derivative()
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
        }

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

}
