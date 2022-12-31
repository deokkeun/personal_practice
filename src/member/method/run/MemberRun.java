package member.method.run;

import javax.swing.event.MenuDragMouseEvent;

import member.method.model.service.MemberService;

/**
 * 실행 화면
 * @author deokk91@gmail.com
 *
 */
public class MemberRun {

	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
		memberService.displayMenu();
		
		
	}
	
	
	
	
	
}
