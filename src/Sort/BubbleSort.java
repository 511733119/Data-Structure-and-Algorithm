package Sort;

/**
 * 冒泡排序
 * @author hjc
 *
 */
public class BubbleSort {

	public void bubbleSort(int[] a){
		if (null == a || a.length < 2) {
			return ;
		}
		boolean flag = true;
		for(int i = 0; i < a.length - 1 && flag ; i++){
			flag = false;
			for(int j = 0; j < a.length - 1 - i; j++){
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,5,2,6,5,9,4};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(a);
		for(int i : a){
			System.out.println(i);
		}
	}
}
