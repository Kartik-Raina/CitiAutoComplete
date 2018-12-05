/**
 * 
 */
package com.pramati.city.autocomplete.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.pramati.city.autocomplete.PramatiCityAutoCompleteApplication;
import com.pramati.city.autocomplete.service.ICityAutoCompleteServcie;

/**
 * @author karraina
 *
 */
@Service
public class CitiAutoCompleteServcieImpl implements ICityAutoCompleteServcie {

   
    @Override
    public List<String> getCityNames(String start, int atmost) {
        Set<String> cityNames = PramatiCityAutoCompleteApplication.cityNames;
        // Convert Set to stream for applying filter
        Stream<String> cityStream = cityNames.stream()
                .filter((c) -> c.startsWith(start.toLowerCase()));
        if (!start.trim().isEmpty() && atmost <= cityNames.size() && atmost != 0) {
            // return the list of result as per the atmost value
            return cityStream.limit(atmost).collect(Collectors.toList());
        } else {
            // return all records
            return cityStream.collect(Collectors.toList());
        }
    }

}
