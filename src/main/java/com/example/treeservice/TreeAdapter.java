package com.example.treeservice;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TreeAdapter {
    public TreeDto convert(List<TreeNode> nodes, List<TreeEdge> edges) {
        TreeDto root = TreeDto.create(findRoot(nodes));
        root = fillChildren(root, edges);
        return root;
    }

    public TreeDto fillChildren(TreeDto parent, List<TreeEdge> edges) {
        for (TreeEdge edge : edges) {
            if (edge.getParent().getId() == parent.getId()) {
                 TreeDto child = TreeDto.create(edge.getChild());
                 fillChildren(child, edges);
                 parent.addChild(child);
            }
        }
        return parent;
    }

    public TreeNode findRoot(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            if (node.getIsRoot()) return node;
        }

        return null;
    }

    private TreeNode findByNodeId(Long id, List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            if (node.getId() == id) return node;
        }

        return null;
    }

    private TreeEdge findByEdgeId(Long id, List<TreeEdge> edges) {
        for (TreeEdge edge : edges) {
            if (edge.getId() == id) return edge;
        }

        return null;
    }
}
