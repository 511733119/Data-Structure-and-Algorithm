package 线性表.队列;

public class Queue {

	/**
	 * 循环队列
	 */
	interface IQueue{

		public void Init_Queue(int size); //队列初始化

		int Full_Queue(); //判队列满

		int Empty_Queue(); //判队列空

		int In_Queue(int x); //入队列

		int Out_Queue();//出队列

		int Front_Queue();//取出队头元素
		
	}
	
	/**
	 * 循环队列实现
	 */
	class Seq_Queue implements IQueue{
		private static final int MAXSIZE = 100;
		private int front;
		private int rear;
		private int num;
		private int[] data;
		
		public void Init_Queue(int size) {
			data = new int[size];
			front = size - 1;
			rear = size - 1;
			num = 0;
		}
		
		@Override
		public int Empty_Queue(){
			if (num == 0) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public int Full_Queue(){
			if (num == MAXSIZE) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public int In_Queue(int x){
			if (num == MAXSIZE) {
				System.out.println("队满");
				return -1;
			}
			rear = (rear + 1) % MAXSIZE;
			data[rear] = x;
			num++;
			return 1;
		}
		
		@Override
		public int Out_Queue(){
			if (num == 0) {
				System.out.println("队空");
				return -1;
			}
			front = (front + 1) % MAXSIZE;
			num-- ;
			return data[front];
		}
		
		@Override
		public int Front_Queue(){
			int p;
			if (num == 0) {
				System.out.println("队空");
				return -1;
			}
			p = (front + 1) % MAXSIZE;
			return data[p];
		}
	}
	
	interface ILinkQueue{
		
	}
	
	/**
	 * 链队列实现
	 */
	class LinkQueue implements ILinkQueue{

		private LinkNode front;
		private LinkNode rear;
		public LinkQueue() {
			Init_Queue();
		}
		
		@Override
		public void Init_Queue() {
			front = new LinkNode(null);
			rear = front;
		}

		@Override
		public int Empty_Queue() {
			if (front == rear) {
				System.out.println("队列空");
				return 1;
			}
			return 0;
		}

		@Override
		public int In_Queue(int x) {
			LinkQueue linkQueue = new LinkQueue();
			LinkNode p = new LinkNode(null);
			p.data = x;
			linkQueue.front.next = p;
			linkQueue.rear = p;
			return 1;
		}

		@Override
		public int Out_Queue() {
			if (Empty_Queue() == 1) {
				System.out.println("队空");
				return -1;
			}
			LinkNode p = front.next;
			front.next = p.next;
			if (front.next == null) {
				rear = front;
			}
			return p.data;
		}

		@Override
		public int Front_Queue() {
			if (Empty_Queue() == 1) {
				System.out.println("队空");
				return -1;
			}
			LinkNode p = front.next;
			return p.data;
		}
	}
}
