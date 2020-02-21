package com.tgdevelopment.databases;

public class Query {

    private StringBuilder query;

    public Query(String query) {
        this.query = new StringBuilder(query);
    }

    public void replace(String oldString, String newString) {
        String newQuery = this.query.toString().replace(oldString, newString);
        setQuery(newQuery);
    }

    public String getQuery(){
        return this.query.toString();
    }

    private void setQuery(String query) {
        this.query = new StringBuilder(query);
    }

}
