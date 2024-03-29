package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebBindingInitializer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//add an initBinder.. to convert trim input strings
	//remove leading and trailing whitespace
	//resolve issue for our validation
	
	@InitBinder
	public void initBiner(WebDataBinder binder)
	{
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer );
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer")Customer customer,BindingResult theBindingResult)
	{
		System.out.println("Last name: |" + customer.getLastName());
		System.out.println("Binding result: "+ theBindingResult);
		
		System.out.println("\n\n\n ");
		
		if(theBindingResult.hasErrors())
		{
			return "customer-form";
		}
		else 
		{
			return "customer-confirmation";
		}
	}
}
