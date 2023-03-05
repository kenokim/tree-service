package com.example.treeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
