package com.example.treeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TreeService {
    private final TreeNodeRepository treeNodeRepository;
    private final TreeEdgeRepository treeEdgeRepository;
    private final TreeStrategy treeStrategy;
    private final TreeAdapter treeAdapter;

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

    @Transactional
    public void addTreeNode(Long groupId, String name, Long parentNodeId) {
        TreeNode parent = treeNodeRepository.findById(parentNodeId).get();
        TreeNode child = new TreeNode(null, false, name, groupId);
        TreeEdge edge = new TreeEdge(null, parent, child, groupId);
        treeNodeRepository.save(child);
        treeEdgeRepository.save(edge);
    }

    public TreeDto getTreeByGroupId(Long groupId) {
        List<TreeNode> nodes = treeNodeRepository.findAllByGroupId(groupId);
        List<TreeEdge> edges = treeEdgeRepository.findAllByGroupId(groupId);

        return treeAdapter.convert(nodes, edges);
    }

    public List<TreeNode> getNodesByGroupId(Long groupId) {
        return treeNodeRepository.findAllByGroupId(groupId);
    }

    public List<TreeEdge> getEdgesByGroupId(Long groupId) {
        return treeEdgeRepository.findAllByGroupId(groupId);
    }
}
