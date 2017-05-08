package Sort;

/**
 * 插入排序
 * @author hjc
 *
 */
public class InsertionSort {
	
	public void insertionSort(int[] a){
		if (null == a || a.length < 2) {
			return;
		}
		for(int i = 1; i < a.length; i++){
			int temp = a[i];
			int j = i - 1;
			while(j >= 0 && temp < a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,5,2,6,5,9,4};
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.insertionSort(a);
		for(int i : a){
			System.out.println(i);
		}
	}
}
