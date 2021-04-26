package dog_shoppingmall_proj.dao.impl;

import java.sql.Connection;
import java.util.List;

import dog_shoppingmall_proj.dao.DogDAO;
import dog_shoppingmall_proj.dto.Dog;

public class DogDAOImpl implements DogDAO {
	private static final DogDAOImpl instance = new DogDAOImpl();
	private Connection con;
	
	public static DogDAOImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	private DogDAOImpl() {
		
	}

	@Override
	public List<Dog> selectDogList() {
		return null;
	}

	@Override
	public Dog selectDog(int id) {
		return null;
	}

	@Override
	public int updateReadCount(int id) {
		return 0;
	}

	@Override
	public int insertDog(Dog dog) {
		return 0;
	}

}
