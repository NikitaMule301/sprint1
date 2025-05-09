package com.online;
//Importing required libraries and classes
import java.util.List;
import java.util.Scanner;
import com.onlineserviceimp.*;
import com.online.MainOperations;
import com.online.entity.Admin;
import com.online.entity.Customer;
import com.online.entity.Order;
import com.online.entity.Payment;
import com.online.entity.Product;
//Custom exception
import com.online.exception.ResourceNotFoundException;
//Importing service interfaces
import com.online.service.AdminService;

import com.online.service.CustomerService;

import com.online.service.OrderService;

import com.online.service.PaymentService;

import com.online.service.ProductService;
/**
 * This class handles all CRUD operations for Admin, Customer, Order,
 * Payment, and Product entities using a menu-driven approach.
 */
public class AllOpertaions {
	// Service layer object creation using corresponding implementation classes
	static AdminService adminService = new AdminServiceimp();
	static CustomerService customerService = new CustomerServiceimp();
	static OrderService orderService = new OrderServiceimp();
	static PaymentService paymentService = new PaymentServiceimp();
	static ProductService productService = new ProductServiceimp();

	static Scanner sc = new Scanner(System.in); // Used for user input

	public static Admin AdminInputs() {
		sc.nextLine();
		System.out.println("Enter Admin ID");
		String Admin_id = sc.nextLine();

		System.out.println("Enter Admin Name");
		String Name = sc.nextLine();

		System.out.println("Enter email");
		String email = sc.nextLine();

		System.out.println("Enter mobile number");
		String mobileNumber = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();
		return new Admin(Admin_id, Name, email, mobileNumber, password);
	}
	// Accepts customer input from user
	public static Customer CustomerInputs() {
		sc.nextLine();
		System.out.println("Enter Customer ID");
		String customer_id = sc.nextLine();

		System.out.println("Enter Name");
		String Name = sc.nextLine();

		System.out.println("Enter email");
		String email = sc.nextLine();

		System.out.println("Enter mobile number");
		String mobileNumber = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();

		System.out.println("Enter Address");
		String Address = sc.nextLine();

		return new Customer(customer_id, Name, email, mobileNumber, password, Address);
	}
	// Accepts order input from user
	public static Order OrderInputs() {
		sc.nextLine();
		System.out.println("Enter Order ID");
		String order_id = sc.nextLine();

		System.out.println("Enter location");
		String location = sc.nextLine();

		System.out.println("Enter order date");
		String orderDate = sc.nextLine();

		System.out.println("Enter total");
		String total = sc.nextLine();

		return new Order(order_id, location, orderDate, total);
	}
	// Accepts payment input from user
	public static Payment PaymentInputs() {
		sc.nextLine();
		System.out.println("Enter Payment ID");
		String payment_id = sc.nextLine();
		System.out.println("Enter amount");
		String amount = sc.nextLine();

		System.out.println("Enter payment method");
		String payment_method = sc.nextLine();

		System.out.println("Enter payment_date");
		String payment_date = sc.nextLine();

		System.out.println("Added to cart");
		String cart = sc.nextLine();

		return new Payment(payment_id, amount, payment_method, payment_date, cart);
	}
	// Accepts product input from user
	public static Product productInputs() {
		sc.nextLine();
		System.out.println("Enter Product ID");
		String product_id = sc.nextLine();

		System.out.println("Enter Product Name");
		String product_name = sc.nextLine();

		System.out.println("Enter Product Specification");
		String specification = sc.nextLine();

		System.out.println("Enter category_name");
		String category_name = sc.nextLine();

		System.out.println("Enter cart_id");
		String cart_id = sc.nextLine();

		System.out.println("Enter quantity");
		String quantity = sc.nextLine();

		System.out.println("Enter price");
		String price = sc.nextLine();

		System.out.println("Enter dimension");
		String dimension = sc.nextLine();

		System.out.println("Enter color");
		String color = sc.nextLine();

		return new Product(product_id, product_name, specification, category_name, cart_id, quantity, price, dimension,
				color);
	}

