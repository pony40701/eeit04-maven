package tw.pony.hi1;

import java.util.List;

import tw.pony.dao.GiftDao;
import tw.pony.dao.MemberDao;
import tw.pony.model.Gift;
import tw.pony.model.Member;

public class Pony06 {
	public static void main(String[] args) {
		GiftDao dao = new GiftDao();
//		List<Gift> gifts = dao.getAll();
//		for (Gift gift : gifts) {
//			System.out.printf("%d,%s : %s\n",
//					gift.getId(), gift.getName(), gift.getTel());
//		}
		// SQL
//		List<Gift> gifts =  dao.getSQL("SELECT * FROM gift WHERE name LIKE '%禮盒%'");
//		for (Gift gift : gifts) {
//			System.out.printf("%d,%s : %s\n",
//					gift.getId(), gift.getName(), gift.getTel());
//		}
		List<Gift> gifts = dao.getHql("FROM Gift g WHERE g.name LIKE '%禮盒%'");
		for (Gift gift : gifts) {
			System.out.printf("%d,%s : %s\n", gift.getId(), gift.getName(), gift.getTel());
		}
	}

}
