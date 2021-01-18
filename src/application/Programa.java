package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Programa {
	public static void main(String[]args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data : ");
		System.out.print("Name : ");
		String name = sc.nextLine();
		System.out.print("Email : ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data :");
		System.out.print("Status : ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i ++) {
			System.out.println("Enter #" + i + "item data:");
			System.out.print("Product name : ");
			sc.nextLine();
			String prod = sc.nextLine();
			System.out.print("Product price : ");
			double pric = sc.nextDouble();
			System.out.print("Quantity : ");
			int quant = sc.nextInt();
			
			OrderItem item = new OrderItem(quant, pric, new Product(prod, pric));
			
			order.addItem(item);
		}
		
		System.out.println("ORDER SUMARY :");
		System.out.println("Order moment : ");
		System.out.println(order);
		
	}

}
