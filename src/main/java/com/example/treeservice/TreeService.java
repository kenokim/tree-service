package com.example.treeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TreeService {
    private final TreeNodeRepository treeNodeRepository;
    private final TreeEdgeRepository treeEdgeRepository;
    private final TreeStrategy treeStrategy;

    public TreeDto getTree(Long rootId) {
        TreeDto treeDto = new TreeDto();

        TreeNode node = treeNodeRepository.findById(rootId).get();
        while (true) {
            List<TreeEdge> edgeList = treeEdgeRepository.findAllByParentId(node.getId());
            for (TreeEdge edge : edgeList) {
                TreeNode next = edge.getChild();
            }
            break;
        }
        return null;
    }

    public TreeDto getTreeByGroupId(Long groupId) {
        List<TreeNode> nodes = treeNodeRepository.findAllByGroupId(groupId);
        List<TreeEdge> edges = treeEdgeRepository.findAllByGroupId(groupId);

        return treeStrategy.construct(nodes, edges);
    }
}