	public static void adminOperations() {

		while (true) {
			System.out.println("Press 1.Add Admin Details\nPress 2.Retrieve All Admin Data\n"
					+ "Press 3.Update Admin Data\nPress 4.Delete Admin Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Admin admin = AdminInputs();
				Admin savedEntity = adminService.createAdmin(admin);
				System.out.println("Admin Data has been saved successfully" + savedEntity);
				break;

			case 2:
				List<Admin> admins = adminService.getAllAdmin();
				for (Admin admin1 : admins) {
					System.out.println(admin1);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Admin Id to update the infromation");
				String aId = sc.next();
				Admin a = adminService.getAdmin(aId);
				if (a != null) {
					Admin as = updatedAdminData();
					// service
					Admin updatedInfo = adminService.updateAdmin(aId, as);
					System.out.println("Admin Data has been updated Successfully" + updatedInfo);
				}

				else {
					throw new ResourceNotFoundException("Admin Id not found");
				}

				break;

			case 4:
				System.out.println("Enter Admin Id to delete the infromation");
				String id = sc.next();
				String message = adminService.deleteAdmin(id);
				System.out.println(message);
				break;
			case 5:
				MainOperations.mainOps();
			}

		}
	}
//Customer operations menu
	public static void customerOperations() {
		while (true) {
			System.out.println("Press 1. Add Customer Details\nPress 2. Retrieve All Customer Data\n"
					+ "Press 3. Update Customer Data\nPress 4. Delete Customer Data\n"
					+ "Press 5. To get back to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Customer customer = CustomerInputs();
				Customer savedEntity = customerService.createCustomer(customer);
				System.out.println("Customer Data has been saved successfully: " + savedEntity);
				break;

			case 2:
				List<Customer> customers = customerService.getAllCustomer();
				for (Customer customer1 : customers) {
					System.out.println(customer1);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Customer Id to update the information");
				String cId = sc.next();
				Customer c = customerService.getCustomer(cId);
				if (c != null) {
					Customer updatedCustomer = updatedCustomerData();
					Customer updatedInfo = customerService.updateCustomer(cId, updatedCustomer);
					System.out.println("Customer Data has been updated successfully: " + updatedInfo);
				} else {
					throw new ResourceNotFoundException("Customer Id not found");
				}
				break;

			case 4:
				System.out.println("Enter Customer Id to delete the information");
				String id = sc.next();
				String message = customerService.deleteCustomer(id);
				System.out.println(message);
				break;

			case 5:
				MainOperations.mainOps();

			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	//Order operations menu
	public static void orderOperations() {

		while (true) {
			System.out.println("Press 1. Add Order Details\nPress 2. Retrieve All Order Data\n"
					+ "Press 3. Update Order Data\nPress 4. Delete Order Data\n"
					+ "Press 5. To get back to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Order order = OrderInputs();
				Order savedEntity = orderService.createOrder(order);
				System.out.println("Order Data has been saved successfully: " + savedEntity);
				break;

			case 2:
				List<Order> orders = orderService.getAllOrder();
				for (Order order1 : orders) {
					System.out.println(order1);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Order Id to update the information");
				String oId = sc.next();
				Order o = orderService.getOrder(oId);
				if (o != null) {
					Order updatedOrder = updatedOrderData();
					Order updatedInfo = orderService.updateOrder(oId, updatedOrder);
					System.out.println("Order Data has been updated successfully: " + updatedInfo);
				} else {
					throw new ResourceNotFoundException("Order Id not found");
				}
				break;

			case 4:
				System.out.println("Enter Order Id to delete the information");
				String id = sc.next();
				String message = orderService.deleteOrder(id);
				System.out.println(message);
				break;

			case 5:
				MainOperations.mainOps();

			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	//Payment operations menu
	public static void paymentOperations() {
		while (true) {
			System.out.println("Press 1.Add Payment Details\nPress 2.Retrieve All Payment Data\n"
					+ "Press 3.Update Payment Data\nPress 4.Delete Payment Data\n"
					+ "Press 5.To get back to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Payment payment = PaymentInputs();
				Payment savedEntity = paymentService.createPayment(payment);
				System.out.println("Payment Data has been saved successfully" + savedEntity);
				break;

			case 2:
				List<Payment> payments = paymentService.getAllPayments();
				for (Payment p : payments) {
					System.out.println(p);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Payment Id to update the information");
				String pId = sc.next();
				Payment p = paymentService.getPayment(pId);
				if (p != null) {
					Payment updatedPayment = updatedPaymentData();
					Payment updatedInfo = paymentService.updatePayment(pId, updatedPayment);
					System.out.println("Payment Data has been updated Successfully" + updatedInfo);
				} else {
					throw new ResourceNotFoundException("Payment Id not found");
				}
				break;

			case 4:
				System.out.println("Enter Payment Id to delete the information");
				String id = sc.next();
				String message = paymentService.deletePayment(id);
				System.out.println(message);
				break;
			case 5:
				MainOperations.mainOps();

			default:
				System.out.println("Invalid input. Please try again.");
			}

		}
	}
	//Product operations menu
	public static void productOperations() {

		while (true) {
			System.out.println("Press 1. Add Product Details\nPress 2. Retrieve All Product Data\n"
					+ "Press 3. Update Product Data\nPress 4. Delete Product Data\n"
					+ "Press 5. To get back to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Product product = productInputs();
				Product savedEntity = productService.createProduct(product);
				System.out.println("Product Data has been saved successfully: " + savedEntity);
				break;

			case 2:
				List<Product> products = productService.getAllProduct();
				for (Product product1 : products) {
					System.out.println(product1);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Product Id to update the information");
				String pdId = sc.next();
				Product product1 = productService.getProduct(pdId);
				if (product1 != null) {
					Product updatedProduct = updatedProductData();
					Product updatedInfo = productService.updateProduct(pdId, updatedProduct);
					System.out.println("Product Data has been updated successfully: " + updatedInfo);
				} else {
					throw new ResourceNotFoundException("Product Id not found");
				}
				break;

			case 4:
				System.out.println("Enter Product Id to delete the information");
				String id = sc.next();
				String message = productService.deleteProduct(id);
				System.out.println(message);
				break;

			case 5:
				MainOperations.mainOps();

			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}

	// ... (updatedProductData, updatedCustomerData, updatedOrderData,
	// updatedCategoryData, updatedCartData, updatedPaymentData) ...

	public static Admin updatedAdminData() {
		sc.nextLine();
		System.out.println("Enter Admin ID");
		String Admin_id = sc.nextLine();

		System.out.println("Enter Admin Name");
		String Name = sc.nextLine();

		System.out.println("Enter email");
		String email = sc.nextLine();

		System.out.println("Enter mobile number");
		String mobileNumber = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();
		return new Admin(Admin_id, Name, email, mobileNumber, password);

	}

	public static Customer updatedCustomerData() {
		sc.nextLine();
		System.out.println("Enter Customer ID");
		String customer_id = sc.nextLine();

		System.out.println("Enter Name");
		String Name = sc.nextLine();

		System.out.println("Enter email");
		String email = sc.nextLine();

		System.out.println("Enter mobile number");
		String mobileNumber = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();

		System.out.println("Enter Address");
		String Address = sc.nextLine();

		return new Customer(customer_id, Name, email, mobileNumber, password, Address);
	}

	public static Order updatedOrderData() {
		sc.nextLine();
		System.out.println("Enter Order ID");
		String order_id = sc.nextLine();

		System.out.println("Enter location");
		String location = sc.nextLine();

		System.out.println("Enter order date");
		String orderDate = sc.nextLine();

		System.out.println("Enter total");
		String total = sc.nextLine();

		return new Order(order_id, location, orderDate, total);
	}

	public static Payment updatedPaymentData() {
		sc.nextLine();
		System.out.println("Enter Payment ID");
		String payment_id = sc.nextLine();
		System.out.println("Enter amount");
		String amount = sc.nextLine();

		System.out.println("Enter payment method");
		String payment_method = sc.nextLine();

		System.out.println("Enter payment_date");
		String payment_date = sc.nextLine();

		System.out.println("Added to cart");
		String cart = sc.nextLine();

		return new Payment(payment_id, amount, payment_method, payment_date, cart);
	}

	public static Product updatedProductData() {
		sc.nextLine();
		System.out.println("Enter Product ID");
		String product_id = sc.nextLine();

		System.out.println("Enter Product Name");
		String product_name = sc.nextLine();

		System.out.println("Enter Product Specification");
		String specification = sc.nextLine();

		System.out.println("Enter category_name");
		String category_name = sc.nextLine();

		System.out.println("Enter cart_id");
		String cart_id = sc.nextLine();

		System.out.println("Enter quantity");
		String quantity = sc.nextLine();

		System.out.println("Enter price");
		String price = sc.nextLine();

		System.out.println("Enter dimension");
		String dimension = sc.nextLine();

		System.out.println("Enter color");
		String color = sc.nextLine();

		return new Product(product_id, product_name, specification, category_name, cart_id, quantity, price, dimension,
				color);
	}
}
