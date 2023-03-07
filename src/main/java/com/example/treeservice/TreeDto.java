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

    @Override
    public String toString() {
        return name + children;
    }

    public static TreeDto create(TreeNode node) {
        TreeDto treeDto = new TreeDto();
        treeDto.setId(node.getId());
        treeDto.setName(node.getLabel());
        treeDto.setChildren(new ArrayList<>());
        return treeDto;
    }

    public void addChild(TreeDto child) {
        this.getChildren().add(child);
    }
}
