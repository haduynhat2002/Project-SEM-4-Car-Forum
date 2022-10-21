package com.example.carforum.controller;


import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.PriceCar;
import com.example.carforum.service.CategoryCarService;
import com.example.carforum.service.PriceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/v1/pricecar")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class PriceCarController {
    @Autowired
    PriceCarService priceCarService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PriceCar>> getList() {
        return ResponseEntity.ok(priceCarService.finAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<PriceCar> priceCar = priceCarService.findById(id);
        if (!priceCar.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        return ResponseEntity.ok(priceCar.get());//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PriceCar> create(@RequestBody PriceCar priceCar) {
        return ResponseEntity.ok(priceCarService.save(priceCar));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<PriceCar> update(@PathVariable int id, @RequestBody PriceCar updatePriceCar){
        Optional<PriceCar> priceCar = priceCarService.findById(id);
        if (!priceCar.isPresent()){
            ResponseEntity.badRequest().build();
        }
        PriceCar exitsPriceCar = priceCar.get();
        exitsPriceCar.setName(updatePriceCar.getName());
        exitsPriceCar.setCategoryCar(updatePriceCar.getCategoryCar());
        exitsPriceCar.setListed_price(updatePriceCar.getListed_price());
        exitsPriceCar.setRolling_price(updatePriceCar.getRolling_price());
        exitsPriceCar.setStatus(updatePriceCar.getStatus());
        return ResponseEntity.ok(priceCarService.save(exitsPriceCar));//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<PriceCar> priceCar = priceCarService.findById(id);//tim product theo id
        if (!priceCar.isPresent()) {
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        priceCarService.deleteById(id);
        return ResponseEntity.ok().build();//cos du lieu tra ve
    }
}
