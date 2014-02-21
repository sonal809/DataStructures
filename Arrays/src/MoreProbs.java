import java.util.Arrays;

import java.util.Arrays;
public class MoreProbs {

    	//Print the indexes where the sume from the starting index to the specified
		//is same as the sum of the numbers from backward.
		public static void equalSum(int[] arr){
			int frontSum=0, backsum=0;
			int count=0;
			for(int i=0;i<arr.length;i++){
				backsum=backsum+arr[i];
			}
			for(int i=0;i<arr.length;i++){
				backsum=backsum-arr[i];
				if(frontSum==backsum){
					count++;
					System.out.println(i + " ");
				}
				frontSum=frontSum+arr[i];
			}

			System.out.println("count is: " + count);

		}

        //Find pair of indices whose numbers sum upto k. The numbers should be distinct.

        public static void sumToK(int[] arr, int k){
            Arrays.sort(arr);
            int i=0;
            int j=arr.length-1;
            int count=0;
            while (i<j){
                if(arr[i]+arr[j] ==k){
                    System.out.println(arr[i]+ " " + arr[j]);
                    count++;
                    i++;
                    j--;
                }
                else if(arr[i] + arr [j] < k){
                    i++;
                }
                else j--;

            }
            if(count==0) System.out.println("No such indices");
        }

        //Write a program to reach a specified number in minimum hops.
        //Hops can be of the nature of going one step ahead or going twice the number of current hops taken.

        public static void countHops(int a){

            int count=0;
            while(a>0){
                if (a==1){
                    break;
                }
                if(a %2 ==0){
                a=a/2;
                count++;
                }
                else {
                    a=a-1;
                    count++;
                }

            }
            System.out.println("hop count " + count);
        }

		public static void main(String args[]){
			int[] arr=new int[args.length];
			for(int i=0;i<args.length;i++){
				arr[i]=Integer.parseInt(args[i]);
			}

			equalSum(arr);
            int k=9;
            sumToK(arr, k);
            countHops(56);

		}
}


