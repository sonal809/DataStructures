
public class ArrayQues {
//Find three numbers such that a[i]<a[j]<a[k] and i<j<k
	void find3numbers(){
	int[] arr = new int[]{4,7,5,1,3,8,9,6,2};
    int size = 9;
    int[] mini = new int[size];
    int[] maxi = new int[size];
    mini[0] = 0;
    maxi[size-1] = size-1;

    int min = arr[0];
    int max = arr[size-1];
    for (int i = 1; i < size; i++)
    {
      if (arr[i] < min)
      {
        min = arr[i];
        mini[i] = i;
      }
      else
        mini[i] = mini[i-1];
       System.out.print (mini[i] + "  ");
    }
    System.out.println();
    for (int i = size-2; i >= 0; i--)
    {
      if (arr[i] > max)
      {
        max = arr[i];
        maxi[i] = i;
      }
      else
        maxi[i] = maxi[i+1];
       System.out.print (maxi[i] + "  ");
    }
    System.out.println();

    System.out.println("The output : ");
    for (int i = 0; i < size; i++)
      if (arr[mini[i]] < arr[i] && arr[i] < arr[maxi[i]])
      System.out.println(arr[mini[i]] + " < " + arr[i] + " < " + arr[maxi[i]]);

  }

	public static void main(String args[]){
		ArrayQues ques=new ArrayQues();
		ques.find3numbers();
	}
}

