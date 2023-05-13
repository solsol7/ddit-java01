package chap03.sec01;

public class UnaryOperator {
	
	public static void main(String[] args) {
		// 단항연산자 : 부호(-,+), 증감(++,--), 논리부정(!)
		//signOperator();
		//incrementOperator();
		logicalNot();
	}


	public static void signOperator() {
		//부호연산자 : 음수(-), 양수(+)
		int num1=100;
		int num2=-num1;
		//1-2+3-4...-10=?
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
	}
	
	public static void incrementOperator() {
		//증감연산자 : ++, --
		int num=100;
		int res1=0;
		int res2=0;
		
//		res1=num++;//postfix 표기법
//		System.out.println("num="+num+"\nres1="+res1);
		
		System.out.println("++num="+(++num)+", num="+num);
		
		num=100;
		res2=num--;//prefix 표기법
		System.out.println("num="+num+", res2="+res2);
	}
		public static void logicalNot() {
			//논리 부정 연산자 :
			//	토글기능(toggle) : 참과 거짓이 반복되는 기능
			//		-한영변환, 삽입/편집기능 등
			boolean powerState=true;
			while (true) {
			if(powerState) {
				System.out.println("전원 스위치가  on상태");
			}
			else {
				System.out.println("전원 스위치가 off상태");
				}
			powerState=!powerState;
		}
			
	}
		
		
		
		
}

