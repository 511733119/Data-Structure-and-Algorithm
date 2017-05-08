package 线性表.顺序表;

public class Sequence_List {

	/**
	 * 划分算法 P36
	 * @param L
	 * 时间复杂度（最坏O(n^2)）
	 */
	public static void part(SeqList<DataType> L){
		int i , j;
		DataType x , y;
		x = L.data[0];
		for(i = 1 ; i <= L.last ; i++){
			if (L.data[i] < x) {
				y = L.data[i];
				for(j = i - 1; j >= 0; j--){
					L.data[j + 1] = L.data[j];
					L.data[0] = y;
				}
			}
		}
	}
	
	/**
	 * 顺序表的合并
	 * @param A
	 * @param B
	 * @param C
	 * 时间复杂度(m+n)
	 */
	public static void merge(SeqList<DataType> A , SeqList<DataType> B , SeqList<DataType> C){
		
		int i , j , k;
		i=0; j=0; k=0;
		while(i <= A.last && j <= B.last){  //将A和B的当前元素较小者复制到表C
			if (A.data[i] < B.data[j]) {
				C.data[k++] = A.data[i];
			}else{
				C.data[k++] = B.data[j];
			}
		}
		while(i <= A.last){
			C.data[k++] = A.data[i++]; //将A中剩余元素复制到表C
		}
		while(j <= B.last){
			C.data[k++] = B.data[j++]; //将B中剩余元素复制到表C
		}
		C.last = k - 1;
	}
}
