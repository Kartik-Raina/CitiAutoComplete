package com.pramati.citi.autocomplete;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.pramati.city.autocomplete.PramatiCityAutoCompleteApplication;
import com.pramati.city.autocomplete.service.ICityAutoCompleteServcie;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PramatiCityAutoCompleteApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PramatiCitiAutoCompleteApplicationTests {

    @Autowired
    ICityAutoCompleteServcie citiAutoCompleteServcie;

    @Before
    public void initValues() {
        PramatiCityAutoCompleteApplication.cityNames.add("Delhi");
        PramatiCityAutoCompleteApplication.cityNames.add("MUMBAI");
        PramatiCityAutoCompleteApplication.cityNames.add("Bangalore");
        PramatiCityAutoCompleteApplication.cityNames.add("kolkata");
    }

    @Test
    public void findCityNormalCase() {
        assertNotNull(citiAutoCompleteServcie.getCityNames("del", 1));
    }
    
    @Test
    public void findCityCitiBlank() {
        assertNotNull(citiAutoCompleteServcie.getCityNames("", 1));
    }
    
    @Test
    public void findCityAtmostZero() {
        assertNotNull(citiAutoCompleteServcie.getCityNames("mum", 0));
    }

}
