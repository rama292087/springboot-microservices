package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.emnumpack.OrderStatus;
import com.example.demo.exceptionhandlepkg.OrderNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;



@BasePathAwareController
public class CustomOrderHateoasController implements RepresentationModelProcessor<EntityModel<Order>> {
	@Autowired
	private final OrderRepository repository;

	public CustomOrderHateoasController(OrderRepository repository) {
		super();
		this.repository = repository;
	}

	@PostMapping("/orders/{id}/pay")
	ResponseEntity<?> pay(@PathVariable Long id) throws OrderNotFoundException {
		Order order = this.repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
		if (OrderStatus.valid(order.getOrderStatus(), OrderStatus.PAID_FOR)) {
			order.setOrderStatus(OrderStatus.PAID_FOR);
			return ResponseEntity.ok(repository.save(order));
		}
		return ResponseEntity.badRequest().body(
				"Transitioning from " + order.getOrderStatus() + " to " + OrderStatus.PAID_FOR + " is not valid.");
	}

	@PostMapping("/orders/{id}/cancel")
	ResponseEntity<?> cancel(@PathVariable Long id) throws OrderNotFoundException {
		Order order = this.repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
		if (OrderStatus.valid(order.getOrderStatus(), OrderStatus.CANCELLED)) {
			order.setOrderStatus(OrderStatus.CANCELLED);
			return ResponseEntity.ok(repository.save(order));
		}
		return ResponseEntity.badRequest().body(
				"Transitioning from " + order.getOrderStatus() + " to " + OrderStatus.CANCELLED + " is not valid.");
	}

	@PostMapping("/orders/{id}/fulfill")
	ResponseEntity<?> fulfill(@PathVariable Long id) throws OrderNotFoundException {
		Order order = this.repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
		if (OrderStatus.valid(order.getOrderStatus(), OrderStatus.FULFILLED)) {
			order.setOrderStatus(OrderStatus.FULFILLED);
			return ResponseEntity.ok(repository.save(order));
		}
		return ResponseEntity.badRequest().body(
				"Transitioning from " + order.getOrderStatus() + " to " + OrderStatus.FULFILLED + " is not valid.");
	}

	@Override
	public EntityModel<Order> process(EntityModel<Order> model) {
		Links links = model.getLinks();
		List<Link> listLink = links.toList();
		if (listLink==null || listLink.isEmpty()) {
			 //just to be sure that there is at least one link in the list
			return model;
		}
		Link self = listLink.get(0);
		String href = self.getHref();
		// If PAID_FOR is valid, add a link to the `pay()` method
		 if (OrderStatus.valid(model.getContent().getOrderStatus(), OrderStatus.PAID_FOR)) {
			 model.add(Link.of(String.format("%s/%s", href,"pay"),"payment"));
		 }
		 
		// If CANCELLED is valid, add a link to the `cancel()` method
		 if (OrderStatus.valid(model.getContent().getOrderStatus(), OrderStatus.CANCELLED)) {
			 model.add(Link.of(String.format("%s/%s", href,"cancel"),"cancel"));
		 }
		 
		// If FULFILLED is valid, add a link to the `fulfill()` method
		 if (OrderStatus.valid(model.getContent().getOrderStatus(), OrderStatus.FULFILLED)) {
			model.add(Link.of(String.format("%s/%s", href,"fulfill"),"fulfill"));
		 }
		return model;
	}

}
