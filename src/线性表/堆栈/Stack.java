package 线性表.堆栈;

public class Stack {

	/**
	 * 线性栈
	 */
	interface IStack{
		public void Init_Stack(int size);//初始化
		public int Empty_SeqStack();//判空
		public int Full_SeqStack();//判满
		public int push_SeqStack(int x);//入栈
		public int pop_SeqStack();//出栈
		public int top_SeqStack(SeqStack s, int x);//读栈顶
	}
	
	class SeqStack implements IStack{
		private static final int MAXSIZE= 100;
		private int top;
		private int[] data;
		public SeqStack() {
			Init_SeqStack(MAXSIZE);
		}
		@Override
		public void Init_Stack(int size) {
			data = new int[size];
			top = -1;
		}
		@Override
		public int Empty_SeqStack(){
			if (top == -1) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public int Full_SeqStack(){
			if (top == MAXSIZE - 1) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public int push_SeqStack(int x){
			if (Full_SeqStack() == 1){
				return 0;
			}
			top++ ;
			data[top] = x;
			return 1;
		}
		
		@Override
		public int pop_SeqStack(){
			if (Empty_SeqStack() == 1) {
				return 0;
			}
			return data[top--];
		}
		
		@Override
		public int top_SeqStack(SeqStack s, int x){
			if (Empty_SeqStack(s) == 1) {
				return 0;
			}
			return data[top];
		}
	}
	
	interface ILinkStack{
		public int empty_LinkStack(LinkStack top);//判空
		public LinkNode push_LinkStack(int x); //入栈
		public int pop_LinkStack(); //出栈
		public void conversion(int N, int r); //数制转换(辗转相除法)
		
		public int fact(int n);//递归实现求阶乘
	}
	/**
	 * 链栈
	 */
	class LinkStack implements ILinkStack{
		private LinkNode top;
		
		public LinkStack() {
			top = null;
		}
		
		@Override
		public int empty_LinkStack(LinkStack top){
			if (top == null) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public LinkNode push_LinkStack(int x){
			LinkNode p = new LinkNode();
			p.data = x;
			top.next = p;
			top = p;
			return top;
		}
		
		@Override
		public int pop_LinkStack(){
			LinkNode p;
			if (top == null) {
				return -1;
			}
			p = top;
			top.next = top;
			return p.data;
		}
		
		@Override
		public void conversion(int N, int r){
			int[] s = new int[10];
			int top, x;
			top = -1 ;
			while(N != 0){
				s[++top] = N % r;
				N = N / r;
			}
			while( top != -1){
				x = s[top--];
				System.out.println(x);
			}
		}
		
		@Override
		public int fact(int n){
			if (n == 0) {
				return 1;
			}
			int f = n * fact(n - 1);
			return f;
		}
	}
}
