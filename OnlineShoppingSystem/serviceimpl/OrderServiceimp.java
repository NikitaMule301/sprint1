package com.onlineserviceimp;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.online.Dao.OrderDao;
import com.online.Util.HibernateUtil;
import com.online.entity.Order;
import com.online.service.OrderService;
public class OrderServiceimp implements OrderService{
	Scanner sc=new Scanner(System.in);
	@Override
	public Order createOrder(Order order) {

		try(Session session=HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			return order;

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
	public Order getOrder(String orderID) {
		try(Session session=HibernateUtil.getSession()) {

			Order order=session.get(Order.class, orderID);
			return order;

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
	public List<Order> getAllOrder() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<Order> query=session.createQuery("FROM Order");
			List<Order> orderList=query.list();
			return orderList;

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
	public Order updateOrder(String oId,Order order) {
		try(Session session=HibernateUtil.getSession()) {
			Order order1=session.get(Order.class, oId);
			session.beginTransaction();

			order1.setOrder_id(oId);
			order1.setLocation(order.getLocation());
			order1.setOrderDate(order.getOrderDate());
			order1.setTotal(order.getTotal());

			session.saveOrUpdate(order);
			session.getTransaction().commit();
			return order;

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
	public String deleteOrder(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Order order=session.get(Order.class, id);
			session.beginTransaction();
			System.out.println("Are you sure  you want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes"))
			{
				session.delete(order);//data will be deleted from DB
				session.getTransaction().commit();
				session.evict(order);//data will remove from session Cache
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




