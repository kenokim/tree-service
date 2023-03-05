package com.example.treeservice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TreeStrategy {
    private TreeNode findNodeById(List<TreeNode> nodes, Long id) {
        for (TreeNode node : nodes) {
            if (node.getId() == id) return node;
        }
        return null;
    }

    private TreeEdge findEdgeById(List<TreeEdge> edges, Long id) {
        for (TreeEdge edge : edges) {
            if (edge.getId() == id) return edge;
        }
        return null;
    }

    public TreeDto construct(List<TreeNode> nodes, List<TreeEdge> edges) {
        System.out.println("Construct a tree from ... \n" + nodes + "\n" + edges);
        TreeNode root = null;
        for (TreeNode node : nodes) {
            if (node.getIsRoot()) root = node;
        }

        TreeDto rootDto = new TreeDto(root.getId(), root.getLabel(), new ArrayList<>());
        for (TreeEdge edge : edges) {
            if (edge.getParent().getId() == root.getId()) {
                TreeNode child = edge.getChild();
                TreeDto childDto = new TreeDto(child.getId(), child.getLabel(), new ArrayList<>());
                rootDto.getChildren().add(childDto);
            }
        }
        return rootDto;
    }
}
