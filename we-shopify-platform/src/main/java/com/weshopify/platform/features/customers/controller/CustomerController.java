package com.weshopify.platform.features.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weshopify.platform.features.customers.bean.CustomerBean;
import com.weshopify.platform.features.customers.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/view-customerBoard")
	public String viewCustomerDashBoard(Model model) {
		log.info("i am inn viewCustomerDashBoard page");
		List<CustomerBean> customerList = customerService.getAllCustomers();
		model.addAttribute("customerData", customerList);
		return "customer-dashboard";
	}
	
	@RequestMapping("/add-customer-view")
	public String addCustomerViewPage(Model model) {
		log.info("i am inn addCustomerViewPage page");
		model.addAttribute("customerFormBean", new CustomerBean());
		return "add-customer";
	}
	
	@RequestMapping(value = "/save-customer",method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customerFormBean") CustomerBean customerBean, Model model) {
		log.info("i am inn addCustomerViewPage page");
		log.info(customerBean.toString());
		
		if(customerBean.getIsSelfReg() != null && Boolean.valueOf(customerBean.getIsSelfReg())) {
			customerService.saveCustomer(customerBean);
			if(customerBean != null && customerBean.getId() >0) {
				
				String isReg="true";
				model.addAttribute("regMessage", isReg);
				
				return "customer-sefReg";
				
			}
		}else {
			customerService.saveCustomer(customerBean);
			
		}
		return "customer-dashboard";
	}
	
	
}
