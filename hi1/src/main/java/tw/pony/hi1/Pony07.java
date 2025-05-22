package tw.pony.hi1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import tw.pony.apis.BCrypt;
import tw.pony.dao.MemberDao;
import tw.pony.model.Member;
import tw.pony.model.MemberInfo;

public class Pony07 {
	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();

		Member member = new Member();
		member.setAccount("newda");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setCname("Newda");
		// ----------------------------
		try {
			FileInputStream fin = new FileInputStream("dir1/ball1.jpg");
			byte[] da = fin.readAllBytes();
			member.setIcon(da);
		} catch (Exception e) {
			System.out.println(e);
		}
		// ----------------------------

		MemberInfo info = new MemberInfo();
		info.setBirthday("1999-02-03");
		info.setTel("456");
		info.setGender("male");

		member.setMemberInfo(info);

		memberDao.save(member);

	}
}
