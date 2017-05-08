package 线性表.串;

public class SeqString {
	
	class Seq_String{
		private static final int MAXSIZE = 256;
		private int curlen;
		private char[] data;
		public Seq_String() {
			data = new char[MAXSIZE];
			curlen = -1;
		}
		
		public int StrLength(Seq_String s){
			return s.curlen + 1;
		}
		
		/**
		 * 两个串的连接
		 * @param s1
		 * @param s2
		 * @param s3
		 * @return
		 */
		public int StrConcat(Seq_String s1, Seq_String s2, Seq_String s3){
			int i = 0 , j  = 0;
			int len1=  s1.StrLength(s1);
			int len2 = s2.StrLength(s2);
			if (len1 + len2 > MAXSIZE - 1) {
				return 0;
			}
			while(i < len1){
				s3.data[i] = s1.data[i];
				i++;
			}
			while(j < len2){
				s3.data[i++] = s2.data[j++];
			}
			s3.curlen = len1 + len2 - 1;
			return 1;
		}
		
		/**
		 * 求子串
		 * @param t
		 * @param s
		 * @param i
		 * @param len
		 * @return
		 */
		public int StrSub(Seq_String t, Seq_String s, int i, int len){
			int slen = StrLength(s);
			if (i < 1 || i > slen || len < 0 || len > slen - i + 1) {
				System.out.println("参数不对");
				return 0;
			}
			for(int j = 0 ; j < len; j++){
				t.data[j] = s.data[i + j - 1];
			}
			t.curlen = len;
			return 1;
		}
		
		/**
		 * 判断两个字符串是否相等
		 * @param s1
		 * @param s2
		 * @return
		 */
		public int StrComp(Seq_String s1, Seq_String s2){
			int i = 0;
			while(s1.data[i] == s2.data[i] && i < s1.curlen){
				i++;
			}
			return (s1.data[i] - s2.data[i]);
		}
	}
}
