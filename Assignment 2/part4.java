import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class part4
{
  public static final int ASCII = 128;

    public static void main(String[] args)throws FileNotFoundException, IOException
    {

      String fileName = "C:\\Users\\DK\\Documents\\Documents\\3rd year 1st semester\\Design and algorithms\\Assignment 2\\data.txt";
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

          java.util.Arrays.sort(realf);
          java.util.Arrays.sort(realchar);

    }



}
