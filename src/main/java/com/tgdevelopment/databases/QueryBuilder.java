package com.tgdevelopment.databases;

import lombok.Value;

@Value
public class QueryBuilder {

    Query query;

    String PARAMETER_SIGN = "?";

    private QueryBuilder(String query) {
        this.query = new Query(query);
    }

    public QueryBuilder withParameter(String parameter, String value){
        query.replace(PARAMETER_SIGN + parameter, value);
        return this;
    }

    public Query build(){
        return query;
    }

    public static QueryBuilder builder(String query) {
        return new QueryBuilder(query);
    }

}
