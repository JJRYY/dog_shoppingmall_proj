package dog_shoppingmall_proj.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.service.DogCartRemoveService;

public class DogCartRemoveAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		String[] kindArray = request.getParameterValues("remove");
		
		DogCartRemoveService service = new DogCartRemoveService();
		service.cartRemove(request, kindArray);
		
		ActionForward forward = new ActionForward("dogCartList.do", true);
		
		return forward;
	}
	
}
