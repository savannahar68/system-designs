package com.phone.Domain;

import java.util.List;
import java.util.Objects;

public class SearchResponse {
    private int totalCount;

    private List<Contact> results;

    public SearchResponse(int totalCount, List<Contact> results) {
        this.totalCount = totalCount;
        this.results = results;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "totalCount=" + totalCount +
                ", results=" + results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResponse that = (SearchResponse) o;
        return totalCount == that.totalCount && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCount, results);
    }
}
