public class part2
{
  public static int[] RadixSort(int[] array)
  {
    System.out.println("Array is in RadixSort");
    int max = array[0];
    int length = array.length;
    for(int i = 0; i < length; i++)
      {
          if(max < array[i])
          {
              max = array[i];
          }
      }
    int maxdigit = getnumofdigit(max);
    int i = 1;
    while (i <= maxdigit)
    {
      int [] sorted = new int [length];
      System.out.println("Sending array to Sort with digit" + i);
      sorted = Sort(array, i);
      array = sorted;
      i++;
    }
    return array;
  }

  public static int[] Sort(int[] array, int digit)
  {
    System.out.println("Array is in Sort");
    int length = array.length;
    int [] sortedarray = new int [length];

    int [] count = new int[length];
    for(int i=0; i<length; i++)
    {
      count[i] = 0;
    }

    for(int i=0; i<length; i++)
    {
       count[getDigit(array[i],digit)] = count[getDigit(array[i],digit)] + 1;
    }

    for(int i=1; i<=length-1; i++)
    {
       count[i] += count[i-1];
    }

    for(int i= length-1; i >= 1; i--)
    {
      sortedarray[count[getDigit(array[i],digit)]-1] = array[i];
      count[getDigit(array[i],digit)] = count[getDigit(array[i],digit)] -1;
    }

    return sortedarray;
  }


  public static int getnumofdigit(int n)
  {
    int length = (int)(Math.log10(n)+1);
    return length;
  }

  public static int getDigit(int num, int digit)
  {
    double n = num;
    int exp = digit -1;
    double working = n / Math.pow((double)10, (double)exp);
    double ans = working % 10;
    int r = (int)ans;
    return r;
  }

  public static void main(String args[])
  {
    int [] array = {20,50,6,3,13,30,40};
    int length = array.length;

    System.out.println("Sending Array to Radix Sort");
    int [] sorted = RadixSort(array);

    System.out.println("Old array");
    for(int i = 0; i < length; i++)
      {
        System.out.print(array[i] + "\t");
      }

      System.out.println("\nNew array");
      for(int i = 0; i < length; i++)
        {
          System.out.print(sorted[i] + "\t");
        }

  }
}
