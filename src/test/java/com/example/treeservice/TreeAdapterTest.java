package com.example.treeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TreeAdapterTest {
    @Autowired
    private TreeAdapter treeAdapter;

    @Autowired
    private TreeService treeService;

    @Test
    void treeAdapt_test2() {
        Long groupId = 2L;
        var nodes = treeService.getNodesByGroupId(groupId);
        var edges = treeService.getEdgesByGroupId(groupId);
        var tree = treeAdapter.convert(nodes, edges);
        System.out.println(tree);
    }

    @Test
    void fillChildren_test2() {
        Long groupId = 2L;
        var nodes = treeService.getNodesByGroupId(groupId);
        var edges = treeService.getEdgesByGroupId(groupId);

        var root = treeAdapter.findRoot(nodes);
        TreeDto rootDto = TreeDto.create(root);

        var filled = treeAdapter.fillChildren(rootDto, edges);
        System.out.println(filled);
    }
}