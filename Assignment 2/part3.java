import java.util.Arrays;
import java.util.Collections;

public class part3
{
  public static void Knapsack(double[] value, double[] weight, double maxweight)
  {
    double [] density = new double [value.length];
    for(int i = 0; i < density.length; i++)
    {
      density[i] = value[i]/weight[i];
    }

    //Sort the density in descending order
    //Arrays.sort(density, Collections.reverseOrder());
    //System.out.println(java.util.Arrays.toString(density));
    double [] Knapsackweight = new double [density.length];
    double [] Knapsackvalue = new double [density.length];

    double tempVar, tempvalue, tempweight;
    String numbersString;

    for (int i = 0; i < density.length; i++)
    {
      for (int j = i; j < density.length; j++)
      {
          if (density[i] < density[j])
          {
              tempVar = density[i];
              density[i] = density[j];
              density[j] = tempVar;

              tempweight = weight[i];
              weight[i] = weight[j];
              weight[j] = tempweight;

              tempvalue = value[i];
              value[i] = value[j];
              value[j] = tempvalue;
          }
      }
    }

System.out.println(java.util.Arrays.toString(weight));
    double spaceavailable = maxweight;
    int index = 0;
    while (index < Knapsackweight.length )
    {
      if(weight[index] <= spaceavailable)
      {
         Knapsackweight[index] = weight[index];
         Knapsackvalue[index] = value[index];
        System.out.println("Item of weight " + Knapsackweight[index] + " and value " + Knapsackvalue[index] + " is chosen");
      }

      else
      {
        double percentage = spaceavailable/weight[index];
        Knapsackweight[index] = weight[index] * percentage;
        Knapsackvalue[index] = value[index] * percentage;
        System.out.println("Item of weight " + Knapsackweight[index] + " and value " + Knapsackvalue[index] + " is chosen");
        break;
      }
      spaceavailable = spaceavailable - weight[index];
      index++;
    }
  }

  public static void main(String args[])
  {
    double [] value = {20,30,40,50,1000,100};
    double [] weight = {1,2,3,4,6,10};
    double max = 15.0;

    Knapsack(value, weight, max);
  }
}
