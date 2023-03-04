package com.example.treeservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TreeNode {
    @Id
    private Long id;
    private Boolean isRoot;
    private String label;
}
