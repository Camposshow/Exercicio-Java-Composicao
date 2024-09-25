package application;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Criando a formação de data do padrão brasileiro
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // Criando a formação de data com hora do padrão brasileiro
		
		System.out.println("Enter cliente data: ");
		System.out.println("Name : ");
		String name = sc.nextLine();
		System.out.println("Email : ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		String niver = sc.next();
		LocalDate aniversario = LocalDate.parse(niver, fmt1); // Colocando a String dentro de uma variavel LocalDate com a formatação criada
		
		Client cliente1 = new Client(name, email, aniversario);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.next();
		
		LocalDateTime dateOrder = LocalDateTime.now(); // Pegando o horario do atual do sistema(usuario)
		System.out.println(dateOrder.format(fmt2)); // Transformando este horario para o sistema padrão brasileiro
		
		Order order = new Order(dateOrder, OrderStatus.valueOf(status), cliente1); // Instanciando o pedido

		// instanciando os produtos e os itens do pedido e adicionando em pedido
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
				
		for(int i = 1; i <= n; i++) {
			System.out.printf("Enter #%d item data: " , i);
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice); // Instanciando Product
			OrderItem orderItem = new OrderItem(quantity, productPrice, product); // Instanciando OrderItem
			order.addItem(orderItem); // Adicionando itens a Order
		}
			System.out.println("ORDER SUMARY");
			System.out.println(order);
		
		
		   sc.close();
		}
}
