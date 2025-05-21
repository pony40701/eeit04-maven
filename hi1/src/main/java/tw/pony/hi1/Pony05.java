package tw.pony.hi1;

import java.util.List;

import tw.pony.apis.BCrypt;
import tw.pony.dao.MemberDao;
import tw.pony.model.Member;

public class Pony05 {
	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("mark");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setCname("Mark");

		MemberDao dao = new MemberDao();
		// dao.save(member);
		dao.update(member);

		Member member2 = dao.getById(12);
		if (member2 != null) {
			System.out.println(member2.getAccount() + ":" + member2.getCname());
			dao.delete(member2);
		}

		Member member3 = dao.getById(5);
		if (member3 != null) {
			member3.setCname("湯尼");
			dao.update(member3);
		}
		System.out.println("---");

		List<Member> members = dao.getall();
		for (Member member4 : members) {
			System.out.printf("%d,%s : %s\n", member.getId(), member.getAccount(), member.getCname());
		}

	}
}