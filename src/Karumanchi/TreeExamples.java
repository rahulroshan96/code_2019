package Karumanchi;

import java.util.*;

class Node {
    int data;
    Node left=null;
    Node right=null;

    public Node(int n){
        data = n;
    }
}

public class TreeExamples {

    public static void main(String args[]){
        TreeExamples t = new TreeExamples();
        ArrayList<Integer> A = t.getRandomArrayList(10);
        t.printArray(A);
        System.out.println();
        Node root = t.createBST(A);
        System.out.println("Height of BST is :"+t.heightBST(root));
        System.out.println("Total Node in BST are :"+t.totalNodesInBST(root));
        System.out.println("Total Leaf Nodes in BST are :"+t.totalLeafNodes(root));
        System.out.println("Total Internal Nodes in BST are :"+t.totalInternalNodes(root));
        System.out.print("DFS Recursion Traversal in Tree :");
        t.treeDFSRecursion(root);
        System.out.println();
        System.out.print("DFS Iterative Traversal in Tree :");
        t.treeDFSIteration(root);
        System.out.println();
        System.out.print("BFS Iterative Traversal in Tree: ");
        t.treeBFSIteration(root);
        t.deleteTree(root);
        NodeLevel n = t.deepesetNode(root, 0);
        System.out.println("Node is: "+n.n.data);
        System.out.println("Level is: "+n.level);
    }

    void printArray(ArrayList<Integer> A){
        for(int i=0;i<A.size();i++){
            System.out.print(A.get(i) + " ");
        }
    }

    ArrayList<Integer> getRandomArrayList(int m){
        Random rand = new Random();
        ArrayList A = new ArrayList();
        int n=0;
        for(int i=0;i<m;i++){
            n = Math.abs(rand.nextInt()%500);
            A.add(n);
        }
        return A;
    }

    Node insertBST(Node root, int n){
        if(root==null){
            root = new Node(n);
        }else{
            Node temp = root;
            while(temp!=null){
                if(n<temp.data){
                    if(temp.left==null){
                        Node x = new Node(n);
                        temp.left = x;
                        break;
                    }else{
                        temp = temp.left;
                    }
                }else{
                    if(temp.right == null){
                        Node x = new Node(n);
                        temp.right = x;
                        break;
                    }else{
                        temp = temp.right;
                    }
                }
            }
        }
        return root;
    }

    void preOrderTravelsal(Node root){
        if(root == null){
            return;
        }else{
            System.out.print(root.data + " ");
            preOrderTravelsal(root.left);
            preOrderTravelsal(root.right);
        }
    }

    void inOrderTraversal(Node root){
        if(root == null){
            return;
        }else{
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    void postOrderTraversal(Node root){
        if(root == null){
            return;
        }else{
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    Node createBST(ArrayList<Integer> A){
        Node root=null;
        for(int i=0;i<A.size();i++){
            root = insertBST(root, A.get(i));
        }
//        System.out.print("PreOrder Traversal: ");
//        preOrderTravelsal(root);
//        System.out.println();
//        System.out.print("InOrder Traversal: ");
//        inOrderTraversal(root);
//        System.out.println();
//        System.out.print("PostOrder Traversal: ");
//        postOrderTraversal(root);
        return root;
    }

    int heightBST(Node root){
       if(root == null){
           return 0;
       }else{
           return Math.max(heightBST(root.left), heightBST(root.right)) + 1;
       }
    }

    int totalNodesInBST(Node root){
        if(root == null){
            return 0;
        }else{
            return totalNodesInBST(root.left) + totalNodesInBST(root.right) + 1;
        }
    }

    int totalLeafNodes(Node root){
        if(root == null){
            return 0;
        }else{
            if(root.right==null && root.left==null){
                return 1;
            }else{
                return totalNodesInBST(root.left) + totalNodesInBST(root.right);
            }
        }
    }

    int totalInternalNodes(Node root){
        if(root == null){
            return 0;
        }else{
            if(root.left != null || root.right!=null){
                return 1;
            }else{
                return totalInternalNodes(root.left) + totalInternalNodes(root.right);
            }
        }
    }

    void treeDFSRecursion(Node root){
        if(root !=null){
            System.out.print(root.data+" ");
            treeDFSRecursion(root.left);
            treeDFSRecursion(root.right);
        }
    }

    void treeDFSIteration(Node root){
        Stack<Node> s = new Stack<>();
        if(root !=null){
            s.push(root);
            Node temp = root;
            while(!s.empty()){
                temp = s.pop();
                System.out.print(temp.data+" ");
                if(temp.right!=null){
                    s.push(temp.right);
                }
                if(temp.left !=null){
                    s.push(temp.left);
                }
            }
        }
    }

    void treeBFSIteration(Node root){
        Queue q = new LinkedList<>(); // know about it
        if(root!=null){
            ((LinkedList<Node>) q).add(root);
            Node temp = null;
            while(!q.isEmpty()){
                temp = ((LinkedList<Node>) q).pop();
                System.out.print(temp.data+" ");
                if(temp.left != null) ((LinkedList<Node>) q).add(temp.left);
                if(temp.right != null) ((LinkedList<Node>) q).add(temp.right);
            }
        }
    }

    void deleteTree(Node root){
        if(root!=null){
            if(root.left != null) deleteTree(root.left);
            if(root.right != null) deleteTree(root.right);
            if(root.left == null && root.right == null) {
                System.out.println();
                System.out.println("Deleting Node "+root.data);
                root = null;
            }
        }
    }
    class NodeLevel{
        Node n;
        int level;
    }
    NodeLevel deepesetNode(Node root, int pre_level){
        if(root!=null){
            int level = pre_level+1;
            NodeLevel left=null, right=null;
            if(root.left !=null){
                left = deepesetNode(root.left, level);
            }
            if(root.right != null) {
                right = deepesetNode(root.right, level);
            }
            if(root.left == null && root.right == null) {
                NodeLevel n = new NodeLevel();
                n.n = root;
                n.level = level;
                return n;
            }
            if(left != null && right!= null){
                if(left.level > right.level) return left;
                else{
                    return right;
                }
            }else{
                if(left == null){
                    return right;
                }else{
                    return left;
                }
            }
        }else return null;
    }

}
