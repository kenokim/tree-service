package com.example.treeservice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeDto {
    private Long id;
    private String name;
    private List<TreeDto> children = new ArrayList<>();
}
