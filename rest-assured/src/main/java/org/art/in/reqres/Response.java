package org.art.in.reqres;

import java.util.List;

@lombok.Data
public class Response {

    private int page;
    private int per_page;
    private int total;
    private List<Data> data;
    private int total_pages;
    private Support support;
}