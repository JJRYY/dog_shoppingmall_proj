package dog_shoppingmall_proj.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dog_shoppingmall_proj.JdbcUtil;
import dog_shoppingmall_proj.dao.impl.DogDAOImpl;
import dog_shoppingmall_proj.dto.Dog;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void test01SelectDogList() {
		System.out.println("testSelectDogList");
		List<Dog> list = dao.selectDogList();
		Assert.assertNotNull(list);
		list.parallelStream().forEach(System.out::println);
		
	}

	@Test
	public void test02SelectDog() {
		System.out.println("testSelectDog");
		int id = 1;
		Dog res = dao.selectDog(id);
		Assert.assertNotNull(res);
		System.out.println(res);
	}

	@Test
	public void test03UpdateReadCount() {
		System.out.println("testUpdateReadCount");
		int id = 1;
		int res = dao.updateReadCount(id);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDog(id));
	}

	@Test
	public void test04InsertDog() {
		System.out.println("testInsertDog");
		Dog dog = new Dog(0, "삽살개", 5000, "sap.jpg", "한국", 1, 20, "눈 안 보임", 0);
		int res = dao.insertDog(dog);
		Assert.assertEquals(1, res);
		dao.selectDogList().parallelStream().forEach(System.out::println);
	}

}
