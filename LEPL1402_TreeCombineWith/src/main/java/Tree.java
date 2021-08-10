import javax.print.attribute.standard.MediaSize;

public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree combineWith(Tree o){
        if (o == null){return this;}
        if (this.root == null && o.root == null){return null;}
        if (this.root == null){return o;}
        if (o.root == null){return this;}
        Node resultingRoot = combineNodeOfTree(this.root, o.root);
        Tree resultingTree = new Tree(resultingRoot);
        return resultingTree;
    }

    public Node combineNodeOfTree(Node thisNode, Node otherNode){
        if (thisNode == null && otherNode == null){return null;}

        Node result = new Node(0);
        if (thisNode == null){
            result.val += otherNode.val;
            result.left = combineNodeOfTree(null, otherNode.left);
            result.right = combineNodeOfTree(null, otherNode.right);
        } else if (otherNode==null){
            result.val += thisNode.val;
            result.left = combineNodeOfTree(thisNode.left, null);
            result.right = combineNodeOfTree(thisNode.right, null);
        }
        else{
            result.val = thisNode.val + otherNode.val;
            result.left = combineNodeOfTree(thisNode.left, otherNode.left);
            result.right = combineNodeOfTree(thisNode.right, otherNode.right);
        }
        return result;
    }

}