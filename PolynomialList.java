package oth.ics.pg2.polynomial.list;
import oth.ics.pg2.polynomial.Polynomial;
import java.util.ArrayList;
import java.util.List;

public class PolynomialList
{
  private final List<Polynomial> pol = new ArrayList<>();

  public int size()
  {
    return pol.size() ;
  }

  public void printFullList()
    {
      for (int i = 0; i< pol.size(); i++)
      {
          System.out.println("["+ i + "]"+ pol.get(i));
      }
    }

    public Polynomial getByIndex(int index)
  {
      if (index >= 0 && index < pol.size()) // To prevent wrong input
      {
          return pol.get(index);
      }
      return null;
  }

    public Polynomial getById(int id) {
        for (Polynomial p : pol) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

  public void add(Polynomial p)
  {
      pol.add(p);
  }

  public boolean deleteById (int id)
  {
      return pol.removeIf(p ->p.getId() == id);
  }

}
