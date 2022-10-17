package com.mintic.Reto3.Controller;

import com.mintic.Reto3.Model.Cabin;
import com.mintic.Reto3.Service.CabinService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/Cabin")
@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabinController {
    
    @Autowired
    private CabinService cabinService;
    
    @GetMapping("/all")
    public List< Cabin> getCabinALL(){
        return cabinService.getCabinAll();
    }
    @GetMapping("/id")    
    public Optional <Cabin> getCabinId(@PathVariable("id")Integer identificador){
        return cabinService.getCabinId(identificador);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin saveCabin (@RequestBody Cabin cabin){
    return cabinService.saveCabin(cabin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin){
        return cabinService.update(cabin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Integer cabinId){
        return cabinService.deleteCabin(cabinId);
    }

    
}