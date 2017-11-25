//ONYEDIKACHI KALU 100557846
//Code doesnt work if the word you are looking for has a space in it
public class Divide
{
  public static void main(String[] args)
  {
    String paragraph = "his works well , thanks";

    String word = "his works";

    boolean ans = dikachi(paragraph,  word);
    System.out.println(ans);
  }

  public static int getstart(String p, int m)
  {
    int start = 0;
    int i = m;
    String c = " ";

    while(i >= 0)
    {
      if (p.charAt(i) == c.charAt(0))
      {
        start = i+1;
        if(start < 0)
        {
          start = 0;
        }
        if(start >m)
        {
          start = m;
        }
        break;
      }
      i--;
    }

    return start;
  }

  public static int getend(String p, int m)
  {
    int end = p.length()-1;

    int e = m;
    String c = " ";
    while(e <= p.length()-1)
    {
      if (p.charAt(e) == c.charAt(0))
      {
        end = e;
        break;
      }
      e++;
    }
    return end;
  }

  public static boolean dikachi(String p, String w)
  {
      int lengthofarray = p.length() - 1;
      int middle = (lengthofarray/2);
      System.out.println(p + "and word is " + w);

      if (p.length() <= w.length())
      {
        return (p.equals(w));
      }

      else
      {
        int start = getstart(p,middle);
        int end = getend(p,middle);
        if(end >lengthofarray)
        {
          end = lengthofarray;
        }
        if(end < 0)
        {
          end = 0;
        }

        String temp = p.substring(start,end);

        if (temp.equals(w))
        {
          return true;
        }

        else
        {
          //Here is where the divide and conquer happens
          String two = p.substring(middle,lengthofarray);
          String half1 = p.substring(0,middle);

            return (dikachi(half1,w) || dikachi(two,w));

          }
      }
  }
}
