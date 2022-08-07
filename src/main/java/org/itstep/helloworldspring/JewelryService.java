package org.itstep.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService {

    @Autowired
    JewelryRepository jewelryRepository;

    public List<Jewelry> findAll(){
        return jewelryRepository.findAll();
    }

    public Optional<Jewelry> findById(Long id){
        return jewelryRepository.findById(id);
    }

    public Jewelry save(Jewelry jewelry){return jewelryRepository.save(jewelry);}

    public void deleteById(Long id){
        jewelryRepository.deleteById(id);
    }
}
