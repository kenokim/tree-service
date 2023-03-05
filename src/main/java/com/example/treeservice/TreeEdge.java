package com.example.treeservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TreeEdge {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TreeNode parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private TreeNode child;
    private Long groupId;
}
