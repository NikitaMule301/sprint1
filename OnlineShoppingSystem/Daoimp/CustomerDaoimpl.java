package com.onlineDaoimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.online.Dao.CustomerDao;
import com.online.Util.HibernateUtil;
import com.online.entity.Customer;
//Implementation class for CustomerDao interface.
public class CustomerDaoimpl implements CustomerDao {
	Scanner sc=new Scanner(System.in);
	@Override
	public Customer createCustomer(Customer customer) {
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(customer);
				session.getTransaction().commit();
				return customer;
				
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
	public Customer getCustomer(String customerID) {
		try(Session session=HibernateUtil.getSession()) {
			
			Customer customer=session.get(Customer.class, customerID);// Retrieve customer by ID
				return customer;
				
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
	public List<Customer> getAllCustomer() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all customer data
			Query<Customer> query=session.createQuery("FROM Customer");
			List<Customer> customerList=query.list();
			return customerList;
			
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
	public Customer updateCustomer(String cId, Customer customer){
		try(Session session=HibernateUtil.getSession()) {
			Customer customer1=session.get(Customer.class, cId);
				session.beginTransaction();
				// Updating Customer details
				customer1.setCustomer_id(cId);
				customer1.setName(customer.getName());
				customer1.setEmail(customer.getEmail());
				customer1.setMobileNumber(customer.getPassword());
				customer1.setAddress(customer.getAddress());
				
				session.saveOrUpdate(customer);
				session.getTransaction().commit();
				return customer;
			
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
	public String deleteCustomer(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Customer customer=session.get(Customer.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(customer);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(customer);//data will remove from session Cache
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

