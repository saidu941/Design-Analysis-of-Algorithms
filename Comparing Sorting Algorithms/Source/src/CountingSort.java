
import java.util.*;
/**
*
* @author gnch3
*/
public class CountingSort {
public static int[] sort(int[] array,int counter) {

// array to be sorted in, this array is necessary

// when we sort object datatypes, if we don't,
// we can sort directly into the input array
int[] aux = new int[array.length+1];

// find the smallest and the largest value
int min = array[0];
int max = array[0];
for (int i = 1; i < array.length; i++) {
counter+=2;
if (array[i] < min) {
min = array[i];
} else if (array[i] > max) {
counter++;
max = array[i];
}
}

// init array of frequencies
int[] counts = new int[max - min + 1];

// init the frequencies
for (int i = 0; i < array.length; i++) {
counter++;
counts[array[i] - min]++;
}

// recalculate the array - create the array of occurences
counts[0]--;
for (int i = 1; i < counts.length; i++) {

counter++;
counts[i] = counts[i] + counts[i-1];
}

/*
Sort the array right to the left
1) Look up in the array of occurences the last occurence of the given value
2) Place it into the sorted array
3) Decrement the index of the last occurence of the given value
4) Continue with the previous value of the input array (goto set1),
terminate if all values were already sorted
*/
for (int i = array.length - 1; i >= 0; i--) {
counter++;
aux[counts[array[i] - min]--] = array[i];
}
aux[1000] = counter;
return aux;
}

public static void main(String[] args) {
	int count1 = 0,count2 = 0,count3 = 0;
	
	 int arr1[]= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,14,14,14,14,14,14,14,15,15,15,15,15,15,15,15,15,16,16,16,16,16,16,16,16,16,16,16,16,17,17,17,17,17,17,17,17,17,17,17,17,18,18,18,18,18,18,18,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,19,20,20,20,20,20,21,21,21,21,21,21,21,21,21,21,21,22,22,22,22,22,22,22,22,22,22,22,23,23,23,23,23,23,23,23,23,24,24,24,24,24,24,24,24,25,25,25,25,25,25,25,25,25,25,25,26,26,26,26,26,26,26,26,26,26,27,27,27,27,27,27,28,28,28,28,28,28,28,28,29,29,29,29,29,29,29,29,29,29,30,30,30,30,30,30,30,31,31,31,31,31,31,31,31,31,31,31,32,32,32,32,32,32,32,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,34,34,34,34,34,34,34,34,34,34,34,35,35,35,35,35,35,35,35,35,35,35,35,35,35,36,36,36,36,36,36,36,36,37,37,37,37,37,37,37,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,39,39,39,39,39,39,39,39,39,39,39,39,40,40,40,40,40,40,40,40,40,41,41,41,41,41,42,42,42,42,42,42,42,42,43,43,43,43,43,43,43,43,44,44,44,44,44,44,44,44,44,44,44,44,44,44,44,44,44,45,45,45,45,45,45,45,45,45,46,46,46,46,46,46,46,46,46,47,47,47,47,47,47,47,48,48,48,48,48,48,48,49,49,49,49,49,49,49,49,49,49,49,49,49,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,52,52,52,52,52,52,52,52,52,52,52,52,53,53,53,53,53,53,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,55,55,55,55,55,55,55,55,55,55,55,55,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,57,57,57,57,57,57,57,57,57,57,57,58,58,58,58,58,58,58,58,58,58,58,58,58,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,60,60,60,60,60,60,60,60,61,61,61,61,61,61,61,61,62,62,62,62,62,62,62,62,62,62,62,63,63,63,63,63,63,63,63,63,63,63,63,64,64,64,64,64,64,64,64,65,65,65,65,65,65,65,65,65,65,65,65,65,65,66,66,66,66,66,66,66,66,66,66,66,66,67,67,67,67,67,67,67,67,67,67,67,67,68,68,68,68,68,68,68,69,69,69,69,69,69,69,69,69,69,69,69,69,69,70,70,70,70,70,70,70,70,70,70,71,71,71,71,71,71,71,71,71,71,71,71,71,72,72,72,72,72,72,72,72,72,72,72,72,72,72,73,73,73,73,73,73,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,75,75,75,75,75,75,75,75,75,75,75,75,75,75,75,76,76,76,76,76,77,77,77,77,77,77,77,77,77,77,77,77,77,78,78,78,78,78,78,78,78,78,78,78,79,79,79,79,79,79,79,79,79,79,79,79,79,79,80,80,80,80,80,80,80,80,80,80,80,81,81,81,81,81,81,81,81,81,81,81,81,81,81,82,82,82,82,82,82,82,82,82,82,82,83,83,83,83,83,83,83,83,83,83,83,83,84,84,84,84,84,84,84,84,84,84,84,84,85,85,85,85,85,85,85,85,85,85,86,86,86,86,86,86,86,86,86,86,86,86,86,86,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,89,89,89,89,89,89,89,89,89,89,89,89,90,90,90,90,90,90,90,90,90,90,90};
     int arr3[]= {19,9,1,46,55,28,47,79,50,48,46,64,54,67,41,50,73,67,83,39,1,26,49,77,48,47,45,89,54,29,87,41,14,26,65,87,1,53,13,5,55,9,12,19,68,82,86,81,33,41,11,56,34,25,27,82,37,59,64,64,45,17,44,16,8,59,74,82,69,36,74,8,80,70,59,84,70,33,22,58,45,56,12,77,56,17,9,40,64,14,43,51,64,68,15,41,12,66,44,76,75,24,68,54,60,46,87,18,57,53,28,77,12,58,37,17,6,3,80,18,68,2,87,84,53,27,48,65,15,55,19,86,74,3,22,67,19,55,24,56,21,86,29,63,69,86,21,65,4,56,86,20,19,74,15,10,24,28,49,49,41,33,76,37,63,41,20,24,49,56,14,90,17,79,24,8,17,35,80,7,60,34,53,8,84,59,16,38,53,66,41,39,55,53,85,84,67,9,9,85,36,45,6,40,73,23,79,61,56,89,6,10,84,25,8,38,11,36,57,37,15,52,69,84,69,20,25,66,68,36,78,17,43,87,74,77,35,11,69,86,85,79,52,77,2,7,88,56,54,28,47,40,74,61,50,82,84,57,61,46,41,6,39,82,83,18,47,43,62,55,74,72,20,46,23,69,80,74,39,82,42,62,9,39,18,65,85,10,64,87,3,77,22,61,16,59,1,61,62,84,64,7,79,6,52,9,16,20,9,51,2,48,85,88,19,83,59,53,83,2,17,61,61,73,9,46,75,1,14,31,52,23,61,51,54,53,12,30,4,14,77,35,58,24,42,88,66,31,34,82,33,77,13,40,80,66,69,64,48,15,14,90,78,34,31,40,54,30,32,30,81,10,30,53,70,19,4,36,28,48,71,71,25,86,34,12,62,36,24,56,18,76,57,86,42,69,41,32,83,78,54,77,3,39,25,15,81,66,75,55,37,50,15,84,30,25,41,20,84,29,48,34,6,35,69,78,58,28,49,34,53,1,78,65,16,65,72,56,20,69,5,56,43,62,47,81,62,22,54,32,55,34,33,71,50,17,27,87,40,46,83,40,53,75,79,53,86,50,43,78,60,26,3,40,46,66,70,61,83,75,76,11,34,56,60,40,33,23,67,33,22,78,82,4,87,67,30,72,47,44,55,46,2,6,51,45,68,50,6,41,35,73,40,21,34,34,75,8,71,10,79,69,59,49,36,8,22,4,42,62,47,23,80,26,43,61,51,41,64,76,42,63,64,35,51,66,26,57,45,16,29,85,37,28,55,24,53,13,9,49,76,88,23,18,11,80,26,68,77,20,33,14,72,37,51,87,17,62,59,53,40,73,41,85,5,66,72,44,89,73,17,46,37,45,12,7,32,77,68,41,28,19,65,16,73,64,61,21,24,84,37,44,74,72,76,86,62,69,19,71,60,39,35,79,66,12,28,85,19,75,38,25,15,78,45,29,48,58,11,42,12,20,62,71,52,3,50,31,76,68,4,49,72,88,10,59,53,3,62,39,36,10,49,89,62,39,13,36,86,15,76,10,19,43,82,37,17,9,64,11,40,53,72,75,34,24,3,59,66,8,1,18,55,26,73,83,88,86,6,70,76,47,41,49,78,39,4,36,49,11,28,29,71,69,61,52,22,29,84,35,87,53,32,57,47,28,27,44,6,49,14,49,85,66,17,21,55,40,18,68,18,81,27,58,69,82,16,87,34,11,76,27,34,18,74,76,15,60,61,78,29,82,45,13,29,38,23,84,46,50,37,45,71,24,85,25,30,25,89,8,31,41,46,13,82,17,36,79,41,80,62,7,87,12,34,8,89,78,28,31,78,77,62,6,68,58,35,9,21,67,4,81,9,12,88,67,17,75,18,17,7,28,76,16,2,59,46,90,75,23,25,79,8,1,32,77,22,89,45,89,1,81,89,26,87,37,45,78,42,16,80,31,43,3,34,71,31,51,53,83,65,28,28,67,81,12,51,9,33,77,84,46,17,41,63,52,84,57,67,43,1,84,28,1,22,12,44,77,1,10,84,77,77,2,11,20,64,79,13,86,52,67,49,65,71,80,20,10,12,17,8,10,54,66,46,15,60,17,69,55,81,42,51,43,44,62,43,26,32,63,54,76,38,67,77,32,3,29,78,18,55,60,35,54,27,48,76,52,46,2,85,78,53,66,38,22,64,26,1,34,82,44,43,4,42,33,2,16,29,61,49,23,28,24,70,90,48,34,36,45,16,56,75,44,34,23,74,58,59,85,16,43,86,38,80,50,43,62,73,54};
     int arr2[]= {90,90,90,90,90,90,90,90,90,89,89,89,89,89,89,89,89,89,89,89,88,88,88,88,88,88,88,88,88,88,88,88,87,87,87,87,87,87,87,87,87,87,87,87,87,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,85,85,85,85,85,85,85,85,85,85,84,84,84,84,84,84,84,84,84,84,84,84,84,83,83,83,83,83,83,83,83,83,83,83,83,83,83,82,82,82,82,82,82,81,81,81,81,81,81,80,80,80,80,80,80,80,80,79,79,79,79,79,79,79,79,79,79,79,79,78,78,78,78,78,78,78,78,78,78,78,78,77,77,77,77,77,77,76,76,76,76,76,76,76,76,76,76,76,76,76,76,75,75,75,75,75,75,75,75,75,75,75,75,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,74,73,73,73,73,73,73,73,73,72,72,72,72,72,72,72,72,72,72,72,72,72,72,71,71,71,71,71,71,71,71,71,71,71,71,71,71,71,70,70,70,70,70,70,70,70,70,70,70,70,70,69,69,69,69,69,69,69,69,69,69,69,68,68,68,68,68,68,68,68,68,68,68,68,68,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,66,66,66,66,66,66,66,66,66,66,66,66,66,65,65,65,65,65,65,65,65,65,65,65,65,65,65,64,64,64,64,64,64,64,64,64,63,63,63,63,63,63,62,62,62,62,62,62,62,62,62,62,62,62,62,62,61,61,61,61,61,61,61,61,61,60,60,60,60,60,60,60,60,60,60,59,59,59,59,59,59,59,59,59,58,58,58,58,58,58,58,58,57,57,57,57,57,57,57,57,57,57,57,57,57,56,56,56,56,56,56,56,55,55,55,55,55,55,55,55,55,55,55,55,55,54,54,54,54,54,54,54,54,54,54,54,54,54,54,54,53,53,53,53,53,53,53,53,53,53,52,52,52,52,52,52,52,52,52,52,52,52,51,51,51,51,51,51,51,51,51,51,50,50,50,50,50,50,50,50,50,50,50,50,50,50,49,49,49,49,49,49,49,49,49,49,49,48,48,48,48,48,48,48,48,47,47,47,47,47,47,47,47,47,47,47,47,47,46,46,46,46,46,46,46,46,45,45,45,45,45,45,45,45,44,44,44,44,44,44,44,44,44,44,44,44,44,43,43,43,43,43,43,43,43,43,43,43,43,43,42,42,42,42,41,41,41,41,41,41,41,41,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,39,39,39,39,39,39,39,39,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,37,37,37,37,37,37,37,37,37,37,37,37,37,37,36,36,36,36,36,36,36,36,36,36,36,36,35,35,35,35,35,35,34,34,34,34,34,34,34,34,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,32,32,32,32,32,32,32,32,32,32,31,31,31,31,31,31,31,31,31,31,31,31,31,31,31,31,31,30,30,30,30,30,30,30,30,29,29,29,29,29,29,29,29,28,28,28,28,28,28,28,28,28,28,28,28,28,28,27,27,27,27,27,27,27,27,27,27,27,27,27,27,26,26,26,26,26,26,26,26,26,26,26,26,26,25,25,25,25,25,25,25,25,24,24,24,24,24,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,23,22,22,22,22,22,22,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,19,19,19,19,19,19,19,19,19,19,19,18,18,18,18,18,18,18,18,18,18,18,18,18,18,17,17,17,17,16,16,16,16,16,16,16,16,16,16,16,15,15,15,15,15,15,15,15,15,15,15,14,14,14,14,14,14,14,14,13,13,13,13,13,13,13,12,12,12,12,12,12,12,12,12,12,12,11,11,11,11,11,11,11,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,9,9,9,9,9,9,9,9,9,9,9,9,9,8,8,8,8,8,8,8,8,8,8,8,7,7,7,7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,4,4,4,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1};
     
		int [] sorted1 = sort(arr1,count1);
		count1 = sorted1[1000];
		int [] sorted2 = sort(arr2,count2);
		count2 = sorted2[1000];
		int [] sorted3 = sort(arr3,count3);
		count3 = sorted3[1000];
	
	System.out.println("");
	System.out.println("Number of comparisons for Sorted array :"+count1);
	System.out.println("Number of comparisons for Reverse array :"+count2);
	System.out.println("Number of comparisons for Random array :"+count3);
}
}
