package org.mm.kehila.congregant;

import java.util.List;

import org.mm.kehila.exceptions.CongregantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CongregantController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final CongregantService congregantService;

    CongregantController (CongregantService congregantService){
        this.congregantService = congregantService;
    }

/*
    @RequestMapping("/")
    String index(){
        return "look in Swagger to get list of requests";
    }
 */
    @GetMapping("/congregants")
    List<Congregant> getAll (){
        return congregantService.getAll();
    }

    @GetMapping("/congregants/name/{lastname}")
    List<Congregant> getByName (@PathVariable String lastname){
        List<Congregant> res = congregantService.getCongregantByLastame(lastname);
        if (res==null || res.isEmpty()){
            throw new CongregantNotFoundException(lastname);
        }
        return res;
    }

    @GetMapping("/congregants/id/{id}")
    Congregant getById (@PathVariable Long id){
        return congregantService.getById(id).orElseThrow(()->new CongregantNotFoundException(id.toString()));
    }

    

}
