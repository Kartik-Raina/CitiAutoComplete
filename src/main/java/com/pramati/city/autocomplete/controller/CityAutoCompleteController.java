/**
 * 
 */
package com.pramati.city.autocomplete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.city.autocomplete.service.ICityAutoCompleteServcie;

/**
 * @author karraina
 * 
 * The controller class
 */
@RestController
public class CityAutoCompleteController {

    @Autowired
    ICityAutoCompleteServcie citiAutoCompleteServcie;

    @GetMapping("suggest_cities")
    public List<String> getCityNames(@RequestParam(value = "start", defaultValue = "") String start,
            @RequestParam(value = "atmost", defaultValue = "0") int atmost) {
        return citiAutoCompleteServcie.getCityNames(start, atmost);
    }

}
