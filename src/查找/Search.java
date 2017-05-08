package 查找;

public class Search {

	/**
	 * 顺序查找
	 * @param data
	 * @param kx
	 * @return
	 */
	public int SeqSearch1(int[] data, int kx){
		int i = 0;
		int n = data.length;
		while(i < n && data[i] != kx){
			i++;
		}
		if (i >= n) {
			return -1;
		}
		return i;
	}
	
	/**
	 * 加监视哨后的顺序查找
	 * @param data
	 * @param kx
	 * @return
	 */
	public int SeqSearch2(int[] data, int kx){
		data[0] = kx;
		int i = data.length - 1;
		while(data[i] != kx){
			i--;
		}
		return i;
	}
	
	/**
	 * 有序表上的折半查找
	 * @param data
	 * @param kx
	 * @return
	 */
	public int binarySearch(int[] data,int kx){
		int mid;
		int low = 0;
		int high = data.length - 1;
		while(low <= high){
			mid = (low + high) / 2;
			if (kx == data[mid]) {
				return mid;
			}else if (kx < data[mid]) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 用递归方法实现折半查找算法
	 * @param R
	 * @param low
	 * @param high
	 * @param kx
	 * @return
	 */
	public int binSearch(int[] R, int low, int high, int kx){
		int mid;
		if (low < high) {
			return 0;
		}else{
			mid = (low + high) / 2;
			if (kx == R[mid]) {
				return  mid;
			}else if (kx > R[mid]) {
				return binSearch(R, mid + 1, high, kx);
			}else {
				return binSearch(R, low, mid - 1, kx);
			}
		}
	}
	
	/**
	 * 二叉排序树结构
	 * @author hjc
	 */
	class BiTNode{
		public DataType data;
		public BiTNode<DataType> lchild,rchild;
		public BiTNode(DataType data, BiTNode<DataType> lchild, BiTNode<DataType> rchild){
			this.data = data;
			this.lchild = lchild;
			this.rchild = rchild;
		}
	}

	/**
	 * 二叉排序树上的查找(非递归)
	 * @param t
	 * @param kx
	 * @return
	 */
	public BiTNode BST_Search(BiTNode<DataType> t, int kx){
		BiTNode p = t;
		while(p){
			if (kx == p.data) {
				return p;
			}
			if (kx < p.data) {
				p = p.lchild;
			}else {
				p = p.rchild;
			}
		}
		return null;
	}
	
	/**
	 * 二叉排序树上的查找(递归)
	 * @param t
	 * @param kx
	 * @return
	 */
	public BiTNode BST_Search2(BiTNode<DataType> t,int kx){
		if (t == null || t.data == kx) {
			return t;
		}
		if (kx < t.data) {
			BST_Search2(t.lchild,kx);
		}else {
			BST_Search2(t.rchild,kx);
		}
	}
	
	/**
	 * 构造一颗二叉排序树 
	 * @return
	 */
	public BiTNode create(){
		BiTNode t = null;
		int kx = new DataType(System.in);
		while(kx != 0){
			t = BST_InsertNode(t, kx);
			kx = new DataType(System.in);
		}
		return t;
	}
	
	/**
	 * 二叉排序树插入结点
	 * @param t
	 * @param kx
	 * @return
	 */
	public BiTNode BST_InsertNode(BiTNode<DataType> t, int kx){
		BiTNode f,p,s;
		p = t;
		while(p){
			if (kx == p.data) {
				System.out.println("kx已存在，不需插入");
				return t;
			}else {
				f = p;
				if (kx < p.data) {
					p = p.lchild;
				}else {
					p = p.rchild;
				}
			}
		}
		s = new BiTNode(kx,null,null);
		if (t== null) {
			t = s;
		}else if (kx < f.data) {
			f.lchild = s;
		}else {
			f.rchild = s;
		}
		return t;
	}
	
	
	//已知一颗二叉排序树上所有关键字中的最小值为-max，最大值为max，又知-max < x < max，编写递归算法，求该二叉排序树上的小于x且最靠近x的值，和大于x且最靠近x的值b
	public void fun(BiTNode<DataType> T,int x, int a, int b){
		if (T) {
			if (x < T.data.key) {     //当x小于根节点时，修改b，在左子树上继续查找
				b = T.data.key;
				fun(T.lchild, x, a, b);
			}else if (x > T.data.key) {  //当x大于根节点时，修改a，在右子树上继续查找
				a = T.data.key;
				fun(T.rchild, x, a, b);
			}else{	                     //当x等于根节点时，a是其左子树的最右下结点，b是其右子树的最左下结点
				if (T.lchild) {
					BiTNode p = T.lchild;
					while(p.rchild){
						p = p.rchild;
					}
					a = p.data.key;
				}
				if (T.rchild) {
					BiTNode p = T.rchild;
					while(p.lchild){
						p = p.lchild;
					}
					b = p.data.key;
				}
			}
		}
	}
}
