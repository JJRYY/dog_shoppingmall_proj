package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.util.List;

import dog_shoppingmall_proj.dao.impl.DogDAOImpl;
import dog_shoppingmall_proj.ds.JndiDS;
import dog_shoppingmall_proj.dto.Dog;

public class DogListService {
	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public DogListService() {
		dao.setCon(con);
	}
	
	public List<Dog> getDogList(){
		return dao.selectDogList();
	}
}
