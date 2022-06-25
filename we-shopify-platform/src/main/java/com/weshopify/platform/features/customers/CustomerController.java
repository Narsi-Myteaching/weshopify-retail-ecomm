package com.weshopify.platform.features.customers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String addCustomerViewPage() {
		log.info("i am inn addCustomerViewPage page");
		return "add-customer";
	}
}
