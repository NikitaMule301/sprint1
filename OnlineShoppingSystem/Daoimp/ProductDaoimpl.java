package com.onlineDaoimpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.online.Dao.ProductDao;
import com.online.Util.HibernateUtil;
import com.online.entity.Product;
//Implementation class for CustomerDao interface.
public class ProductDaoimpl implements ProductDao {
	Scanner sc=new Scanner(System.in);
	@Override
	public Product createProduct(Product product) {
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(product);
				session.getTransaction().commit();
				return product;
				
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
	public Product getProduct(String productID) {
		try(Session session=HibernateUtil.getSession()) {
			
			Product product=session.get(Product.class, productID);// Retrieve product by ID
				return product;
				
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
	public List<Product> getAllProduct() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all product data
			Query<Product> query=session.createQuery("FROM Product");
			List<Product> productList=query.list();
			return productList;
			
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
	public Product updateProduct(String pdId, Product product) {
		try(Session session=HibernateUtil.getSession()) {
			Product product1=session.get(Product.class, pdId);
				session.beginTransaction();
				
				product1.setProduct_id(pdId);
				product1.setProduct_name(product.getProduct_name());
				product1.setSpecification(product.getSpecification());
				product1.setCategory_name(product.getCategory_name());
				product1.setCart_id(product.getCart_id());
				product1.setQuantity(product.getQuantity());
				product1.setPrice(product.getPrice());
				product1.setDimension(product.getDimension());
				product1.setColor(product.getColor());
				
				session.saveOrUpdate(product);
				session.getTransaction().commit();
				return product;
			
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
	public String deleteProduct(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Product product=session.get(Product.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(product);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(product);//data will remove from session Cache
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



