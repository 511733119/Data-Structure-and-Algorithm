package 线性表.链表;

import java.util.Scanner;

import javax.swing.JPanel;

public class Link_List {

	class LinkNode{
		private int data;
		private LinkNode next;
		public LinkNode(int data, LinkNode next) {
			this.data = data;
			this.next = next;
		}
		public LinkNode(LinkNode next){
			this.next = next;
		}
	}
	
	class DLinkNode{
		private int data;
		private DLinkNode next;
		private DLinkNode prior;
		public DLinkNode(DLinkNode next, DLinkNode prior){
			this.next = next;
			this.prior = prior;
		}
	}
	
	interface IList{
		public void Init_LinkList();//链表初始化
		public LinkList create_LinkList();//在表头插入，建立线性表的链式存储
		public LinkList create_LinkList2();//在表尾插入，建立线性表的链式存储
		public int length_LinkList(LinkList linkList);//求单链表表长
		public LinkNode get_LinkNode(int i);//单链表中的查找
		public LinkNode locate_LinkNode(int x);//单链表中的查找
		public int insert_LinkNode(int i, int x);//插入
		public int delete_LinkNode(int i);//删除
		
		public void reverse(LinkList linkList);//单链表逆置
		public void del_duplicate_LinkNode(LinkList linkList);//删除单链表中重复结点
		public LinkList merge(LinkList A, LinkList B); //A，B两个单链表递增有序，将A,B归并成一个按元素值递减有序的链表C
		
		public DLinkList create_DLinkList(LinkList L);//单循环链表转换为双向循环链表
	}
	
	class LinkList implements IList{
		
		private LinkNode head;
		public LinkList() {
			//初始化
			Init_LinkList();
		}
		
		@Override
		public void Init_LinkList(){
			head = new LinkNode(null);
		}
		
		@Override
		public LinkList create_LinkList() {
			LinkList linkList = new LinkList();
			LinkNode linkNode;
			Scanner scanner = new Scanner(System.in);
			int x = scanner.nextInt();
			while(x != -1){
				linkNode = new LinkNode(null);
				linkNode.data = x;
				linkNode.next = linkList.head.next;
				x = scanner.nextInt();
			}
			return linkList;
		}

		@Override
		public LinkList create_LinkList2() {
			LinkList linkList = new LinkList();
			LinkNode linkNode , rear;
			rear = linkList.head.next;
			Scanner scanner = new Scanner(System.in);
			int x = scanner.nextInt();
			while(x != -1){
				linkNode = new LinkNode(null);
				linkNode.data = x;
			    rear.next = linkNode;
			    rear = linkNode;
				x = scanner.nextInt();
			}
			return linkList;
		}

		@Override
		public int length_LinkList(LinkList linkList) {
			LinkNode linkNode = linkList.head.next;
			int j = 0;
			while(linkNode.next != null){
				j++;
				linkNode = linkNode.next;
			}
			return j;
		}

		@Override
		public LinkNode get_LinkNode(int i) {
			LinkNode linkNode = head;
			int j = 0 ;
			while(linkNode.next != null && j < i){
				linkNode = linkNode.next;
				j++;
			}
			if (j == i) {
				return linkNode;
			}else {
				return null;
			}
		}

		@Override
		public LinkNode locate_LinkNode(int x) {
			LinkNode linkNode = head.next;
			while(linkNode != null && linkNode.data != x){
				linkNode = linkNode.next;
			}
			return linkNode;
		}

		@Override
		public int insert_LinkNode(int i, int x) {
			LinkNode p, s;
			p = get_LinkNode(i - 1);
			if (p == null) {
				System.out.println("参数错误");
				return 0;
			}else {
				s = new LinkNode(null);
				s.data = x;
				s.next = p.next;
				p.next = s;
				return 1;
			}
		}

		@Override
		public int delete_LinkNode(int i) {
			LinkNode p,s;
			p = get_LinkNode(i - 1);
			if (p == null) {
				System.out.println("第i-1个结点不存在");
				return -1;
			}else if (p.next == null) {
				System.out.println("第i个结点不存在");
				return 0;
			}else {
				s = p.next;
				p.next = s.next;
				return 1;
			}
			
		}

		@Override
		public void reverse(LinkList linkList) {
			LinkNode p,q;
			p = linkList.head.next;  //指向第一个数据结点
			linkList.head.next = null; //将原链表置为空表
			while(p != null){
				q = p;
				p = p.next;
				q.next = linkList.head.next; //将当前结点插到头结点的后面
				linkList.head.next = q;
			}
		}
	
		//时间复杂度(O(n^2))
		@Override
		public void del_duplicate_LinkNode(LinkList linkList){
			LinkNode p,q;
			p = linkList.head.next; //p指向第一个结点
			if (p == null) {
				return ;
			}
			while(p.next != null){ 
				q = p;
				while(q.next != null){  //从p的后记开始找重复结点
					if (q.next.data == p.data) {
						q.next = q.next.next; //找到重复结点，删除
					}
					q = q.next;
				}
				p = p.next; //p指向下一个，继续
			}
		}
		
		@Override
		public LinkList merge(LinkList A, LinkList B){
			LinkList C;
			LinkNode p,q,s;
			p = A.head.next;
			q = B.head.next;
			C = A;
			C.head.next = null;
			while(p != null && q != null){
				if (p.data < q.data) {
					s = p;
					p = p.next;
				}else {
					s = q;
					q = q.next;
				}
				s.next = C.head.next;
				C.head.next = s;      //从链表头部新加入元素
			}
			//如果p没有数据了，把q的数据复制给p，方便后面统一操作
			if (p == null) {
				p = q;
			}
			//将剩余元素逐一放进表中
			while(p != null){
				s = p;
				p = p.next;
				s.next = C.head.next;
				C.head.next = s;
			}
			return C;
		}
	}
	
	@Override
	public DLinkList create_DLinkList(LinkList L){
		DLinkList H = new DLinkList();
		DLinkNode rear,s ;
		LinkNode p;
		rear = H.head;
		p = L.head.next;
		while(p != null){
			s = new DLinkNode(null);
			s.data = p.data;
			s.next = rear.next;
			s.prior = rear;
			rear.next = s;
			H.head.prior = s;
			rear = s;
			p = p.next;
		}
		return H;
	}
	
}
