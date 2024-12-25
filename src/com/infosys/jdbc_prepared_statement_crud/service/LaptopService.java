package com.infosys.jdbc_prepared_statement_crud.service;

import com.infosys.jdbc_prepared_statement_crud.dao.LaptopDao;
import com.infosys.jdbc_prepared_statement_crud.entity.Laptop;

public class LaptopService {
	
	LaptopDao dao= new LaptopDao();
	
	public Laptop saveLaptopService(Laptop laptop) {
		
		String lname= laptop.getName();
		double price= laptop.getPrice();
		
		if(lname.length() <= 5 && (price>=30000 && price<=50000)) {
			Laptop laptop1= dao.saveLaptopDao(laptop);
			return laptop1;
			
		}
		else {
			System.out.println("laptopname length should be 5 or less and price should be between 30000 to 40000");
			return null;
		}
	}

}
