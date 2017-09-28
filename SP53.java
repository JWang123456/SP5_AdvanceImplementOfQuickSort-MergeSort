package cs6301.g18;

import java.util.Arrays;

public class SP53 {
	public static void main(String args[]){
		SP53 newProject = new SP53();
		int[] test = {16,15,14,13,12,11,10,8,8,7,6,5,4,3,2,1,17,88,44,1,99,12,67};
		
		
		int[] array = newProject.Select(test, 9);

		System.out.print(array[0]+" ");
		
	}
	int[] Select(int[] A, int k){
		//initialization conditions
		if(k <= 0){
			int[] empty = {};
			return empty;
		}
		if(k > A.length){
			return A;
		}
		//call function
		Select(A, k, 0, A.length-1);
		//get part of array
		int[] array = Arrays.copyOfRange(A, A.length-k, A.length-1); 
		return array;
	}
	int Select(int[] A, int k, int p, int r){
		// use insertion sort if A is small(10)
		if(r-p<10){
			insertionSort(A);
			return A[A.length-k];
		}
		
		else{
			int q = partition(A, p, r);
			//if q = n-k, 刚好
			if(q == A.length-k){
				return A[q];
			}
			//if q < n-k,说明q在左边，不要紧，从q+1取，还是第k大ge
			else if(q < A.length-k){
				return Select(A, k, q+1, r);
			}
			//if q > n+k,q在k右边，这时候变成第 大在(p....q-1)中
			else{
				return Select(A, q-((r - p+1)-k), p, q-1);
			}
		}
	}
	void insertionSort(int [] arr){
		
        for (int i=1; i<arr.length; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
	}
	int partition(int[] A, int p, int r){
		//选i，并把它放在最后面
		int i = (p+r)/2;
		swap(A, i, r);
		//设比较值
		int x = A[r];
		//设k,只看k在后面的作用
		int k = p;
		//loop
		for(int j = p ; j < r ; j ++){
			if(A[j] < x){
				swap(A, k, j);
				k ++;
			}
		}
		swap(A, k, r);
		//返回第k个值
		return k;
	}
	void swap(int[] A, int a, int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
