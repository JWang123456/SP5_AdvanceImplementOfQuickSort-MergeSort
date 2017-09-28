package cs6301.g18;

public class SP51 {
	public static void main(String args[]){
		SP51 newProject = new SP51();
		int[] test = {1,2,4,6,7,5,4};
		newProject.quickSortForPartition1(test);
		for(int i = 0 ; i < test.length ; i ++){
			System.out.print(test[i]);
		}
		System.out.println("");
		newProject.quickSortForPartition2(test);
		for(int i = 0 ; i < test.length ; i ++){
			System.out.print(test[i]);
		}
		
		
	}
	int partition(int[] A, int p, int r){
		//initialize an temp valve to be used in switch
		int temp = 0;
		//select pivot A[i] = x from A
		int i = (p+r)/2;
		int x = A[i];
		//switch i and r 
		A[i] = A[r];
		A[r] = x;
		//set i to -1;
		i = p-1;
		//for loop from p to r-1
		for(int j = p; j <= r-1 ; j ++){
			
			if(A[j] < x){
				i += 1;
				//switch A[i] and A[j]
				temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
		}
		//switch pivot element back to the position it should be
		temp = A[r];
		A[r] = A[i+1];
		A[i+1] = temp;
		return i+1;
	}
	void quickSortForPartition1(int[] A){
		
		quickSortForPartition1(A, 0, (A.length-1));
	}
	void quickSortForPartition1(int[] A, int p, int r){
		if(p < r){
			
			int q = partition(A, p, r);
			quickSortForPartition1(A, p, q-1);
			quickSortForPartition1(A, q+1, r);
		}
	}
	
/*---------The following part is partition2---------------*/	
	
	int[] partition2(int[] A, int p, int r){
		//Set return int[]
		int[] result = new int[2];
		//Set pivot
		int x = A[(p+r)/2];
		//Set i and j to p-1 and j+1
		int i = p-1;
		int j = r+1;
		//do ... while
		do{
			i += 1;
		}while(A[i] < x);
		do{
			j -= 1;
		}while(A[j] > x);
		//judge if i > j, then return 
		if(i > j){
			result[0] = i;
			result[1] = j;
			return result;
		}
		//switch i and j
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		
		//return the position where haven't been sorted
		i += 1;
		j += 1;
		result[0] = i;
		result[1] = j;
		return result;
		
	}
	void quickSortForPartition2(int[] A){
		quickSortForPartition2(A, 0, A.length-1);
	}
	void quickSortForPartition2(int[] A, int p, int r){
		if(p < r){
		int[] point = partition2(A, p, r);
		quickSortForPartition2(A, point[0], point[1]);	
		}
	} 
}
