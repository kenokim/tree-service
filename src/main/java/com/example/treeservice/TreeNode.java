package com.example.treeservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    @Id @GeneratedValue
    private Long id;
    private Boolean isRoot;
    private String label;
    private Long groupId;
}
