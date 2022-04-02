package com.phone.Domain;

import com.phone.Domain.Enums.SearchField;
import com.phone.Domain.Enums.SearchType;

public class SearchRequest {
    private SearchField searchField;

    private SearchType searchType;

    private String input;

    public SearchRequest(SearchField searchField, SearchType searchType, String input) {
        this.searchField = searchField;
        this.searchType = searchType;
        this.input = input;
    }

    public SearchField getSearchField() {
        return searchField;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public String getInput() {
        return input;
    }
}
