package com.mintic.Reto3.Controller;

import com.mintic.Reto3.Model.Admin;
import com.mintic.Reto3.Service.AdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminController {
    
    @Autowired
    private AdminService  adminService;
    
    @GetMapping("/all")
    public List <Admin> getAdminAll(){
        return adminService.getAdminAll();
    }
    @GetMapping("/id")
    public Optional <Admin> getAdminId (@PathVariable("id")Integer identificador){
        return adminService.getAdminId(identificador);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Admin saveAdmin (@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
}
