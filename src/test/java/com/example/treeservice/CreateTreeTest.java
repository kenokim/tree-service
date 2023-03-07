package com.example.treeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false)
public class CreateTreeTest {

    @Autowired
    private TreeNodeRepository treeNodeRepository;

    @Autowired
    private TreeEdgeRepository treeEdgeRepository;

    @Test
    @Rollback(value = false)
    void create_tree_test1() {
        TreeNode root = new TreeNode(1L, true, "A COMPANY", 1L);
        TreeNode depth1node1 = new TreeNode(2L, false, "B PART", 1L);
        TreeNode depth1node2 = new TreeNode(3L, false, "C PART", 1L);

        TreeEdge root_depth1node1 = new TreeEdge(1L, root, depth1node1, 1L);
        TreeEdge root_depth1node2 = new TreeEdge(2L, root, depth1node2, 1L);

        treeNodeRepository.save(root);
        treeNodeRepository.save(depth1node1);
        treeNodeRepository.save(depth1node2);

        treeEdgeRepository.save(root_depth1node1);
        treeEdgeRepository.save(root_depth1node2);
    }

    @Test
    @Rollback(value = false)
    void create_tree_test2() {
        TreeNode root = new TreeNode(1L, true, "A COMPANY", 2L);
        TreeNode depth1node1 = new TreeNode(2L, false, "B PART", 2L);
        TreeNode depth1node2 = new TreeNode(3L, false, "C PART", 2L);

        TreeNode depth2node1 = new TreeNode(4L, false, "D TEAM", 2L);
        TreeNode depth2node2 = new TreeNode(5L, false, "E TEAM", 2L);

        TreeEdge root_depth1node1 = new TreeEdge(1L, root, depth1node1, 2L);
        TreeEdge root_depth1node2 = new TreeEdge(2L, root, depth1node2, 2L);

        TreeEdge root_depth2node1 = new TreeEdge(3L, depth1node1, depth2node1, 2L);
        TreeEdge root_depth2node2 = new TreeEdge(4L, depth1node1, depth2node2, 2L);

        treeNodeRepository.save(root);
        treeNodeRepository.save(depth1node1);
        treeNodeRepository.save(depth1node2);

        treeNodeRepository.save(depth2node1);
        treeNodeRepository.save(depth2node2);

        treeEdgeRepository.save(root_depth1node1);
        treeEdgeRepository.save(root_depth1node2);

        treeEdgeRepository.save(root_depth2node1);
        treeEdgeRepository.save(root_depth2node2);
    }
}
