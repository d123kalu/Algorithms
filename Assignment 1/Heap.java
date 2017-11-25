//ONYEDIKACHI KALU 100557846
//Got everything to work except print tree
public class Heap
{
  public static int array[] = {12, 11, 13, 5, 6, 7, 6, 20, 16, 19, 1};
  public static void main(String[] args)
  {
    build_max_heap(array);
    int max = heap_maximum(array);
    System.out.println("max->"+ max);
    printArray(array);
    int extractedmax = heap_extract_max(array);
    System.out.println("extracted max->"+extractedmax);
    printArray(array);
    //max_heap_insert(array,30);
    //System.out.println("inserting 30 at next available slot ->");
    //printArray(array);
    //printAsTree(0,0);
  }

  public static void build_max_heap(int[] array)
  {
    int heapsize = array.length;
    for (int i = (heapsize/2); i >=0;i--)
    {
      max_heapify(array,i);
    }

  }

  public static void max_heapify(int[] array, int index)
  {
    int l = (index * 2) + 1;
    int r = l + 1;
    int n = array.length;
    int largest = index;

    if(l < n && array[l] > array[index])
    {
      largest = l;
    }


    if(r < n && array[r] > array[largest])
    {
      largest = r;
    }

    if(largest != index)
    {
      int temp = array[index];
      array[index] = array[largest];
      array[largest] = temp;
      max_heapify(array,largest);
    }
  }

  public static Integer heap_maximum(int[] array)
  {
      if(array.length == 0)
      {
        return null;
      }
      return array[0];
  }

  public static Integer heap_extract_max(int[] array)
  {

    if (array.length < 1)
    {
      System.out.println("heap underflow");
      return null;
    }

    int max = array[0];
    array[0] = array[array.length - 1];
    int[] temp = new int[array.length -1];

    for(int i =0;i<temp.length;i++)
    {
      temp[i] = array[i];
    }
    Heap.array = temp;

    max_heapify(temp,0);
    //System.out.println(java.util.Arrays.toString(array));
    return max;
  }

  public static void max_heap_insert(int[] array, int x)
  {
    //array  = java.util.Arrays.copyOf(array, array.length + 1);

    int[] temp = new int[array.length +1];

    for(int i =0;i<temp.length - 1;i++)
    {
      temp[i] = array[i];
    }
    Heap.array = temp;

    //array[array.length - 1] = x;

    //System.out.println(java.util.Arrays.toString(temp));
    //int i = array.length - 1;
  /*  while (array[i] > array[parent(i)] && i > 0)
    {
      int TEMP = array[i];
      array[i] = array[parent(i)];
      array[parent(i)] = TEMP;

      i = parent(i);
    }
    */
    temp[temp.length -1] = x;
    int i = temp.length -1;
    while (temp[i] > temp[parent(i)] && i > 0)
    {
      int TEMP = temp[i];
      temp[i] = temp[parent(i)];
      temp[parent(i)] = TEMP;

      i = parent(i);
    }
    Heap.array = temp;
  }

  public static int parent(int i)
  {
    return ((i)/2);
  }

  public static void printArray(int array[])
  {
    System.out.println(java.util.Arrays.toString(array));
  }

  public static void printAsTree(int indent,int i)
  {
      int l = ((2*i)+1);
      int r = ((2*i)+2);
      if (r < (array.length -1))
      {
          printAsTree(indent+1, r);
      }
      for(int inc =0;inc < indent; inc++)
      {
          System.out.println("\t");
      }
      System.out.print(array[i]);
      if (l < (array.length - 1))
      {
          printAsTree(indent+1, l);
      }
  }

}
