package dog_shoppingmall_proj.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import dog_shoppingmall_proj.JdbcUtil;
import dog_shoppingmall_proj.dao.impl.DogDAOImpl;

public class DogDAOTest {
	private static Connection con = JdbcUtil.getConnection();
	private static DogDAOImpl dao = DogDAOImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectDogList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectDog() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateReadCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertDog() {
		fail("Not yet implemented");
	}

}
