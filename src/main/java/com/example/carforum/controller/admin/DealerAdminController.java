package com.example.carforum.controller.admin;

import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.Company;
import com.example.carforum.entity.Dealer;
import com.example.carforum.entity.Product;
import com.example.carforum.service.CompanyService;
import com.example.carforum.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DealerAdminController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private CompanyService companyService;
    @GetMapping("/admin/dealer")
    public String listDealer(Model model){
        List<Dealer> listDealer = dealerService.findAll();
        model.addAttribute("dealer", listDealer);
        return "admin/dealer/ListDealer";
    }

    @GetMapping("/admin/dealer/create")
    public String showDealerNewForm(Model model){
        List<Company> listCompany = companyService.findAll();
        model.addAttribute("listCompany",listCompany );
        model.addAttribute("dealer", new Dealer());
        return "admin/dealer/CreateDealer";
    }
    @PostMapping("/admin/dealer/save")
    public String showDealerNewForm(Dealer dealer){
        dealerService.save(dealer);
        return "redirect:/admin/dealer";
    }
    @GetMapping("dealer/edit/{id}")
    public String showUpdateDealerForm(@PathVariable("id") Integer id, Model model) {
        Dealer dealer = dealerService.findById(id).get();
        model.addAttribute("dealer", dealer);
        List<Company> listCompany = companyService.findAll();
        model.addAttribute("listCompany",listCompany );

        return "admin/dealer/UpdateDealer";
    }

    @PostMapping("dealer/update/{id}")
    public String updateDealer(@PathVariable("id") Integer id, @Valid Dealer dealer,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            dealer.setId(id);
            return "admin/dealer/UpdateDealer";
        }
        dealerService.save(dealer);
        return "redirect:/admin/dealer";
    }
    @GetMapping("dealer/delete/{id}")
    public String deleteDealer(@PathVariable("id") Integer id, Model model) {
        dealerService.deleteById(id);
        return "redirect:/admin/dealer";
    }
}
