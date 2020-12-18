package sk.itsovy.dolinsky.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.itsovy.dolinsky.spring.entity.Customer;
import sk.itsovy.dolinsky.spring.service.CustomerService;

import java.util.List;

/**
 * @author Martin Dolinsky
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		List<Customer> customerList = customerService.getCustomers();
		model.addAttribute("customers", customerList);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {

		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
