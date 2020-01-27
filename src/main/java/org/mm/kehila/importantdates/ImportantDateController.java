package org.mm.kehila.importantdates;

import java.util.List;

import org.mm.kehila.exceptions.CongregantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportantDateController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final ImportantDateService importantdateService;

    ImportantDateController (ImportantDateService importantdateService){
        this.importantdateService = importantdateService;
    }

/*
    @RequestMapping("/")
    String index(){
        return "look in Swagger to get list of requests";
    }
 */
    @GetMapping("/importantdates")
    List<ImportantDate> getAll (){
        return importantdateService.getAll();
    }

    @GetMapping("/importantdates/month/{hebMonth}")
    List<ImportantDate> getByMonth (@PathVariable Integer hebMonth){
        List<ImportantDate> res = importantdateService.getImportantDateByHebMonth(hebMonth);
        if (res==null || res.isEmpty()){
            throw new CongregantNotFoundException(hebMonth.toString());
        }
        return res;
    }

    @GetMapping("/importantdates/month/{hebMonth}/day/{hebDay}")
    List<ImportantDate> getByMonthAndByDay (@PathVariable Integer hebMonth, @PathVariable Integer hebDay){
        List<ImportantDate> res = importantdateService.getImportantDateByHebMonthAndByDay(hebMonth, hebDay);
        if (res==null || res.isEmpty()){
            throw new CongregantNotFoundException(hebMonth.toString());
        }
        return res;
    }

    @GetMapping("/importantdates/id/{id}")
    ImportantDate getById (@PathVariable Long id){
        return importantdateService.getById(id).orElseThrow(()->new CongregantNotFoundException(id.toString()));
    }

    

}
