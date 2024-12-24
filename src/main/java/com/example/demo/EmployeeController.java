package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {
    Logger log = Logger.getAnonymousLogger();
    
    @Autowired
    EmployeeService service;

    @RequestMapping("/insert")
    public ModelAndView insertData(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();
        Employee e = new Employee();
        e.setEname(req.getParameter("name"));
        e.setPhono(req.getParameter("phono"));
        if (service.insert(e) != null) {
            mv.setViewName("insertSuccess.jsp");
        }
        return mv;
    }

    @RequestMapping("/getall")
    public ModelAndView getData(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();
        List<Employee> list = service.getall();
        mv.setViewName("empdisplay.jsp");
        mv.addObject("list", list);
        return mv;
    }

    // Show the Update Form (GET method)
    @RequestMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        Employee employee = service.getEmployeeById(id);  // Retrieve employee by id
        mv.setViewName("updateForm.jsp");
        mv.addObject("employee", employee);
        return mv;
    }

    // Process the Update (POST method)
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        Employee updatedEmployee = service.updatebyName(employee);
        model.addAttribute("employee", updatedEmployee);
        return "employeeDetails.jsp"; // Display updated employee details
    }

    // Delete an Employee by ID
    @RequestMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView();
        log.info(id);
        List<Employee> employees = service.deleteById(Integer.parseInt(id));
        mv.setViewName("empdisplay.jsp");
        mv.addObject("list", employees);
        return mv;
    }
}