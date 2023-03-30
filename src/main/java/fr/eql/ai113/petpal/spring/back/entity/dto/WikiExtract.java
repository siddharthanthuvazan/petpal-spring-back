package fr.eql.ai113.petpal.spring.back.entity.dto;

public class WikiExtract {

    private Query query;

    public WikiExtract() {
    }

    public WikiExtract(Query query) {
        this.query = query;
    }

    /// Getters ///
    public Query getQuery() {
        return query;
    }
}
