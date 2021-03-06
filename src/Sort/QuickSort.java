package Sort;

/**
 * 快速排序
 * @author hjc
 *
 */
public class QuickSort {

	public void quickSort(int[] a, int low, int high){
		if (null == a || a.length <2) {
			return;
		}
		if (low<high) {
			int mid = partition(a, low, high);
			quickSort(a, low, mid-1);
			quickSort(a, mid+1, high);
		}
	}
	
	private int partition(int[] a, int low, int high){
		int pivot = a[low];
		while(low < high){
			while(low < high && a[high] >= pivot){
				high--;
			}
			a[low] = a[high];
			while(low < high && a[low] <= pivot){
				low++;
			}
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
}
