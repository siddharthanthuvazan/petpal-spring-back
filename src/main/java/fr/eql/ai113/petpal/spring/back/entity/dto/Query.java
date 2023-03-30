package fr.eql.ai113.petpal.spring.back.entity.dto;

public class Query {

    private Pages pages;

    public Query() {
    }

    public Query(Pages pages) {
        this.pages = pages;
    }

    /// Getters ///
    public Pages getPages() {
        return pages;
    }
}
