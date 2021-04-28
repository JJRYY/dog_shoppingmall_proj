package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.sql.SQLException;

import dog_shoppingmall_proj.dao.impl.DogDAOImpl;
import dog_shoppingmall_proj.ds.JndiDS;
import dog_shoppingmall_proj.dto.Dog;

public class DogViewService {
	private DogDAOImpl dao = DogDAOImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public DogViewService() {
		
	}

	public Dog getDogView(int id) {
		Dog dog = null;
		try {
			con.setAutoCommit(false);
			dao.setCon(con);
			
			dao.updateReadCount(id);
			dog = dao.selectDog(id);
			
			JndiDS.commit(con);
		} catch (SQLException e) {
			JndiDS.rollback(con);
			e.printStackTrace();
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dog;
	}

}
