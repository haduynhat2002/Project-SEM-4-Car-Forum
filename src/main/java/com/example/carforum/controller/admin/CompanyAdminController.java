package com.example.carforum.controller.admin;

import com.example.carforum.entity.Company;
import com.example.carforum.service.CompanyService;
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
public class CompanyAdminController {
    @Autowired
   private CompanyService companyService;

    @GetMapping("admin/company")
    public String listCompany(Model model){
        List<Company> listCompany = companyService.findAll();
        model.addAttribute("listCompany", listCompany);
        return "admin/company/ListCompany";
    }
    @GetMapping("/admin/company/create")
    public String showCompanyNewForm(Model model){
        model.addAttribute("company", new Company());
        return "admin/company/CreateCompany";
    }
    @PostMapping("company/save")
    public String showCompanyNewForm(Company company){
        companyService.save(company);
        return "redirect:/admin/company";
    }
    @GetMapping("company/edit/{id}")
    public String showUpdateCompanyForm(@PathVariable("id") Integer id, Model model) {
        Company company = companyService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company Id:" + id));

        model.addAttribute("company", company);
        return "admin/company/UpdateCompany";
    }

    @PostMapping("company/update/{id}")
    public String updateCompany(@PathVariable("id") Integer id, @Valid Company company,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            company.setId(id);
            return "admin/company/UpdateCompany";
        }

        companyService.save(company);
        return "redirect:/admin/company";
    }
    @GetMapping("company/delete/{id}")
    public String deleteCompany(@PathVariable("id") Integer id, Model model) {
        companyService.deleteById(id);
        return "redirect:/admin/company";
    }
}
