
import java.util.*;
/**
*
* @author gnch3
*/
public class c2 {
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
	int Asc[] = new int[1000];
	int DSC[] = new int[1000];
	int RAN[] = new int[1000];
	for(int i = 0;i<1000;i++)
	{
		Asc[i] = i;
		DSC[i] = 999-i;
		
		RAN[i] = (int) ((Math.random()*1000)+1);
	}
		int [] sorted1 = sort(Asc,count1);
		count1 = sorted1[1000];
		int [] sorted2 = sort(DSC,count2);
		count2 = sorted2[1000];
		int [] sorted3 = sort(RAN,count3);
		count3 = sorted3[1000];
	for(int i = 0;i<999;i++){
	}
	System.out.print("");
	for(int i = 0;i<999;i++){
	}
	System.out.print("");
	for(int i = 0;i<999;i++){
	}
	System.out.println("");
	System.out.println("Number of comparisons for Sorted array :"+count1);
	System.out.println("Number of comparisons for Reverse array :"+count2);
	System.out.println("Number of comparisons for Random array :"+count3);
}
}
