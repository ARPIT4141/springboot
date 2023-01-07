package com.nagarro.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

public class TshirtsDao {

	private Configuration con;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;


	public List searchData(String colour, String size,String gender, String pref) {
		
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		Query query=session
				.createQuery("from Tshirts where colour=:colour and gender=:gender and size=:size order by " + pref);
		query.setParameter("colour", colour);
		query.setParameter("size",size);
		query.setParameter("gender",gender);
		System.out.println(pref + " " + query);
		List list = query.list();
		
		return list;
	}
	


}
