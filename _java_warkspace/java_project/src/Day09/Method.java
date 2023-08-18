package Day09;

public class Method {

	public static void main(String[] args) {
		// 최대공약수, 최소송배수 메서드
		System.out.println(gcd(6, 12)); // 최대공약수

		System.out.println(lcm(10, 15)); // 최소공배수
		
		System.out.println(lcm2(10,15));
	}

	/*
	 * 두 정수를 매개변수로 받아, 최대공약수를 리턴하는 메서드 매개변수 : 두 정수(int num1, int num2) 리턴타입 : 최대공약수
	 * (int) 메서드명 : gcd
	 */
	public static int gcd(int num1, int num2) {
		// num1, num2는 이미 주어진 매개변수

		int result = 0;
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				result = i;
			}
		}
		return result;
	}

	/*
	 * 두 정수를 매개변수고 받아, 최소공배수를 리턴하는 메서드 매개변수 : 두 정수(int num1, int num2) 리턴타입 : 최소공배수
	 * (int) 메서드명 : lcn
	 */
	public static int lcm(int num1, int num2) {

		int result = 0;
		for (int i = num1;; i = i + num1) {// 10 20 30 40...

			if (i % num1 == 0 && i % num2 == 0) {
				result = i;
				break;  //return i;  : 메서드에서 return만나면 값을 반환하고 종료
			}

		} // for문 끝
		return result;
	}

	//최소공배수 규칙 : 두 수를 곱한 후 최대공약수로 나누기
	// 10 * 15 / 5(최대공약수) = 30(최소공배수)
	public static int lcm2(int num1, int num2) {
		return num1*num2/gcd(num1,num2);
	}
}
