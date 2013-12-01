//assume sorted input

class offBinarySearch{
	public static void main(String[] args){
		int[] sortedArray;
		sortedArray = new int[100];
		for(int i = 0; i<100; i++){
			sortedArray[i] = (i+1)*2;
		}
		
		int f = 0;
		int l = 99;
		int count = 0;
		
		int k = Integer.parseInt(args[0]);
		//System.out.println(k);
		int m = -1;
		boolean find = false;
		
		while(f <= l && !find){
			m = (int) Math.floor(f+(l-f)/3);
			/* Debugging stuff
			System.out.println("Element "+ sortedArray[m] + " M is " + m + ", f&l " + f + " " + l);
			try{
			Thread.sleep(1000);
			}
			catch(Exception ex){}*/
			if(sortedArray[m] > k){
				l = m-1;//move limit point to position before m
			}
			else if(sortedArray[m] < k){
				f = m+1;//move floor to position after m
			}			
			else if(sortedArray[m] == k){				
				find = true;
			}
			else{
				System.out.println("Something went wrong.");
				//reference in case of failure, but should not happen
				System.out.println("f = " + f);
				System.out.println("m = " + m);
				System.out.println("l = " + l);
			}
			
			count++;
			}
			
			
		if(find == true){
			System.out.println("Element " + k + " has been found at index " + m);
			System.out.println("Comparisons made: " + (count)); 
		}
		else{
			System.out.println("Element " + k + " has not been found after " + count + " comparisons");
		}	
	}
	
	
	

}