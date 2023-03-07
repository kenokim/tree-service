package com.example.treeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class TreeServiceTest {
    @Autowired
    private TreeService treeService;

    @Test
    void get_tree_test1() {
        Long groupId = 1L;
        TreeDto treeDto = treeService.getTreeByGroupId(groupId);
        System.out.println(treeDto);
    }

    @Test
    void get_tree_test2() {
        Long groupId = 2L;
        TreeDto treeDto = treeService.getTreeByGroupId(groupId);
        System.out.println(treeDto);
    }

    @Test
    @Rollback(value = false)
    void add_node_test1() {
        Long groupId = 2L;
        Long parentNodeId = 5L;
        String childName = "F GROUP";
        var tree = treeService.getTreeByGroupId(groupId);
        System.out.println(">>> Before " + tree);
        treeService.addTreeNode(groupId, childName, parentNodeId);
        tree = treeService.getTreeByGroupId(groupId);
        System.out.println(">>> After  " + tree);
    }
}
