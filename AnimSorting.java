import java.util.Random;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.*;

public class AnimSorting{

	public static void main(String[] args){
		int com;
		int[] arr = new int[200];
		int i = 200;
		Random gen = new Random();
		while( i > 0){
			arr[i-1] = gen.nextInt(500)+1;
			i--; 
		}
		System.out.println(arr[0]);
		
		
		
		//Drawing
		JFrame frame = new JFrame("Test");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		DrawRectPanel pan = new DrawRectPanel();
		frame.add(pan);
		frame.setVisible(true);
		pan.drawArray(arr);
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		
		
		com = Integer.parseInt(args[0]);
		if(com == 1){
			System.out.println("Merge");
			mergesort(arr, 0, arr.length-1, frame, pan);
		}
		else if(com == 2){
			System.out.println("Quick");
			quicksort(arr, 0, arr.length-1, frame, pan);
		}
		else if(com ==3){
			bubbleSort1(arr, frame, pan);
		}
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		System.exit(0);
		
	}

	
	public static void painting(int[] arr, JFrame frame, DrawRectPanel pan){
		pan.drawArray(arr);
		frame.validate();
		frame.repaint();
		try{
		Thread.sleep(10);}//reduces flickering, can't remember better way to draw graphics
		catch(Exception e){}
	
	
	}
	
	//Merge sort
	public static void mergesort(int[] arr, int low, int high, JFrame frame, DrawRectPanel pan){
		if(low < high){
			int middle = low + (high - low)/2;
			mergesort(arr, low, middle, frame, pan);
			mergesort(arr, middle+1, high, frame, pan);
			merge(arr, low, middle, high, frame, pan);
		}
	
	}
	
	public static void merge(int[] arr, int low, int middle, int high, JFrame frame, DrawRectPanel pan){
		int[] helper = new int[arr.length];
		for(int i = low; i<= high; i++){
			helper[i] = arr[i];
		}
		
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i <= middle && j <= high){
			if(helper[i] <= helper[j]){
				arr[k] = helper[i];
				i++;
				painting(arr, frame, pan);
			}
			else{
				arr[k] = helper[j];
				painting(arr, frame, pan);
				j++;
			}
			k++;
		}
		
		while(i <= middle){
			arr[k] = helper[i];
			painting(arr, frame, pan);
			k++;
			i++;
		}
	}
	
	
	public static int partition(int[] arr, int left, int right, JFrame frame, DrawRectPanel pan){
		int i = left;
		int j = right;
		int tmp;
		int pivot = arr[(left + right) /2];
		
		while(i <= j){
			while(arr[i] < pivot){
				i++;
			}
			while(arr[j] > pivot){
				j--;
			}
			if(i <= j){
				painting(arr, frame, pan);
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	public static void quicksort(int arr[], int left, int right, JFrame frame, DrawRectPanel pan){
		int index = partition(arr, left, right, frame, pan);
		if(left < index - 1){
			quicksort(arr, left, index - 1, frame, pan);
			painting(arr, frame, pan);
		}
		if(index < right){
			quicksort(arr, index, right, frame, pan);
			painting(arr, frame, pan);
		}
	
	
	
	
	}
	
	public static void bubbleSort1(int[] x, JFrame frame, DrawRectPanel pan) {
    int n = x.length;
    for (int pass=1; pass < n; pass++) {  // count how many times
        // This next loop becomes shorter and shorter
        for (int i=0; i < n-pass; i++) {
            if (x[i] > x[i+1]) {
                // exchange elements
                int temp = x[i];  x[i] = x[i+1];  x[i+1] = temp;
				painting(x, frame, pan);
            }
        }
    }
}
	
	
	

	
	
}

