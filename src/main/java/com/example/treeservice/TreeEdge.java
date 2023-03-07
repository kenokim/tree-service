package com.example.treeservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TreeEdge {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TreeNode parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private TreeNode child;
    private Long groupId;
}
