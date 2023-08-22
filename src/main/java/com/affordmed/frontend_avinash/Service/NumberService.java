package com.affordmed.frontend_avinash.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Collections;

@Service
public class NumberService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Integer> fetchNumbersFromUrl(String apiUrl) {
        ResponseEntity<NumbersResponse> responseEntity = restTemplate.getForEntity(apiUrl, NumbersResponse.class);
        NumbersResponse responseBody = responseEntity.getBody();

        if (responseBody != null) {
            return responseBody.getNumbers();
        }

        return Collections.emptyList();
    }
}
