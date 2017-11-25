import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class MinHeap
{
  private MinHeap(){};
  private static class MinHeapNode
  {
    char data;
    int freq;
    MinHeapNode left;
    MinHeapNode right;

    MinHeapNode(char data, int freq, MinHeapNode left, MinHeapNode right)
    {
      this.left = left;
      this.right= right;
      this.data = data;
      this.freq = freq;
    }
  }

  private static class compare implements Comparator<MinHeapNode>
  {
    @Override
    public int compare(MinHeapNode node1, MinHeapNode node2)
    {
      return node1.freq - node2.freq;
    }
  }

  public static Map<Character, String> HuffmanCodes(char data[], int freq[], int size)
  {

    final Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
    for(int i = 0; i < size; i++)
    {
      charFreq.put(data[i], freq[i]);
    }

    final MinHeapNode root = buildTree(charFreq);
    final Map<Character, String> charCode = generateCodes(charFreq.keySet(), root);

    return charCode;
  }

  private static Map<Character, String> generateCodes(Set<Character> chars, MinHeapNode node)
  {
       final Map<Character, String> map = new HashMap<Character, String>();
       doGenerateCode(node, map, "");
       return map;
  }


    private static void doGenerateCode(MinHeapNode node, Map<Character, String> map, String s)
    {
        if (node.left == null && node.right == null)
        {
            map.put(node.data, s);
            return;
        }
        doGenerateCode(node.left, map, s + '0');
        doGenerateCode(node.right, map, s + '1' );
    }
  private static MinHeapNode buildTree(Map<Character, Integer> map)
  {
    final Queue<MinHeapNode> nodeQueue = createNodeQueue(map);

    while(nodeQueue.size() > 1)
    {
      final MinHeapNode node1 = nodeQueue.remove();
      final MinHeapNode node2 = nodeQueue.remove();
      MinHeapNode node = new MinHeapNode('\0', node1.freq + node2.freq, node1, node2);
      nodeQueue.add(node);
    }

    return nodeQueue.remove();
  }

  private static Queue<MinHeapNode> createNodeQueue(Map<Character, Integer> map) {
       final Queue<MinHeapNode> pq = new PriorityQueue<MinHeapNode>(11, new compare());
       for (Map.Entry<Character, Integer> entry : map.entrySet()) {
           pq.add(new MinHeapNode(entry.getKey(), entry.getValue(), null, null));
       }
       return pq;
   }

   public static final int ASCII = 128;

     public static void main(String[] args)throws FileNotFoundException, IOException
     {
       if(args.length < 1)
       {
         System.out.println("You did not enter a file name");
       }
       else
       {
        String fileName = args[0];
       int[] frequency = new int[ASCII];
       int number = 0;
       File f = new File(fileName);
       try (FileReader r = new FileReader(f)) {
           while(r.ready()) {
               int ch = r.read();
               if(ch >= 0 && ch < frequency.length)
               {
                   frequency[ch]++;
               }
               number++;
           }
       }
       int total = 0;
       char [] characters = new char[ASCII];
       for(int i = 0; i < ASCII; i++){
           characters[i] = (char)i;
           }


           for (int i = 0; i < ASCII; i++)
           {
             for (int j = i; j < ASCII; j++)
             {
                 if (frequency[i] < frequency[j])
                 {
                     int tempVar = frequency[i];
                     frequency[i] = frequency[j];
                     frequency[j] = tempVar;

                     char tempchar = characters[i];
                     characters[i] = characters[j];
                     characters[j] = tempchar;
                 }
             }
           }

           for(int i = 0; i < ASCII; i++)
           {
               if(frequency[i] > 0)
               {
                 total++;
               }
           }
           int [] realf = new int [total];
           char [] realchar = new char [total];

           for(int i = 0; i < total;i++)
           {
             realf[i] = frequency[i];
             realchar[i] = characters[i];
           }

           for (int i = 0; i < total; i++)
           {
             for (int j = i; j < total; j++)
             {
                 if (realf[i] > realf[j])
                 {
                     int tempVar = realf[i];
                     realf[i] = realf[j];
                     realf[j] = tempVar;

                     char tempchar = realchar[i];
                     realchar[i] = realchar[j];
                     realchar[j] = tempchar;
                 }
             }
           }

           int lengthbefore = 0;
           for(int i = 0; i < realf.length; i++)
           {
             lengthbefore += realf[i];
             System.out.println("Character = "+realchar[i]+" Frequency = "+ realf[i]);

           }
           System.out.println("\n Length before encoding is " + lengthbefore+"\n");

            Map<Character, String> map = new HashMap<Character, String>();
           map = HuffmanCodes(realchar, realf, realchar.length);



           int lengthafter = 0;
           for (Map.Entry<Character,String> entry : map.entrySet())
           {
                char key = entry.getKey();
                String value = entry.getValue();
                lengthafter += value.length();
                System.out.println("Character = "+key+" Codes = "+value);
            }
            lengthafter /= 8;
            System.out.println("\n Length after encoding is " +lengthafter+"\n");
          }
     }

}
