package member.method.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import member.method.model.vo.Member;

public class MemberService {
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Scanner sc = new Scanner(System.in);
	static int memberIndex = 0; // 회원정보 검색시 list의 회원 위치를 저장함
	
	/**
	 * 메뉴 화면을 보여줌
	 * @author deokk91@gmail.com
	 */
	public void displayMenu() {
		int input = 0;
	
		do {
			System.out.println(" - 회원 관리 프로그램 - ");
			System.out.println("1. 회원 정보 검색");
			System.out.println("2. 회원 정보 등록");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 전체 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("Number : ");
			
			input = sc.nextInt();
			sc.nextLine();

			System.out.println();
			
			switch(input) {
			case 1: searchMember(); break;
			case 2: addMember(); break;
			case 3: updateMember(); break;
			case 4: removeMember(); break;
			case 5: selectAll(); break;
			case 0: System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("번호를 다시 확인해주세요.\n");
			}
			
		} while(input != 0);
			
	}

	
	
	/**
	 * 1. 회원 정보 검색
	 * 이름으로 회원 검색 후 그 회원의 전체 목록 조회
	 * @author deokk91@gmail.com
	 */
	public void searchMember() {
		
		System.out.println("\n - 회원 정보 검색 - ");
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.next();
		
		for(Map<String, Object> str : list) {
			
			if(str.get("name").equals(name)) {
				System.out.println(str);
				
				memberIndex = list.size() - 1; // 검색한 회원을 memberIndex에 저장하고, 수정, 삭제에도 사용
			}
		}
	}
	
	
	/**
	 * 2. 회원 정보 등록
	 * @author deokk91@gmail.com
	 */
	public void addMember() {
		
		System.out.println(" # 회원 정보 등록 # ");
		System.out.print("emailId : ");
		String emailId = sc.next();
		
		System.out.print("pw : ");
		String pw = sc.next();
		
		System.out.print("pw2 : ");
		String pw2 = sc.next();
		
		System.out.print("name : ");
		String name = sc.next();
		
		System.out.print("phone : ");
		int phone = sc.nextInt();
		
		if(pw.equals(pw2)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("emailId", emailId);
			map.put("pw", pw);
			map.put("name", name);
			map.put("phone", phone);
			
			list.add(map);
			
			System.out.println(name + "님 회원 등록을 축하합니다!\n");
		}
		
	}
	
	
	/**
	 * 3. 회원 정보 수정 
	 * 1번 회원 정보 검색을 이용해서 회원의 정보를 수정
	 * @author deokk91@gmail.com
	 */
	public void updateMember() {
		System.out.println(" - 회원 정보 수정 - ");
		
		System.out.println("수정을 원하시는 회원의 이름을 검색 합니다!");
		searchMember(); // 1번 회원 검색 ( 검색한 회원을 memberIndex로 List 위치 저장)
			
			System.out.print("emailId : ");
			String emailId = sc.next();
			
			System.out.print("pw : ");
			String pw = sc.next();
			
			System.out.print("pw2 : ");
			String pw2 = sc.next();
			
			System.out.print("name : ");
			String name = sc.next();
			
			System.out.print("phone : ");
			int phone = sc.nextInt();
			
			if(pw.equals(pw2)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("emailId", emailId);
				map.put("pw", pw);
				map.put("name", name);
				map.put("phone", phone);
				
				Map<String, Object> info = list.set(memberIndex, map);
				System.out.println(info.get("name") + "님의 회원 정보가 변경되었습니다.\n");
			}
			
			
		}
		
	
	
	/**
	 * 4. 회원 정보 삭제
	 * 1번 회원 검색을 이용해서 조회한 목록을 삭제
	 * @author deokk91@gmail.com
	 */
	public void removeMember() {
		System.out.println("\n - 회원 정보 삭제 - ");
		searchMember(); // 1번 회원 검색 ( 검색한 회원을 memberIndex로 List 위치 저장)
		
		System.out.println("삭제를 원하시면 비밀번호를 입력해주세요!");
		System.out.print("Password : ");
		String pass = sc.next();
		
		if(pass.equals(list.get(memberIndex).get("pw"))) {
			System.out.println();
			
			System.out.print(list.get(memberIndex).get("name") + "님의 정보를 정말 삭제 하시겠습니까? (Y / N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			list.remove(memberIndex);
			
			if(ch == 'Y') {
				System.out.println("회원 삭제 완료!");
			} else {
				System.out.println("삭제를 취소하고 돌아갑니다.");
			}
		}
	}
	
	
	/**
	 * 5. 회원 전체 조회 기능
	 * @author deokk91@gmail.com
	 */
	public void selectAll() {
		for(Map<String, Object> str : list) {
			System.out.println(str);
		}
	}
	

	
}
