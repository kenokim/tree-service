package com.example.treeservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TreeEdge {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private TreeNode parent;

    @ManyToOne
    @JoinColumn(name = "id")
    private TreeNode child;
}
