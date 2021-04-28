package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shoppingmall_proj.dao.impl.DogDAOImpl;
import dog_shoppingmall_proj.ds.JndiDS;
import dog_shoppingmall_proj.dto.Cart;

public class DogCartRemoveService {
	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public DogCartRemoveService() {
		dao.setCon(con);
	}

	public void cartRemove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(int i = 0; i < kindArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if(cartList.get(j).getKind().equals(kindArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}
}
