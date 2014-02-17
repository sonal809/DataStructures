import java.util.*;


public class Arrays {

	//Q1.Find all pairs in an array for which the difference is greater than k

	//Q2. If an element in a mxn matrix is 0, its entire row and column are set to zero.

	static void setColRowZero(int arr[][]){
		for(int i=0;i<arr.length;i++){
			System.out.print(" " +arr[i][0]);
		}

	}

	//In an array find all the pair of elements that make up a triangle.
	static void triangleCount(int arr[]){

		int i,j=1,k;
		int n=arr.length-1;
		int count=0;

		for(i=0; i<n-2; i++){
			k=j+1;
			for(j=i+1; j<n-1; j++){

			while(arr[i]+arr[j]>arr[k] && k<n){
				k++;
			}

			count=count+k-j-1;
			//k=k-1;

			}
		}
		System.out.println("\n Number of triangles--->"+count);
	}

	//Find majority element

	static void findCandidate(int arr[]){
		int majIndex=1;
		int count=1;
		for(int i=0;i<arr.length-1;i++){
			if(count>=arr.length/2){
			System.out.println("majority element->"+arr[majIndex]);
			return;
			}
			if(count==0){
				count=1;
				majIndex=i;
			}

			if(arr[majIndex]==arr[majIndex-1]){
				count++;
			}
			else if(arr[majIndex] != arr[majIndex-1]){
				count--;
			}
		}

		int candidate=arr[majIndex];
		//now do a one more for loop to check if its count is n/2

	}

	// Find the number with odd occurances
	static void findOdd(int arr[]){
		int res=0;
		for(int i=0;i<arr.length;i++){
			res=res^arr[i];
		}
		System.out.println("odd number is-->" + res);
	}

	static void sumToK(int arr[], int k){
		int sum=0;
		int start=0,end=0;

		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
			if(sum<k){
				end++;
			}
			else{
				while(sum>k){
				sum=sum-arr[start];
				start++;
				}
				if(sum==k){
					end++;
					break;
				}
				end++;
			}
		}
		System.out.println("start index " + start);
		System.out.println("end index " + end);
	}

	//Find maximum subarray: KADANE ALGORITHM
	static void maxSub(int arr[]){
		int maxSum=0;
		int maxEndingHere=0;
		for(int i=0;i<arr.length;i++){
			maxEndingHere=maxEndingHere + arr[i];
			if(maxEndingHere<0){
				maxEndingHere=0;
			}

				if(maxSum <= maxEndingHere){
					maxSum=maxEndingHere;
			}


		}
		System.out.println("the maximum sum is  "+ maxSum);
	}

	//Find pivot in an array
	static void findPivot(int arr[], int low, int high){
		if(low<high){
			int mid=(low+high)/2;
			if(mid+1 !=arr.length){
			if(arr[mid]>arr[mid+1]){
			System.out.println("pivot "+ arr[mid]);
				return;
			}
			else System.out.println(arr[mid]);
			}
			if(arr[mid]<arr[low]){
				findPivot(arr,low, mid);
			}
			else{

				findPivot(arr, mid+1, high);
			}

		}

			}
			//Find median of two sorted arrays---->in O(logn)
			//Method1 :keep count while merging

	static void mergeMedian(int arr1[], int arr2[]){
		int[] mergArr=new int[arr1.length+arr2.length];

		int i=0,j=0,k=0;
		System.out.println(arr1.length);

		while(k<arr1.length+arr2.length){//Assuming both lengths are same
			if(i>=arr1.length){
				mergArr[k]=arr2[j];
				j++;
			}
			else if(j>=arr2.length){
				mergArr[k]=arr1[i];
				i++;
			}
			else{
			if(arr1[i]>=arr2[j]){
				mergArr[k]=arr2[j];
				j++;
			}
			else if(arr1[i]<arr2[j]){
				mergArr[k]=arr1[i];
				i++;
				}
			}
			k++;
		if(k>(arr1.length)){

			System.out.println("median is "+ (mergArr[k-1]+mergArr[k-2])/2);
			return;
		}
		}
	}

	//Array rotation in O(n) time and O(1) space
	//Juggling algorithm
	private static int gcd(int a, int b){
		if(b==0){
			return a;
		}
		else{
			return gcd(b, a%b);
		}
	}

	static void rotArray(int arr[], int d){
		int n=arr.length;
		int k=gcd(n,d);
		int temp;
		for(int i=0;i<k;i++){
			temp=arr[i];
			arr[i]=arr[i+d];
			arr[i+d]=arr[i+2*d];
			arr[i+2*d]=arr[i+3*d];
			arr[i+3*d]=temp;
		}
		for(int i=0;i<arr.length;i++){
			System.out.print("->"+arr[i]);
		}
	}

	//Finding the maximum difference in between two elements such that the larger element comes after the smaller one.
	//One solution: Find pairwise differences of all the elements and the find the maximum sum subarray
	static void maxDiff(int arr[]){
		int minElement=arr[0];
		int maxDiff=arr[1]-arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]-minElement>maxDiff){
				maxDiff=arr[i]-minElement;
			}
			if(arr[i]<minElement){
				minElement=arr[i];
			}
		}
		System.out.println("maxDiff is->"+maxDiff);
	}

	public static void main(String args[]){
		/*int[][] arr={{10,2,3},{11,2,5}};
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		Arrays.setColRowZero(arr);
		int [] arr1={7,8,10,16,17};
		Arrays.triangleCount(arr1);
		int [] arr2={1,5,3,2,2};
		Arrays.findOdd(arr2);
		Arrays.sumToK(arr2, 7);
		int [] arr3={-1,5,-3,-2,2};
		Arrays.maxSub(arr3);
		int [] arr4={1,2,3,4,5};
		Arrays.findPivot(arr4, 0, arr4.length);*/
		/*int[] arr5={1,2,3,5};
		int[] arr6={0,4,6,7,};
		Arrays.mergeMedian(arr5, arr6);*/
		int[] arr={4,5,9,1,5,6,8};
		//Arrays.rotArray(arr, 3);
		Arrays.maxDiff(arr);
	}





}
