package 树;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Tree {

	/**
	 * 层次遍历二叉树
	 * @param bt 树的根节点
	 * 1)访问该元素所指结点
	 * 2)若该元素所指结点的左、右孩子结点非空，则将该元素所指结点的左孩子的引用和右孩子的引用顺序入队
	 */
	public void level_order(LinkBiTNode bt){
		if (bt == null) {
			return;
		}
		LinkBiTNode queue = new LinkBiTNode[MAXNODE];
		int front = -1;
		int rear = 0;
		queue[rear] = bt;
		while(front != rear){
			front++;
			System.out.println(queue[front]);
			if (queue[front].lchild) {
				rear++;
				queue[rear] = queue[front].lchild;
			}
			if (queue[front].rchild){
				rear++;
				queue[rear] = queue[front].rchild;
			}
		}
	}
	
	/**
	 * 创建一个二叉树
	 * @param bt
	 */
	public void createBiTree(LinkBiTNode bt){
		char ch;
		Scanner scanner = new Scanner(System.in);
		ch = scanner.next().charAt(0);
		if (ch == '0') {
			bt = null;
		}else{
			LinkBiTNode bt = new LinkBiTNode(ch,null,null);
			createBiTree(bt.lchild);
			createBiTree(bt.rchild);
		}
	}
	
	
	/**
	 * 在二叉树中查找值为x的数据元素
	 * @param bt
	 * @param x
	 * @return
	 */
	public LinkBTiNode search(LinkBiTNode bt, int x){
		LinkBiTNode p;
		if (bt) {
			if (bt.data == x) {
				return bt;
			}
			if (bt.lchild) {
				p = search(bt.lchild, x);
			}
			if (bt.rchild) {
				p = search(bt.rchild, x);
			}
			if(p){
				return p;
			}
		}
		return null;
	}
	
	/**
	 * 统计二叉树bt中叶子结点的个数
	 * @param bt
	 * @return
	 */
	public int countLeaf(LinkBiNode bt){
		if (bt == null) {
			return 0;
		}
		if (bt.lchild == null && bt.rchild == null) {
			return 1;
		}
		return countLeaf(bt.lchild) + countLeaf(bt.rchild);
	}
	
	/**
	 * 求树的高度
	 * @param bt
	 * @return
	 */
	public int depth(LinkBiTNode bt){
		int dep1=0,dep2=0;
		if (!bt) {
			return 0;
		}
		dep1 = depth(bt.lchild);
		dep2 = depth(bt.rchild);
		if (dep1 > dep2) {
			return dep1 + 1;
		}else {
			return dep2 + 1;
		}
	}
	
	/**
	 * 交换各结点的左右子树
	 * @param bt
	 */
	public void exchange(LinkBiTNode bt){
		LinkBiTNode p;
		if (bt) {
			exchange(bt.lchild);
			exchange(bt.rchild);
			p = bt.lchild;
			bt.lchild = bt.rchild;
			bt.rchild = p;
		}
	}
	
	/**
	 * 先序遍历
	 * @param bt
	 */
	public void preOrder(LinkBiTNode bt){
		if (bt == null) {
			return;
		}
		System.out.println(bt.data);
		preOrder(bt.lchild);
		preOrder(bt.rchild);
	}
	
	/**
	 * 中序遍历
	 * @param bt
	 */
	public void inOrder(LinkBiTNode bt){
		if (bt == null) {
			return;
		}
		inOrder(bt.lchild);
		System.out.println(bt.data);
		inOrder(bt.rchild);
	}
	
	/**
	 * 后序遍历
	 * @param bt
	 */
	public void postOrder(LinkBiTNode bt){
		if (bt == null) {
			return;
		}
		postOrder(bt.lchild);
		postOrder(bt.rchild);
		System.out.println(bt.data);
	}
}
