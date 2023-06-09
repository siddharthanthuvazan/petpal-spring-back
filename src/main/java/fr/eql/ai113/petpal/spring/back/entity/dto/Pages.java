package fr.eql.ai113.petpal.spring.back.entity.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Pages {

    private Map<String, Map<String,Object>> page = new HashMap<>();

    public Pages() {

    }

    public Pages(Map<String, Map<String, Object>> page) {
        this.page = page;
    }

    @JsonAnyGetter
    public Map<String,Map<String,Object>> getPage() {
        return page;
    }

    @JsonAnySetter
    public void setPage(String pageNumber, Map<String,Object> pageContent) {
        if (page == null) {
            page = new HashMap<>();
        }
        page.put(pageNumber,pageContent);
    }
}
