package com.example.carforum.controller.admin;

import com.example.carforum.entity.Company;
import com.example.carforum.entity.Dealer;
import com.example.carforum.entity.Product;
import com.example.carforum.service.CompanyService;
import com.example.carforum.service.DealerService;
import com.example.carforum.service.ProductService;
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
public class ProductAdminController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/product")
    public String listProduct(Model model){
        List<Product> listProduct = productService.findAll();
        model.addAttribute("product", listProduct);
        return "admin/product/ListProduct";
    }

    @GetMapping("/admin/product/create")
    public String showProductNewForm(Model model){
        List<Dealer> listDealer = dealerService.findAll();
        model.addAttribute("listDealer",listDealer );
        model.addAttribute("product", new Product());
        return "admin/product/CreateProduct";
    }
    @PostMapping("/admin/product/save")
    public String showProductNewForm(Product product){
        productService.save(product);
        return "redirect:/admin/product";
    }
    @GetMapping("product/edit/{id}")
    public String showUpdateProductForm(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id).get();
                model.addAttribute("product", product);
                List<Dealer> listDealer = dealerService.findAll();
                model.addAttribute("listDealer",listDealer);
        return "admin/product/UpdateProduct";
    }

    @PostMapping("product/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, @Valid Product product,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "admin/product/UpdateProduct";
        }
        productService.save(product);
        return "redirect:/admin/product";
    }
    @GetMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model) {
        productService.deleteById(id);
        return "redirect:/admin/product";
    }
}
