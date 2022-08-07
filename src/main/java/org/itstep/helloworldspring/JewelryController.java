package org.itstep.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
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
    Jewelry createOrSave(@RequestBody JewelryBase jewelry) {
        String imageBase = jewelry.getImage().split(",")[1];
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(imageBase);
        Jewelry newJewelry = new Jewelry(); //id++
        return jewelryService.save(new Jewelry(newJewelry.getId(), jewelry.getName(), jewelry.getColor(),
                jewelry.getPrice(), jewelry.getPriceNew(), imageBytes));
    }

    @PutMapping(value="/jewelries/{id}")
    Jewelry updateUser(@RequestBody JewelryBase newJewelry, @PathVariable Long id) {
        return jewelryService.findById(id).map(jewelry -> {
            jewelry.setName(newJewelry.getName());
            jewelry.setColor(newJewelry.getColor());
            jewelry.setPrice(newJewelry.getPrice());
            jewelry.setPriceNew(newJewelry.getPriceNew());
            String imageBase = newJewelry.getImage().split(",")[1];
            byte[] imageBytes = DatatypeConverter.parseBase64Binary(imageBase);
            jewelry.setImage(imageBytes);
            return jewelryService.save(jewelry);
        }).orElse(null);
    }

    @DeleteMapping(value="/jewelries/{id}")
    void deleteById(@PathVariable Long id) {
        jewelryService.deleteById(id);
        System.out.println("delete");
    }
}
