package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		// o programa nao conhece a implementacao mas somente a interface. (injeção de dependencia sem explicitar a implementacao)
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1 seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2 seller findByDepartmentId ===");
		Department dep = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(dep);
		for (Seller obj : listSeller) {
			System.out.println(obj);
		}
	}
}
