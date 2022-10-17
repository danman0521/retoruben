package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Cabin;
import com.mintic.Reto3.Repository.CabinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getCabinAll() {
        return cabinRepository.getCabinAll();

    }

    public Optional<Cabin> getCabinId(Integer id) {
        return cabinRepository.getCabinid(id);
    }

    public Cabin saveCabin(Cabin cabin) {
        if (cabin.getId() == null) {
            return cabinRepository.saveCabin(cabin);
        } else {
            Optional<Cabin> cabinAuxiliar = cabinRepository.getCabinid(cabin.getId());
            if (cabinAuxiliar.isEmpty()) {
                return cabinRepository.saveCabin(cabin);
            } else {
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin) {
        if (cabin.getId() != null) {
            Optional<Cabin> cabinAuxiliar = cabinRepository.getCabinid(cabin.getId());
            if (!cabinAuxiliar.isEmpty()) {
               if(cabin.getName()!=null){
                        cabinAuxiliar.get().setName(cabin.getName());
                    }
                    if(cabin.getRooms()!=null){
                        cabinAuxiliar.get().setRooms(cabin.getRooms());
                    }
                    if(cabin.getBrand()!=null){
                        cabinAuxiliar.get().setBrand(cabin.getBrand());
                    }
                    if(cabin.getDescription()!=null){
                        cabinAuxiliar.get().setDescription(cabin.getDescription());
                    }
                    if(cabin.getCategory()!=null){
                        cabinAuxiliar.get().setCategory(cabin.getCategory());
                    }    
                    cabinRepository.saveCabin(cabinAuxiliar.get());
                    return cabinAuxiliar.get();
                } else {
                    return cabin;
                }
            } else {
                return cabin;
            }
        }    

    
    public boolean deleteCabin(Integer cabinId) {
        boolean flag = false;
        Optional<Cabin> cabinAuxiliar = cabinRepository.getCabinid(cabinId);
        if (cabinAuxiliar.isPresent()) {
            cabinRepository.deleteCabin(cabinAuxiliar.get());
            flag = true;
        }
        return flag;
    }

}
