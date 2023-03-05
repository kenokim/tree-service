package com.example.treeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SelectTreeTest {

    @Autowired
    private TreeNodeRepository treeNodeRepository;

    @Autowired
    private TreeEdgeRepository treeEdgeRepository;

    @Test
    void select_tree_test1() {
        Long groupId = 1L;
        List<TreeNode> nodes = treeNodeRepository.findAllByGroupId(groupId);
        List<TreeEdge> edges = treeEdgeRepository.findAllByGroupId(groupId);

        nodes.forEach(System.out::println);
        edges.forEach(System.out::println);
    }
}
