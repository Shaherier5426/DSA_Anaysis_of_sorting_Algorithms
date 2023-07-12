import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.io.*;



public class Assign1 {
    public static void main(String[]args) {
		
    String[] arglist=errorHandle(args);

	int size =  Integer.parseInt(arglist[1]);
	Integer[] array = arrayGenrator(size,arglist[0]);

	String order;
	
	order = args[2].toLowerCase();

	if(order.equals("selection")){
	
		SelectionSort arr1 = new SelectionSort(array,arglist[0],arglist[3]);
		System.out.println();
	
		System.out.println("Time for the Selecton sort: "+arr1.getTimeElapsed());
	
	
		Integer[] arrayAfterSort = arr1.getarray();
	
		System.out.println();
		System.out.println("Input array was in "+ arr1.getsort());
		System.out.println("Array after  Sorting");
		for(int i=0;i<arrayAfterSort.length;i++){
			System.out.println(arrayAfterSort[i]);
		}
		arr1.txt();
	}


	else if(order.equals("merge")){
	MergeSort arr1 = new MergeSort(array,arglist[0],arglist[3]);
	System.out.println();

	System.out.println("Time for the merge sort: "+arr1.getTimeElapsed());


	Integer[] arrayAfterSort = arr1.getarray();

	System.out.println();
	System.out.println("Input array was in "+ arr1.getsort());
	System.out.println("Array after Sorting");
	for(int i=0;i<arrayAfterSort.length;i++){
		System.out.println(arrayAfterSort[i]);
	}
	arr1.txt();

	}
	else if(order.equals("insertion")){
		InsertionSort arr1 = new InsertionSort(array,arglist[0],arglist[3]);
		System.out.println();
	
		System.out.println("Time for the insert sort: "+arr1.getTimeElapsed());
	
	
		Integer[] arrayAfterSort = arr1.getarray();
	
		System.out.println();
		System.out.println("Input array was in "+ arr1.getsort());
		System.out.println("Array after Sorting");
		for(int i=0;i<arrayAfterSort.length;i++){
			System.out.println(arrayAfterSort[i]);
		}
		arr1.txt();
	
		}
		else if(order.equals("quick")){
			QuickSort arr1 = new QuickSort(array,arglist[0],arglist[3]);
			System.out.println();
		
			System.out.println("Time for the quick sort: "+arr1.getTimeElapsed());
		
		
			Integer[] arrayAfterSort = arr1.getarray();
		
			System.out.println();
			System.out.println("Input array was in "+ arr1.getsort());
			System.out.println("Array after Sorting");
			for(int i=0;i<arrayAfterSort.length;i++){
				System.out.println(arrayAfterSort[i]);
			}
			arr1.txt();
		
			}
		else{
			System.out.println("No Other sorting methords found");
			System.exit(1);
		}








			
	}



public static Integer[] arrayGenrator(int value,String order){
Integer array1[] = new Integer [value];
	for(int i=0;i<value;i++){
	Random rand = new Random();
	int randonNumber = rand.nextInt(value);
	array1[i]= randonNumber;
  }


if(order.equals("ascending")){
Arrays.sort(array1);
return array1;}
 

else if(order.equals("descending")) {
Arrays.sort(array1,Collections.reverseOrder());
return array1;
}
return array1;
}

	


public static  String[] errorHandle(String[] arg){
	String[] arguments = new String[4];
	if(arg.length != 4 ) {
				
		System.out.println("There must be 4 agrument only");
		System.exit(0);
	
		}
		int  size = 0;
		try { // convert args (0] to integer
		    size = Integer.parseInt(arg [1]);
		    if (size < 1) { 
		        System.out.println("\"size\" should be greater than 0!");
		        System.exit(0);}
            }
        catch (Exception e) {
        System.out.println("\"size\" cannot be converted to integer!");
        throw e;
		}
		arguments[1] = String.valueOf(size);


			String order;
	
			order = arg[0].toLowerCase();
		
		
			if( !(order.equals("random")||order.equals("ascending")||order.equals("descending"))){


				System.out.println("First agrument must be random or descending or ascending");
				System.exit(0);
			}
			arguments[0] = order;
			
			String sort;
	
	sort = arg[2].toLowerCase();

	if(!(sort.equals("selection") || sort.equals("insertion") || sort.equals("merge") || sort.equals("quick"))){
		System.out.println("Third agrument must be selection or insertion or merge or quick ");
		System.exit(0);}
		arguments[2] = order;

		arguments[3] = arg[3];




return arguments;
	




}
}

