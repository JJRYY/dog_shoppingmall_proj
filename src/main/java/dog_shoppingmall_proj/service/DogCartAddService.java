package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shoppingmall_proj.dao.impl.DogDAOImpl;
import dog_shoppingmall_proj.ds.JndiDS;
import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.dto.Dog;

public class DogCartAddService {
	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	
	public DogCartAddService() {
		dao.setCon(con);
	}

	public Dog getCartDog(int id) {
		return dao.selectDog(id);
	}
	
	public void addCart(HttpServletRequest request, Dog cartDog) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		// 지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 저장할 변수
		for(int i = 0; i < cartList.size(); i++) {
			if(cartDog.getKind().equals(cartList.get(i).getKind())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setImage(cartDog.getImage());
			cart.setKind(cartDog.getKind());
			cart.setPrice(cartDog.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
	}
}
