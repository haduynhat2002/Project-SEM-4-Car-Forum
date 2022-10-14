package com.example.carforum.controller;

import com.example.carforum.entity.Role;
import com.example.carforum.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("api/v1/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(roleService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Role> save(@RequestBody Role district){
        return ResponseEntity.ok(roleService.save(district));
    }

}
