package dog_shoppingmall_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog_shoppingmall_proj.dto.Dog;
import dog_shoppingmall_proj.service.DogRegistService;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DogRegistService service = new DogRegistService();
		
		//파일이 업로드될 서버 상의 물리적인 경로
		String realFolder = ""; 
		
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024; // 한 번에 업로드할 수 있는 파일의 크기
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String image = multi.getFilesystemName("image");
		Dog dog = new Dog(0,
				multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price")), 
				image, 
				multi.getParameter("nation"), 
				Integer.parseInt(multi.getParameter("height")), 
				Integer.parseInt(multi.getParameter("weight")), 
				multi.getParameter("content"), 
				0); 
		boolean isRegistSuccess = service.registDog(dog);
		
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			forward = new ActionForward("dogList.do", true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패');");
				out.println("history.back();");
				out.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return forward;
	}

}
