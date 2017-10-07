import java.util.*;

public class Arrays1{
	public static void main(String[] args)
	{
	
		int[] array1 = new int[1000];
		int[] array2 = new int[1000];
		int[] array3 = new int[1000];
		
		for (int i=0; i<1000; i++){
		int n = (int)(Math.random()*90 + 1);
			array1[i] = n;
			array2[i] = n;
			array3[i] = n;
	}
	Arrays.sort(array1);
	for (int i=0; i<1000; i++){
	//System.out.println(array1[i] + " ");
	}
	//Arrays.sort(array2, Collections.reverseOrder());
	//for (int i=0; i<1000; i++){
	//    System.out.println(array2[i] + " ");
	//}
	
	for (int i=1000; i>0; i--){
	    System.out.print(array1[i-1] + ",");
	    }
	}
}