public class Quick2 {
 int[] partition(int arr[], int low, int high,int count)
 {
 int pivot = arr[high];
 int i = (low-1); // index of smaller element
 for (int j=low; j<high; j++)
 {
 ++count;
 // If current element is smaller than or
 // equal to pivot
 count++;
 if (arr[j] <= pivot)
 {

 i++;
 // swap arr[i] and arr[j]
 int temp = arr[i];
 arr[i] = arr[j];
 arr[j] = temp;
 }
 }
 // swap arr[i+1] and arr[high] (or pivot)
 int temp = arr[i+1];
 arr[i+1] = arr[high];
 arr[high] = temp;
 int a[] = {i+1,count};
 return a;
 }
 /* The main function that implements QuickSort()
 arr[] --> Array to be sorted,
 low --> Starting index,
 high --> Ending index */
 int sort(int arr[], int low, int high,int count)
 {
 ++count;
 if (low < high)
 {
 /* pi is partitioning index, arr[pi] is
 now at right place */
 int a[] = partition(arr, low, high,count);
 // Recursively sort elements before
 // partition and after partition
 int pi = a[0];
 count = a[1];
 count = sort(arr, low, pi-1,count);
 count = sort(arr, pi+1, high,count);
 return count;
 }
 else
 {
 return count;
 }
 }
 /* A utility function to print array of size n */
 static void printArray(int arr[])
 {
 int n = arr.length;
 for (int i=0; i<n; ++i)
 System.out.print(arr[i]+" ");
 System.out.println();
 }
 // Driver program
 public static void main(String args[])
 {
 int count1 = 0,count2 = 0,count3 = 0;
 int Asc[] = new int[1000];
 int DSC[] = new int[1000];
 int RAN[] = new int[1000];
 for(int i = 0;i<1000;i++)
 {
 Asc[i] = i;
 DSC[i] = 999-i;
 RAN[i] = (int) ((Math.random()*1000)+1);
 }
 System.out.println("Array 1 before sorting :");
 printArray(Asc);
 System.out.println("Array 2 before sorting :");
 printArray(DSC);
 System.out.println("Array 3 before sorting :");
 printArray(RAN);
 Quick2 ob = new Quick2();
 count1 = ob.sort(Asc, 0, Asc.length-1,count1);
 count2 = ob.sort(DSC, 0, DSC.length-1,count2);
 count3 = ob.sort(RAN, 0, RAN.length-1,count3);
 System.out.println("sorted array");
 printArray(Asc);
 printArray(DSC);
 printArray(RAN);
 System.out.println("Number of comparisons for first array :"+count1);
 System.out.println("Number of comparisons for second array :"+count2);
 System.out.println("Number of comparisons for third array :"+count3);
 }
}