package member.method.model.vo;

import java.util.Objects;

/**
 * 회원 인스턴스 생성
 * @author deokk91@gmail.com
 *
 */
public class Member {
	
	private String emailId;
	private String pw;
	private String pw2;
	private String name;
	private int phone;

	public Member() {}

	public Member(String emailId, String pw, String pw2, String name, int phone) {
		this.emailId = emailId;
		this.pw = pw;
		this.pw2 = pw2;
		this.name = name;
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [emailId=" + emailId + ", name=" + name + ", phone=" + phone
				+ "]";
	}
	

}
