package com.weshopify.platform.features.customers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

	@RequestMapping("/view-customerBoard")
	public String viewCustomerDashBoard() {
		log.info("i am inn viewCustomerDashBoard page");
		return "customer-dashboard";
	}
	
	@RequestMapping("/add-customer-view")
	public String addCustomerViewPage(Model model) {
		log.info("i am inn addCustomerViewPage page");
		model.addAttribute("customerFormBean", new CustomerBean());
		return "add-customer";
	}
	
	@RequestMapping(value = "/save-customer",method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customerFormBean") CustomerBean customerBean) {
		log.info("i am inn addCustomerViewPage page");
		log.info(customerBean.toString());
		
		if(customerBean.getIsSelfReg() != null && Boolean.valueOf(customerBean.getIsSelfReg())) {
			//Todo customer Self Registration
		}else {
			//Todo: Register the customer by the admin
		}
		return "add-customer";
	}
}
