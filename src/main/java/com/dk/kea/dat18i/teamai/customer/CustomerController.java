package com.dk.kea.dat18i.teamai.customer;

import com.dk.kea.dat18i.teamai.booking.BookingRepo;
import com.dk.kea.dat18i.teamai.log.Log;
import com.dk.kea.dat18i.teamai.log.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private LogRepository logRepo;

    @GetMapping("/customerview")
    public Customer showCustomer(){

        Customer customer = customerRepo.findCustomer(1);

        return customer;
    }

    @GetMapping("/customer")
    public String customer(Model model) {

        List<Customer> customerList = customerRepo.findAllCustomers();
        model.addAttribute("customers", customerList);

        return "show-customers";
    }

    @GetMapping("/addcustomer")
    public String addCustomer(Model model) {

        Customer customer = new Customer();
        model.addAttribute( "customer", customer);

        return "add-customer";
    }
    @PostMapping("/savecustomer")
    public String saveCustomer(@ModelAttribute Customer customer){
        Customer newCustomer = new Customer();

        newCustomer.setFirst_name(customer.getFirst_name());
        newCustomer.setLast_name(customer.getLast_name());
        newCustomer.setPhone_number(customer.getPhone_number());


        customerRepo.createCustomer(newCustomer);

        logRepo.addBookingCustomer();



        return "redirect:/summary";
    }

    @RequestMapping(value = "customer/delete/{customer_id}")
    public String removeScreening(@PathVariable int customer_id) {

        customerRepo.deleteCustomer(customer_id);

        return "redirect:/customer";
    }


    @GetMapping("/customer/edit/{customer_id}")
    public String editCustomer (Model m, @PathVariable(name="customer_id") int customer_id){
        Customer customerToEdit= customerRepo.findCustomer(customer_id);
        m.addAttribute("editcustomer",customerToEdit);
        return "edit-customer";
    }

    @RequestMapping(value = "/updatecustomer", method= RequestMethod.POST)
    public String saveEditCustomer(@ModelAttribute Customer customer){

        customer.setFirst_name(customer.getFirst_name());
        customer.setLast_name(customer.getLast_name());
        customer.setPhone_number(customer.getPhone_number());

        customerRepo.update(customer);

        return "redirect:/customer";
    }
}
