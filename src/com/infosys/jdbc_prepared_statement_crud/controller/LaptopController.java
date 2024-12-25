package com.infosys.jdbc_prepared_statement_crud.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.infosys.jdbc_prepared_statement_crud.dao.LaptopDao;
import com.infosys.jdbc_prepared_statement_crud.entity.Laptop;
import com.infosys.jdbc_prepared_statement_crud.service.LaptopService;

public class LaptopController {
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		LaptopDao dao= new LaptopDao();
		LaptopService service= new LaptopService();
		
		System.out.println("1.INSERT\n2.DELETE\n3.UPDATE\n4.DISPLAYALL\n5.InsertMultipleLaptops");
		
		System.out.println("Enter your choice");
		
		int choice= scanner.nextInt();
		
		switch(choice)
		{
		case 1: {
			System.out.println("enter laptop id");
			int id = scanner.nextInt();
			System.out.println("enter laptop name");
			String name = scanner.next();
			System.out.println("enter laptop color");
			String color = scanner.next();
			System.out.println("enter laptop price");
			double price = scanner.nextDouble();
			
			
			// pass mfd -> (yyyy-mm-dd)
			System.out.println("Enter laptop manufacturing date");
			String mfd= scanner.next();
			
//			LocalDate date= LocalDate.parse(mfd);
//			
//			Laptop laptop= new Laptop(id,name,color,price,date);
//			
//			dao.saveLaptopDao(laptop);
			
			Laptop laptop= service.saveLaptopService(new Laptop(id,name,color,price,LocalDate.parse(mfd)));
			
			String msg= laptop!=null? "success": "data not stored";
			
			System.out.println(msg);
			
		}
		break;
		case 2:{
			System.out.println("enter laptop id");
			int id = scanner.nextInt();
			int a=dao.deleteLaptopByIdDao(id);
			
			String msg = a!=0?"deleted":"given id not present or check your code";
			
			System.out.println(msg);
			
		}break;
		case 3:{
			
		}break;
		
		case 4:{
			List<Laptop> laptops=dao.getAllLaptopDao();
			for (Laptop laptop : laptops) {
				System.out.println(laptop);
			}
		}break;
		case 5: {
			System.out.println("how many laptops you want to add...");
			int size= scanner.nextInt();
			
			List<Laptop> laptops= new ArrayList<>();
			
			for(int i=1;i<=size;i++)
			{
				System.out.println("Enter laptop "+i);
				
				System.out.println("enter laptop id");
				int id = scanner.nextInt();
				System.out.println("enter laptop name");
				String name = scanner.next();
				System.out.println("enter laptop color");
				String color = scanner.next();
				System.out.println("enter laptop price");
				double price = scanner.nextDouble();
				
				
				// pass mfd -> (yyyy-mm-dd)
				System.out.println("Enter laptop manufacturing date");
				String mfd= scanner.next();
				
				Laptop laptop= new Laptop(id,name,color,price,LocalDate.parse(mfd));
				
				laptops.add(laptop);
				
			}
			
			List<Laptop> laptop2= dao.saveMultipleLaptopsDao(laptops);
			
			if(laptop2!= null)
			{
				System.out.println("Laptop added successfully");
				for(Laptop l : laptop2)
				{
					System.out.println(l);
				}
			}
			else
				{
					System.out.println("Failed to add laptops");
				}
		}break;	
		}
		
		
		
	}

}
