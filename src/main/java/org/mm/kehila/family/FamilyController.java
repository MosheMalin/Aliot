package org.mm.kehila.family;

import java.util.List;

import org.mm.kehila.exceptions.CongregantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final FamilyService familyService;

    FamilyController (FamilyService familyService){
        this.familyService = familyService;
    }

/*
    @RequestMapping("/")
    String index(){
        return "look in Swagger to get list of requests";
    }
 */
    @GetMapping("/families")
    List<Family> getAll (){
        return familyService.getAll();
    }

    @GetMapping("/families/name/{lastname}")
    List<Family> getByName (@PathVariable String lastname){
        List<Family> res = familyService.getFamilyByLastame(lastname);
        if (res==null || res.isEmpty()){
            throw new CongregantNotFoundException(lastname);
        }
        return res;
    }

    @GetMapping("/families/id/{id}")
    Family getById (@PathVariable Long id){
        return familyService.getById(id).orElseThrow(()->new CongregantNotFoundException(id.toString()));
    }

    

}
