package application;

import java.util.Date;
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
		List<Seller> listSellers = sellerDao.findByDepartment(dep);
		for (Seller obj : listSellers) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3 seller findAll ===");
		List<Seller> listAllSellers = sellerDao.findAll();
		for (Seller obj : listAllSellers) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4 seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n=== TEST 5 useller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed");
}
}
