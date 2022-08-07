package org.itstep.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class JewelryController {
    @Autowired
    JewelryService jewelryService;

    @GetMapping(value="/jewelries")
    public List<Jewelry> findAll(){
        return jewelryService.findAll();
    }

    @GetMapping(value="/jewelries/{id}")
    public Optional<Jewelry> findById(@PathVariable Long id){
        return jewelryService.findById(id);
    }

    @PostMapping(value="/jewelries")
    Jewelry createOrSave(@RequestBody Jewelry jewelry) {
        return jewelryService.save(jewelry);
    }

    @PutMapping(value="/jewelries/{id}")
    Jewelry updateUser(@RequestBody Jewelry newJewelry, @PathVariable Long id) {
        return jewelryService.findById(id).map(jewelry -> {
            jewelry.setName(newJewelry.getName());
            jewelry.setPrice(newJewelry.getPrice());
            jewelry.setPriceNew(newJewelry.getPriceNew());
            return jewelryService.save(jewelry);
        }).orElseGet(() -> {
            return jewelryService.save(newJewelry);
        });
    }

    @DeleteMapping(value="/jewelries/{id}")
    void deleteById(@PathVariable Long id) {
        jewelryService.deleteById(id);
        System.out.println("delete");
    }
}
