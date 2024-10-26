package com.saba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	@RequestMapping("/")
	public String employeePage()
	{
		return "employee";
	}

	@RequestMapping("/req1")
	public String invoicePage(@RequestParam int empNo,@RequestParam String empName,@RequestParam double salary,ModelMap model)
	{
		model.put("empNo", empNo);
		model.put("empName", empName);
		model.put("salary", salary);
		double ta=0, da=0, hra=0, pf=0;
		if(salary < 30000)
		{
			ta = salary * 7 / 100;
			da = salary * 9 / 100;
			hra = salary * 11 / 100;
			pf = salary * 15 / 100;
		}
		else if(salary <= 30000 && salary < 50000)
		{
			ta = salary * 12 / 100;
			da = salary * 13 / 100;
			hra = salary * 17 / 100;
			pf = salary * 22 / 100;
		}
		else 
		{
			ta = salary * 17 / 100;
			da = salary * 19 / 100;
			hra = salary * 21 / 100;
			pf = salary * 25 / 100;
		}
		double grossSalary = salary + ta + da + hra;
		double netSalary = grossSalary - pf;
		model.put("ta", ta);
		model.put("da", da);
		model.put("hra", hra);
		model.put("pf", pf);
		model.put("grossSalary", grossSalary);
		model.put("netSalary", netSalary);

		return "result";
	}
}
