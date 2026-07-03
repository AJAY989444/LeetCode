package ComparableComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Cars_client {

	public static void main(String[] args) {
		Cars[] ar =  new Cars[5];
		ar[0] = new Cars(200,10,"White");
		ar[1] = new Cars(1000,20,"Black");
		ar[2] = new Cars(345,3,"Yellow");
		ar[3] = new Cars(34,89,"Grey");
		ar[4] = new Cars(8907,6,"Red");
		
		Arrays.sort(ar,new Comparator<Cars>() {
			@Override
			public int compare(Cars o1, Cars o2) { //o1 is this and o2 is other
//				// speed (low to high)
//				return o1.speed - o2.speed;
				
				// speed (high to low)
				return o2.speed - o1.speed;
			}
		});
		
		Arrays.sort(ar,new Comparator<Cars>() {
			@Override
			public int compare(Cars o1, Cars o2) { //o1 is this and o2 is other

				return o2.speed - o1.speed;
			}
		});
		
		
//		Sort(ar);
		Display(ar);

	}
	
	public static void Display(Cars[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); //arr[i] is object java internally uses toString with objects hence it doesnr matter arr[i] + " " or arr[i].toString() etc
		}
	}
	
	public static <T extends Comparable<T>> void Sort(T[] arr) {
		for(int pass = 1; pass < arr.length; pass++) {
			for(int i = 0; i  < arr.length - pass; i++) {
				if(arr[i].compareTo(arr[i + 1])  > 0) {  //arr[i] goes to this keyword and arr[i + 1] goes to other(o)   // if arr[i] greater we get positive
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
	
}
