package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//Load Employee Data
	private List<Employee> theEmployee;
	 @PostConstruct
	 private void loadData() {
		 Employee emp1=new Employee(1,"Satya","Dev","Satya@gmail.com");
		 Employee emp2=new Employee(2,"Gana","Gana","Gana@gmail.com");
		 Employee emp3=new Employee(3,"Bhagi","Saladi","Bhagi@gmail.com");
		 Employee emp4=new Employee(4,"Dhana","Dhana","Dhana@gmail.com");
		 Employee emp5=new Employee(5,"Pavan","Pavan","Pavan@gmail.com");
		 Employee emp6=new Employee(6,"Sesh","Sesh","Sesh@gmail.com");
		 
		 theEmployee=new ArrayList<Employee>();
		 theEmployee.add(emp1);
		 theEmployee.add(emp2);
		 theEmployee.add(emp3);
		 theEmployee.add(emp4);
		 theEmployee.add(emp5);
		 theEmployee.add(emp6);
	 }
	 
	 //Add Mapping for the "/list"
	 
	 @GetMapping("/list")
	 public String listEmployes(Model theModel) {
		 //Add the employee list to Spring Model
		 theModel.addAttribute("employees",theEmployee);
		 return "list-employees";
	 }
	 
	 @GetMapping("/covidApi")
	 public String covidData(Model theModel) {
		 //Add the employee list to Spring Model
		 
		 RestTemplate template=new RestTemplate();
		    String covidData=  template.getForObject("https://api.covid19india.org/state_district_wise.json", String.class);
				
		    theModel.addAttribute("covidData",covidData);
			 return "list-covid";
			 
			 
		
	 }
	 
	 

}
