import java.util.Calendar;

class growthLQC{

	public static void main(String[] args){
	int com;
	int N;
		try{	
			com = Integer.parseInt(args[0]);
			N = Integer.parseInt(args[1]);
			if(com == 1){
				growthLQC.linear(N);
			}
			else if(com == 2){
				growthLQC.quadratic(N);
			}
			else if(com == 3){
				growthLQC.cubic(N);
			}
			else{
				System.out.println("Error in input. \nMust be \"java growthLQC [command 1,2,or 3] [iterations]\"");
			}
		}
		catch(Exception ex){
			System.out.println("Error in input. \nMust be \"java growthLQC [command 1,2,or 3] [iterations]\"");
		}	
	}
	
	public static void linear(int N){
		Calendar time =  Calendar.getInstance();
		long tima1 = time.getTimeInMillis();
		double sum = 0;
		for(int i= 0; i <=N; i++){
			sum += i;
		}
		Calendar time2 = Calendar.getInstance();
		long tima2 = time2.getTimeInMillis();
		long total = tima2 - tima1;
		System.out.println(total + " milliseconds");
	}
	
	public static void quadratic(int N){
		Calendar time =  Calendar.getInstance();
		long tima1 = time.getTimeInMillis();
		double sum = 0;
		for(int i= 0; i <=N; i++){
			for(int j = 0; j <= N; j++){
				sum += i;
			}
		}
		Calendar time2 = Calendar.getInstance();
		long tima2 = time2.getTimeInMillis();
		long total = tima2 - tima1;
		System.out.println(total + " milliseconds");
	}
	
	public static void cubic(int N){
		Calendar time =  Calendar.getInstance();
		long tima1 = time.getTimeInMillis();
		double sum = 0;
		for(int i= 0; i <=N; i++){
			for(int j = 0; j <= N; j++){
				for(int k = 0; k<=N; k++){
					sum += i;
				}
			}
		}
		Calendar time2 = Calendar.getInstance();
		long tima2 = time2.getTimeInMillis();
		long total = tima2 - tima1;
		System.out.println(total + " milliseconds");
	}

}