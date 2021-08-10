import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if(root==null){return;}
        else{
        recursiveInorder(root.left,res);
        res.add(root.val);
        recursiveInorder(root.right,res);}
    }

    public static void recursiveinorder(Node root, List<Integer> res){
        if (root.left!=null){
            recursiveinorder(root.left, res);
        }
        res.add(root.val);
        if (root.right != null){
            recursiveinorder(root.right, res);
        }
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        Stack<Node> visited = new Stack<>();
        Node head = root;

        while (head != null || visited.size()>0){
            while (head != null){
                visited.push(head);
                head = head.left;
            }
            head = visited.pop();
            res.add(head.val);
            head = head.right;
        }
    }

}
