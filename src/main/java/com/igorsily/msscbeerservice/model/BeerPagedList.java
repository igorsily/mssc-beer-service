package com.igorsily.msscbeerservice.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedList extends PageImpl<Beer> {

    public BeerPagedList(List<Beer> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<Beer> content) {
        super(content);
    }
}
