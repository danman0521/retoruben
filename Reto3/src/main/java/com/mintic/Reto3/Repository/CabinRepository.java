package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mintic.Reto3.Repository.Crud.CabinCrudRepositoryInterfaz;

@Repository
public class CabinRepository {
    @Autowired
    private CabinCrudRepositoryInterfaz cabinCrudRepositoryInterfaz ;
    
    public List <Cabin> getCabinAll(){
    return  (List<Cabin>) cabinCrudRepositoryInterfaz.findAll();
    
    }
    public Optional <Cabin> getCabinid(Integer id){
        return cabinCrudRepositoryInterfaz.findById(id);
    
    }
    public Cabin saveCabin(Cabin cabin){
        return  cabinCrudRepositoryInterfaz.save(cabin);
    }
   
    
    public void deleteCabin(Cabin cabin){  
        cabinCrudRepositoryInterfaz.delete(cabin);
    } 
}