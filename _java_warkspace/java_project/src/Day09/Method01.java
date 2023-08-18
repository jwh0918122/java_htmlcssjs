package Day09;

public class Method01 {
	
	// 메서드 작성 위치

	public static void main(String[] args) {
		/* Method(메서드) : 기능(함수) fungtion
		 * 메서드 선언 및 구현
		 * 접근제한자 리턴타입 메서드명(매개변수){
		 * 기능구현;
		 * }
		 * - 접근제한자 : 접근할수있는 주체의 제한 범위
		 * - 리턴타입 : 반환 값 (메서드 실행 후 결과로 알려주는 값의 자료형) / void : 리턴할 것이 없다
		 * - 메서드명 : 소문자로 작성
		 * - 매개변수 : 기능을 수행하기 위해 필요한 값(외부에서 들어와야 하는 값)
		 * 
		 * - 메서드의 위치
		 * 클래스 안, 다른 메서드 밖
		 * 메서드의 순서는 아무 상관이 없음.(순서대로 실행되지 않고, 호출되어야 실행)★
		 * 
		 */
		//sum(10,20); //메서드 호출
		int a = sum(10,20);		
		System.out.println(a);
		System.out.println(sum(10,20));
		
		int b = c(10,20);
		System.out.println(b);
		System.out.println(c(10,20));
		
		System.out.println("sum1의 호출결과");
		sum1(20,30);
		// System.out.println(sum1(30,20));  : error(만든 메서드 sum1자체에 system.out println이 있기때문에)
		
	}
	//메서드 작성 위치
	// 두 정수가 주어지면 두 정수의 합을 알려주는(리턴하는) 메서드
	// 리턴타입 :  int(합계)
	// 메드면 : sum
	// 매개변수 : int num1. int num2 (두 정수)
	public static int sum(int num1, int num2) {
		//매개변수 : (자료형 변수명, 자료형 변수명)
		return num1 + num2;
	}
	// 두 정수가 주어지면 두 정수의 차를 알려주는(리턴하는) 메서드
	// 리턴 타입 : int
	// 매서드명 : c
	// 매개 변수 : int num1, int num2
	public static int c(int num1, int num2) {
		
		int c = num1 - num2;
		//Math.abc(값) :  절대치
		//return Math.abs(c);  
		
			if(num1<num2) { //마이너스가 뜨지 않도록 무조건 큰값에서 작은 값 빼기
				c=num2-num1;
			}
			return c;		
	}
	// 두 정수가 주어지면 두 정수의 합을 그냥 출력하는 메서드
	//리턴 타입 : 없음.
	//매개 변수 : 두 정수(int num1, int num2)
	//메서드명 : sum1
	public static void sum1(int num1,int num2) {	
		System.out.println(num1+num2);
	}
	
}
