package Day09;

import java.util.Scanner;

public class 숙제 {

	public static void main(String[] args) {
		/* 계산기 만들기
		 * ---메뉴---
		 * 1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.나머지 6.종료
		 * >> 메뉴선택 1
		 * >> 숫자1 > 입력받기 (5)
		 * >> 숫자2 > 입력받기 (3)
		 * 결과 : 5 + 3 = 8
		 * 
		 * 
		 * 더하기 메서드를 호출하여 연산 (5+3)
		 * 연산에 따른 switch 구문으로 메서드 호출
		 * 더하기, 빼기, 곱하기, 나누기, 나머지 메서드를 별도 구성
		 */
		
	/*	Scanner scan=new Scanner(System.in);
		
		int menu;		
		int num1;
		int num2;
		
		do {
			System.out.println("---menu---");
			System.out.println("1.덧셈");
			System.out.println("2.뺄셈");
			System.out.println("3.곱셈");
			System.out.println("4.나눗셈");
			System.out.println("5.나머지");
			System.out.println("6.종료");
			
			System.out.println("-----------");
			System.out.println("메뉴를 선택해주세요 : ");			
			menu=scan.nextInt();
			if(menu==6) {
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.println(">>숫자 1 : ");
			num1=scan.nextInt();
			
			System.out.println(">>숫자 2 : ");
			num2=scan.nextInt();
			
			// 실제 기능 처리구문
			switch(menu){
			case 1 : System.out.println(num1+"+"+num2+"="+add(num1,num2)); break;
			
			case 2 : System.out.println(num1+"-"+num2+"="+sub(num1,num2)); break;
			
			case 3 : System.out.println(num1+"*"+num2+"="+mul(num1,num2)); break;
			
			case 4 : System.out.println(num1+"/"+num2+"="+div(num1,num2)); break;
			
			case 5 : System.out.println(num1+"%"+num2+"="+rem(num1,num2)); break;
			
			case 6 : break;
			
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}while(menu!=6); //true면 계속 반복		
		
		scan.close();
		
		// +
	public static int add(int num1, int num2) {
		return num1+num2;
	}
	// -
	public static int sub(int num1, int num2) {	
		return num1-num2;
	}
	// /
	public static double div(int num1, int num2) {
		return num1/(double)num2;
	}
	// *
	public static int mul(int num1, int num2)	{
		return num1*num2;
	}
	// %
	public static int rem(int num1, int num2) {
		return num1%num2;
	}
	
}
				
				*/
		
// 강사님
		Scanner scan=new Scanner(System.in);
		
		int menu;		
		
		do {
			System.out.println("---menu---");
			System.out.println("1.덧셈");
			System.out.println("2.뺄셈");
			System.out.println("3.곱셈");
			System.out.println("4.나눗셈");
			System.out.println("5.나머지");
			System.out.println("6.종료");
			
			System.out.println("-----------");
			System.out.println("메뉴를 선택해주세요 : ");			
			menu=scan.nextInt();
			
			int num1=0;
			int num2=0;
			
			if(menu<=5) {
				System.out.println(">>숫자 1 : ");
				num1=scan.nextInt();
				
				System.out.println(">>숫자 2 : ");
				num2=scan.nextInt();
			}
			
			// 실제 기능 처리구문
			switch(menu){
			case 1 : sum(num1, num2); break;
			
			case 2 : sub(num1, num2); break;
			
			case 3 : mul(num1, num2); break;
			
			case 4 : div(num1, num2); break;
			
			case 5 : rem(num1, num2); break;
			
			case 6 : break;
			
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}while(menu!=6);	
		System.out.println("프로그램 종료");
		
		scan.close();
	}
	// +
	public static void sum(int num1, int num2) {
		System.out.println(num1+"+"+num2+"="+(num1+num2));
	}
	// -
	public static void sub(int num1, int num2) {	
		System.out.println(num1+"-"+num2+"="+(num1-num2));
	}
	// /
	public static void div(int num1, int num2) {
		System.out.println(num1+"/"+num2+"="+(num1/num2));
	}
	// *
	public static void mul(int num1, int num2)	{
		System.out.println(num1+"*"+num2+"="+(num1*num2));
	}
	// %
	public static void rem(int num1, int num2) {
		System.out.println(num1+"%"+num2+"="+(num1%num2));
	}
	
}
	
	
	 
	 


