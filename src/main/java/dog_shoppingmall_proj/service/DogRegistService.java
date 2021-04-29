package dog_shoppingmall_proj.service;

import java.sql.Connection;

import dog_shoppingmall_proj.dao.impl.DogDAOImpl;
import dog_shoppingmall_proj.ds.JndiDS;
import dog_shoppingmall_proj.dto.Dog;

public class DogRegistService {
	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public DogRegistService() {
		dao.setCon(con);
	}
	
	public boolean registDog(Dog dog) {
		boolean isRegistSuccess = false;
		int insertCount = dao.insertDog(dog);
		
		if (insertCount > 0) {
			isRegistSuccess = true;
		}		
		
		return isRegistSuccess;
	}

}
