package com.example.treeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreeEdgeRepository extends JpaRepository<TreeEdge, Long> {
    List<TreeEdge> findAllByParentId(Long parentId);
    List<TreeEdge> findAllByGroupId(Long groupId);
}
