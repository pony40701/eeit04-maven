package tw.pony.hi1;

import tw.pony.dao.MemberDao;
import tw.pony.model.Member;

public class Pony05 {
	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("mark");
		member.setPasswd("123456");
		member.setCname("Mark");
		
		MemberDao dao = new MemberDao();
		//dao.save(member);
		
		Member member2 = dao.getById(8);
		if (member2 != null) {
			System.out.println(member2.getAccount());
		}
	}
}