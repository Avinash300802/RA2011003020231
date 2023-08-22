package com.affordmed.frontend_avinash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;

@RestController
public class NumberController {

    @GetMapping(value = "/numbers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMergedNumbers(@RequestParam List<String> url) {
        List<Integer> mergedNumbers = new ArrayList<>();

        for (String apiUrl : url) {
            try {
                List<Integer> numbers = fetchNumbersFromUrl(apiUrl);
                mergedNumbers.addAll(numbers);
            } catch (Exception e) {
                // Handle exceptions, e.g., timeout, invalid URL, etc.
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>(mergedNumbers);
        List<Integer> sortedUniqueNumbers = new ArrayList<>(uniqueNumbers);
        sortedUniqueNumbers.sort(Integer::compareTo);

        return ResponseEntity.ok(new NumbersResponse(sortedUniqueNumbers));
    }

    private List<Integer> fetchNumbersFromUrl(String apiUrl) {
        // Implement fetching numbers from the provided API URL
        // You can use libraries like RestTemplate or WebClient for making HTTP requests
        return new ArrayList<>(); // Placeholder
    }
}
