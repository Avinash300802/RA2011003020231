package com.affordmed.frontend_avinash.model;

import java.util.List;

public class NumbersResponse {
    private List<Integer> Numbers;

    public NumbersResponse(List<Integer> numbers) {
        Numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Numbers;
    }
}
