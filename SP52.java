package cs6301.g18;

public class SP52 {
	public static void main(String args[]){
		SP52 newProject = new SP52();
		int[] test = {16,15,14,13,12,11,10,8,8,7,6,5,4,3,2,1,17,88,44,1,99,12,67};
		
		
		newProject.dqQuickSort(test);
//		System.out.println("结果");
		for(int i = 0 ; i < test.length ; i ++){
			System.out.print(test[i]+" ");
		}
	}
	pointer dualPivotPartition(int[] A, int p, int r){
		
		
		//Inspect the first and last element
		//What about A[p] and A[r] are equal?
		if(A[p] > A[r]){
			switchNum(A, p, r);
		}
		int x1 = A[p];
		int x2 = A[r];
		
		//Initialize k, j
		int k = p+1;
		int i = p+1;
		int j = r-1;
		//while loop for the middle array
		//S1: p+1 ... k-1
		//S2: k ... i-1
		//S3: j+1 ... r-1
		
		
		if(i > j){
			pointer pp = new pointer(k-1,j+1);
			return pp;
		}
		
		while(i <= j){
			
//			System.out.print("i是：" +i+" ");
//			System.out.print("j是：" +j+" ");
//			System.out.print("k是：" +k+" ");
//			System.out.print("A[i]是：" +A[i]+" ");
//			System.out.print("A[j]是：" +A[j]+" ");
//			System.out.print("x1是：" +x1+" ");
//			System.out.print("x2是：" +x2+" ");
//			
			
			if(A[i] >= x1 && A[i] <= x2){
//				System.out.println("第一循环");
				i++;
			}
			
			else if(A[i] < x1){
//				System.out.println("第二循环");
				switchNum(A, i, k);
				i++;
				k++;
			}
			else if(A[j] >  x2){
//				System.out.println("第三循环");
				j--;
			}
			else if(A[i]>x2 && A[j]<x1){
//				System.out.println("第四循环");
				circularSwap(A, k, i, j);
				k++;
				i++;
				j--;
			}
			else if(A[i]>x2 && A[j]>=x1 && A[j]<=x2){
//				System.out.println("第五循环");
				switchNum(A, i, j);
				i++;
				j--;
			}
//			for(int w = 0 ; w < A.length ; w ++){
//				System.out.print(A[w]+" ");
//			}
//			System.out.println("");
		}
		//The S2 grows naturally
		//Put x1 and x2 to the place they should be
		
		switchNum(A, k-1, p);
		switchNum(A, j+1, r);
		
//		for(int w = 0 ; w < A.length ; w ++){
//			System.out.print(A[w]+" ");
//		}
//		System.out.println("");
		//Return pointer
		pointer pp = new pointer(k-1,j+1);
		return pp;
		
	}
	
	void dqQuickSort(int[] A){
		dqQuickSort(A, 0, A.length-1);
	}
	void dqQuickSort(int[] A, int p, int r){
//		System.out.println("");
//		System.out.print("过程 "+A[p]);
//		System.out.println(" "+A[r]);
//		for(int i = 0 ; i < A.length ; i ++){
//			System.out.print(A[i]+" ");
//		}
//		System.out.println("");
		pointer newPointer = dualPivotPartition(A, p, r);
		//如果
		if(p<newPointer.small-1){
			dqQuickSort(A, p, newPointer.small-1);
//			System.out.println("左循环");
		}
		if(newPointer.big+1<r){
			dqQuickSort(A, newPointer.big+1, r);
//			System.out.println("右循环");
		}
		if(newPointer.small<newPointer.big-2){
			dqQuickSort(A, newPointer.small+1, newPointer.big-1);
//			System.out.println("中间循环");
		}
		
	}

	
	void switchNum(int[] A, int a, int b){
//		System.out.println("交换"+A[a]+"和"+A[b]);
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
		
	}
	void circularSwap(int A[], int a, int b, int c){
//		System.out.println("交换"+A[a]+"和"+A[b]+"和"+A[c]);
		int temp1 = A[a];
		int temp2 = A[b];
		A[a] = A[c];
		A[c] = temp2;
		A[b] = temp1;
		
	}
	class pointer{
		int small;
		int big;
		pointer(int a, int b){
			this.small = a;
			this.big = b;
		}
	}
}
