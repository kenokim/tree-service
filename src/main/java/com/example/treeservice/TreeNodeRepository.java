package com.example.treeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreeNodeRepository extends JpaRepository<TreeNode, Long> {
    List<TreeNode> findAllByGroupId(Long groupId);
}
