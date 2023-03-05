package com.example.treeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeDto {
    private Long id;
    private String name;
    private List<TreeDto> children = new ArrayList<>();
}
