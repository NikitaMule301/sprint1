package com.onlineDaoimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.online.Dao.AdminDao;
import com.online.Util.HibernateUtil;
import com.online.entity.Admin;
//Implementation class for AdminDao interface
public class AdminDaoimpl implements AdminDao {
	Scanner sc=new Scanner(System.in);
	@Override
	public Admin createAdmin(Admin admin){
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(admin);
				session.getTransaction().commit();
				return admin;
				
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
		}

	@Override
	public Admin getAdmin(String adminID) {
		try(Session session=HibernateUtil.getSession()) {
			
			Admin admin=session.get(Admin.class, adminID);// Retrieve Admin by ID
				return admin;
				
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		return null;
	}
	@Override
	public List<Admin> getAllAdmin() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all admin data
			Query<Admin> query=session.createQuery("FROM Admin");
			List<Admin> adminList=query.list();
			return adminList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	@Override
	public Admin updateAdmin(String aId, Admin admin) {
		try(Session session=HibernateUtil.getSession()) {
			Admin admin1=session.get(Admin.class, aId);
				session.beginTransaction();
				
				admin1.setAdmin_id(aId);
				admin1.setName(admin.getName());
				admin1.setEmail(admin.getEmail());
				admin1.setMobileNumber(admin.getMobileNumber());
				admin1.setPassword(admin.getPassword());
				
				session.saveOrUpdate(admin1);
				session.getTransaction().commit();
				return admin1;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String deleteAdmin(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Admin admin=session.get(Admin.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(admin);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(admin);//data will remove from session Cache
					message="Object is deleted";
					
				}else
				{
					message="User wants to retain this object!!";
				}
				
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;

}

}
