package 영화예매;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class 예매매니저 {
	
	//예매한 정보 저장 변수
	영화 mySelectMovie;
	Date mySelectDate;
	String mySelectTime;
	ArrayList<String> mySelectSeat;
	int mySelectPeople; //인원수(아이포함)
	int mySelectChild; //아이의 수
	int mySelectPrice;
	int total=0; //총 가격
	
	public void ticketing(Scanner scan, ArrayList<MyTicket> ticket) {
		int select=0;
		
		영화리스트 list = new 영화리스트();
		list.영화리스트(); //영화 리스트에 기본 영화 추가
		
		//예매 영화 선택
		while(true) { //선택한 영화에 값이 들어가있지 않으면 계속 반복
			list.printMovie();
			System.out.println("\n예매하실 영화를 선택해주세요.");
			select=scan.nextInt();
			try { //잘못된 입력을 방지하기 위한 try catch
				mySelectMovie=list.getMovieList().get(select-1); //내가 선택한 영화
				System.out.println("<"+ mySelectMovie.getName()+"> "+"를 선택하셨습니다.");
				break;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		//날짜 선택
		while(true) {
			System.out.println("\n예매하실 날짜를 선택해주세요.");
			mySelectMovie.printDateList(); //날짜 출력
			select=scan.nextInt();
			try {
				mySelectDate=mySelectMovie.getDateList().get(select-1);
				//내가 선택한 날짜
				mySelectDate.printDate(); 
				System.out.println("을 선택하셨습니다.");
				break;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		//시간 선택
		while(true) {
			mySelectDate.printTimeList(); //시간 출력
			System.out.println("\n예매하실 시간을 선택해주세요.");
			select=scan.nextInt();
			try {
				HashMap<String, Integer> selectTnP = mySelectDate.getTime().get(select-1).getTimeNprice(); //시간과 가격맵의 주소 저장
				for(String tmp: selectTnP.keySet()) {
					mySelectTime=tmp; //선택한 시간
					mySelectPrice=selectTnP.get(tmp); //선택한 시간의 가격
				}
				mySelectDate.getTime().get(select-1).printTime(); //시간 출력
				System.out.println("을 선택하셨습니다.\n");
				break;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		//좌석 선택
		System.out.println();
		Time t=mySelectDate.getTime().get(select-1); //시간 주소 저장
		t.ticketSeat(scan); //좌석 예매
		mySelectSeat=t.getSeat(); 
		//선택한 좌석들
		t.printSeat(); //선택 좌석 출력
		mySelectPeople=t.getM().getPeople();//선택 인원
		
		//인원체크
		System.out.println("\n5세 이하(무료)의 인원수를 입력해주세요.");
		mySelectChild=scan.nextInt();
		
		//인원수 출력
		System.out.print("\n현재 선택하신 좌석 수는 ");
		Iterator<MyTicket> it = ticket.iterator();
		while(it.hasNext()) {
			MyTicket m=it.next();
			if(m.getName().equals(mySelectMovie)&&m.getDate().equals(mySelectDate)
					&&m.getTime().equals(mySelectTime)) {//만약 같은 이름, 같은 날짜, 같은 시간대의 영화가 이미 존재한다면
				System.out.printf("%d자리 입니다.",mySelectPeople+m.getPeople());
			}else { //처음 예매하는 영화라면
				System.out.printf("%d자리 입니다.",mySelectPeople);
			}
		}
		//가격 출력
		System.out.println();
		payments(mySelectPrice, mySelectPeople, mySelectChild, scan);
		
	}
	
	public void ticket(ArrayList<MyTicket> list) { //예매할 때 입력한 정보 저장
		String name=mySelectMovie.getName();
		String date=mySelectDate.getDate();
		String time=mySelectTime;
		ArrayList<String> seat=mySelectSeat;
		int price=mySelectPrice;
		int people=mySelectPeople;
		Iterator<MyTicket> it = list.iterator();
		while(it.hasNext()) {
			MyTicket m=it.next();
			if(m.getName().equals(name)&&m.getDate().equals(date)&&m.getTime().equals(time)) {//만약 같은 이름, 같은 날짜, 같은 시간대의 영화를 예매한다면
				m.setPeople(people+m.getPeople());//사람 수 추가
				int p=m.getPrice();
				m.setPrice(price+p);//가격 추가
				return;
			}
		}
		MyTicket my=new MyTicket(name, date, time, seat, price, people);
		list.add(my);
	}

	public void printTicket(ArrayList<MyTicket> list, Scanner scan) { //영화 하나의 정보 출력
		if(list.size()==0) {
			System.out.println("예매 목록이 존재하지 않습니다.");
			return;
		}
		System.out.println("--예매한 영화 목록--");
		for(int i=0; i<list.size(); i++) {
			System.out.println("영화 이름: "+list.get(i).getName());
		}
		System.out.println("세부정보를 확인하고싶은 영화의 이름을 입력해주세요.");
		String name=scan.next(); //영화 제목 입력받기
		int index=-1; //영화 index 저장
		for(int i=0; i<list.size(); i++) {
			if(name.equals(list.get(i).getName())) { 
				index=i;
				System.out.println("영화 이름: "+list.get(i).getName());
				System.out.println("날짜: "+list.get(i).getDate());
				System.out.println("시간: "+list.get(i).getTime());
				System.out.print("자리: ");
				for(String tmp: list.get(i).getSeat()) {
					System.out.print(tmp+" ");
				}
				System.out.println();
				System.out.println("인원: "+list.get(i).getPeople());
				System.out.println("가격: "+list.get(i).getPrice());
			}
		}
		if(index==-1) { //검색된 영화가 없으면
			System.out.println("해당 영화는 예매목록에 존재하지 않습니다.");
		}
	}

	public void printAllTicket(ArrayList<MyTicket> list) { //예매한 모든 정보 출력
		total=0; //출력하기 전 총가격 리셋
		if(list.size()==0) {
			System.out.println("예매 목록이 존재하지 않습니다.");
			return;
		}
		System.out.println("--예매한 영화 정보--");
		for(int i=0; i<list.size(); i++) {
			System.out.println("영화 이름: "+list.get(i).getName());
			System.out.println("날짜: "+list.get(i).getDate());
			System.out.println("시간: "+list.get(i).getTime());
			System.out.print("자리: ");
			for(String tmp: list.get(i).getSeat()) {
				System.out.print(tmp+" ");
			}
			System.out.println();
			System.out.println("인원: "+list.get(i).getPeople()+"명");
			System.out.println("가격: "+list.get(i).getPrice()+"원");
			total+=list.get(i).getPrice();
			System.out.println();
		}
		System.out.printf("총 예매가격: %d원\n\n",total);
	}
	
	public void cancelTicket(Scanner scan, ArrayList<MyTicket> list) {//예매 취소
		if(list.size()==0) {
			return;
		}
		System.out.println("예매를 취소하실 영화의 이름을 입력해주세요.");
		String name=scan.next();
		for(int i=0; i<list.size(); i++) {
			if(name.equals(list.get(i).getName())){
				list.remove(i);
				System.out.println("예매 취소를 완료했습니다.");
				return;
			}
		System.out.println("잘못된 입력입니다.");
		}
	}
	
	public void payments(int price, int people, int child, Scanner scan) { //가격 계산
		// 등급별 할인율 (VIP => 10%, GOLD => 5%, 일반Silver => 0%)
		int qty = people - child; //아이를 뺀 사람 수
		int rates = price * qty; //인원*가격
		System.out.println("멤버쉽 카드가 있으시면 제시해 주세요.");
		System.out.println("==== 할인율 ====");
		System.out.println("1.[VIP]회원 => 10%, |2.[GOLD]회원 => 5% |3. 멤버쉽카드 없음");
		System.out.println("------------------------------------------------------");
		int grade = scan.nextInt(); //<get>
		switch (grade) {
		case 1 :
			mySelectPrice=(int)(Math.round(rates-(rates*0.1)));
			System.out.println("[VIP] 고객님이 결제하실 금액은 " + mySelectPrice + "원 입니다.");
		 	break;
		case 2 :
			mySelectPrice=(int)(Math.round(rates-(rates*0.05)));
			System.out.println("[GOLD] 고객님이 결제하실 금액은 " + mySelectPrice + "원 입니다.");
			break;
		case 3 :
			mySelectPrice=(int)(Math.round(rates));
			System.out.println("고객님이 결제하실 금액은 " + mySelectPrice + "원 입니다.");
			break;
		default:System.out.println("잘못된 메뉴 입니다.");
			break;
		      }
		      
		   }
}
