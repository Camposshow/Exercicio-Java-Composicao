package entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // Criando a formação de data com hora do padrão brasileiro
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private List<OrderItem> orders = new ArrayList<>();
	private Client cliente = new Client();
	
	
	//Construtores
	public Order () {
		
	}

	public Order(LocalDateTime moment, OrderStatus status, Client cliente) {
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;
	}

	//Get e Set
	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}

	public void addItem(OrderItem order) {
		orders.add(order);
	}
	
	public void removeItem(OrderItem order) {
		orders.remove(order);
	}
	
	public Double total() {
		double soma = 0.0;
		//for para calcular o valor total, pegando da minha lista orders que possui o sub total e somando todos.
		for(OrderItem x : orders) {
			soma += x.subTotal();
		}
		return soma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment.format(fmt2));
		sb.append("\nOrder status: ");
		sb.append(status);
		sb.append("\n");
		sb.append(cliente.toString());
		sb.append("\nOrder items:\n");
		for(OrderItem x : orders) {
			sb.append(x.getProduct());
			sb.append(" ");
			sb.append(x.toString());
			sb.append("\n");
		}
		sb.append("\nTotal price: $ ");
		sb.append(total());
		return sb.toString();
	}

	
	
	
	
}
