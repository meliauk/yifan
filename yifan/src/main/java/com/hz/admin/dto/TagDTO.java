package com.hz.admin.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDTO {

    private String categoryTag;
    private String url;
    private List<String> stringListTag;

}