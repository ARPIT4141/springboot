package com.nagarro.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.dto.Tshirts;

public class CsvHelper {
	
	public void CsvHelpers() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg2.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		File SourceFolder = new File("C:\\Users\\arpit\\eclipse-workspace\\ProductSearch\\CSVFiles\\");
		for (File sourceFile : SourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			fileName = SourceFolder + "\\" + fileName;
			System.out.println(fileName);
			BufferedReader reader = null;
			String line = "";
			try {
				reader = new BufferedReader(new FileReader(fileName));
				int i = 0;
				while ((line = reader.readLine()) != null) {
					if (i == 0) {
						i++;
						continue;
					}
					String[] row = line.split("\\|");
					double price = Double.parseDouble(row[5]);
					double rating = Double.parseDouble(row[6]);

					Tshirts tshirt = new Tshirts(row[0], row[1], row[2], row[3], row[4], price, rating, row[7]);
					
					try {
						session.save(tshirt);
					} catch (Exception e) {
						System.out.println("already added");
					}
				}
				
				reader.close();
			} catch (Exception e) {
				System.out.print(" CSVtoDatabase java file error "+e);
			}

		}

		tx.commit();
		
	}
	

}