class SelectionSort {
	private long timeElapsed;
	private Integer[] array;
	private String filename;
	private String sort;
	private final String typeOfSort = "Sectection Sort";
	public SelectionSort(Integer array[],String ord,String file) {
	  int size = array.length;
       long start = System.nanoTime();
	  for (int step = 0; step < size - 1; step++) {
		int min_idx = step;
  
		for (int i = step + 1; i < size; i++) {
  
		  // To sort in descending order, change > to < in this line.
		  // Select the minimum element in each loop.
		  if (array[i] < array[min_idx]) {
			min_idx = i;
		  }
		}
  
		// put min at the correct position
		int temp = array[step];
		array[step] = array[min_idx];
		array[min_idx] = temp;


		
	  }
	  this.timeElapsed = System.nanoTime() - start;
	  this.array = array;
	  this.sort = ord;
	  this.filename = file;

		
	}
	public void txt(){
		

		try{
			FileWriter writer = new FileWriter(this.filename+".txt");
			writer.write("Time taken to "+ this.typeOfSort +":" + String.valueOf(this.timeElapsed)) ;
			writer.write("\n");
			for(int i=0;i<this.array.length;i++){
				writer.append(Integer.toString(this.array[i]));
				writer.append("\n");
			}
			writer.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	  




	public long getTimeElapsed() {
		return this.timeElapsed;
	}
	public Integer[] getarray(){
		return this.array;
	}
	public String getsort(){
		return this.sort;
	}
}













class MergeSort {
	private long timeElapsed;
	private Integer[] array;
	private String filename;
	private String sort;
	private final String typeOfSort = "Merge Sort";
	public MergeSort(Integer array[],String ord,String file) {
	  int size = array.length;
		mergeSort(array,0,size-1);
	  this.sort = ord;
	  this.filename = file;
	 

	}
	
	public void txt(){
		

		try{
			FileWriter writer = new FileWriter(this.filename+".txt");
			writer.write("Time taken to "+ this.typeOfSort +":" + String.valueOf(this.timeElapsed)) ;
			writer.write("\n");
			for(int i=0;i<this.array.length;i++){
				writer.append(Integer.toString(this.array[i]));
				writer.append("\n");
			}
			writer.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	  
	public long getTimeElapsed() {
		return this.timeElapsed;
	}
	public Integer[] getarray(){
		return this.array;
	}
	public String getsort(){
		return this.sort;

	}
	public void merge(Integer[] arr, int p, int q, int r) {
		
		// Create L = A[p..q] and M = A[q+1..r]
		int n1 = q - p + 1;
		int n2 = r - q;
	
		int L[] = new int[n1];
		int M[] = new int[n2];
	
		for (int i = 0; i < n1; i++)
		  L[i] = arr[p + i];
		for (int j = 0; j < n2; j++)
		  M[j] = arr[q + 1 + j];
	
		// Maintain current index of sub-arrays and main array
		int i, j, k;
		i = 0;
		j = 0;
		k = p;
	
		// Until we reach either end of either L or M, pick larger among
		// elements L and M and place them in the correct position at A[p..r]
		while (i < n1 && j < n2) {
		  if (L[i] <= M[j]) {
			arr[k] = L[i];
			i++;
		  } else {
			arr[k] = M[j];
			j++;
		  }
		  k++;
		}
	
		// When we run out of elements in either L or M,
		// pick up the remaining elements and put in A[p..r]
		while (i < n1) {
		  arr[k] = L[i];
		  i++;
		  k++;
		}
	
		while (j < n2) {
		  arr[k] = M[j];
		  j++;
		  k++;
		}

		this.array = arr;
	}
	
	  // Divide the array into two subarrays, sort them and merge them
	  public void mergeSort(Integer arr[], int l, int r) {
		long start = System.nanoTime();
		if (l < r) {
	
		  // m is the point where the array is divided into two subarrays
		  int m = (l + r) / 2;
	
		  mergeSort(arr, l, m);
		  mergeSort(arr, m + 1, r);
	
		  // Merge the sorted subarrays
		  merge(arr, l, m, r);
		  this.timeElapsed = System.nanoTime() - start;
		

		}
		
		
	  }
	


}
class InsertionSort {
	private long timeElapsed;
	private Integer[] array;
	private String filename;
	private String sort;
	private final String typeOfSort = "Insertion Sort";
	public InsertionSort(Integer array[],String ord,String file) {
	  int size = array.length;
       this.sort = ord;
	   this.filename = file;
	   long start = System.nanoTime();
	   for (int step = 1; step < size; step++) {
		int key = array[step];
		int j = step - 1;
  
		// Compare key with each element on the left of it until an element smaller than
		// it is found.
		// For descending order, change key<array[j] to key>array[j].
		while (j >= 0 && key < array[j]) {
		  array[j + 1] = array[j];
		  --j;
		}
  
		// Place key at after the element just smaller than it.
		array[j + 1] = key;
	
	  }
	  
		this.array = array;
		this.timeElapsed = System.nanoTime() - start;
	}

		
	
	public void txt(){
		

		try{
			FileWriter writer = new FileWriter(this.filename+".txt");
			writer.write("Time taken to "+ this.typeOfSort +":" + String.valueOf(this.timeElapsed)) ;
			writer.write("\n");
			for(int i=0;i<this.array.length;i++){
				writer.append(Integer.toString(this.array[i]));
				writer.append("\n");
			}
			writer.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	  




	public long getTimeElapsed() {
		return this.timeElapsed;
	}
	public Integer[] getarray(){
		return this.array;
	}
	public String getsort(){
		return this.sort;
	}
}


class QuickSort {
	private  long timeElapsed;
	private  Integer[] array;
	private String filename;
	private String sort;
	private final String typeOfSort = "Quick Sort";
	public  QuickSort(Integer array[],String ord,String file) {
	  int size = array.length;
       this.sort = ord;
	   this.filename = file;
	   quickSort(array, 0, size - 1);
	}

		
	
	public void txt(){
		

		try{
			FileWriter writer = new FileWriter(this.filename+".txt");
			writer.write("Time taken to "+ this.typeOfSort +":" + String.valueOf(this.timeElapsed)) ;
			writer.write("\n");
			for(int i=0;i<this.array.length;i++){
				writer.append(Integer.toString(this.array[i]));
				writer.append("\n");
			}
			writer.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	  


public   void setTimeElapsed(long time){
	this.timeElapsed = time;
}

	public long getTimeElapsed() {
		return this.timeElapsed;
	}
	public Integer[] getarray(){
		return this.array;
	}
	public String getsort(){
		return this.sort;
	}

	public  int partition(Integer array[], int low, int high) {
    
		// choose the rightmost element as pivot
		int pivot = array[high];
		
		// pointer for greater element
		int i = (low - 1);
	
		// traverse through all elements
		// compare each element with pivot
		for (int j = low; j < high; j++) {
		  if (array[j] <= pivot) {
	
			// if element smaller than pivot is found
			// swap it with the greatr element pointed by i
			i++;
	
			// swapping element at i with element at j
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		  }
	
		}
	
		// swapt the pivot element with the greater element specified by i
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
	
		// return the position from where partition is done
		return (i + 1);
	  }
	
	  public  void quickSort(Integer array[], int low, int high) {
		long start = System.nanoTime();
		if (low < high) {
	
		  // find pivot element such that
		  // elements smaller than pivot are on the left
		  // elements greater than pivot are on the right
		  
		  int pi = partition(array, low, high);
		  
		  // recursive call on the left of pivot
		  quickSort(array, low, pi-1);
	
		  // recursive call on the right of pivot
		  quickSort(array, pi + 1, high);
		}
		long timeElapsed = System.nanoTime() - start;
		this.setTimeElapsed(timeElapsed);
		this.array = array;

	  }
	






}

	






