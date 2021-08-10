
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests{

    private Supplier<Integer> rnd = () -> (int) (Math.random() * 100);

    private static boolean recursivePass = false;
    private static boolean iterativePass = false;

    private int [] matching = new int[]{3, 1, 4, 0, 5, 2};


    @Test
    public void customTest(){
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.left.left.left.left = new Node(9);
        root.left.left.left.right = new Node(10);
        root.left.right.left.left = new Node(11);
        root.left.right.right.left = new Node(12);
        root.left.right.left.right = new Node(13);
        root.left.left.right.left = new Node(14);
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        Traversal.recursiveInorder(root, res);
        Traversal.recursiveinorder(root,res2);
        System.out.println(Arrays.toString(new ArrayList[]{res}));
        System.out.println(Arrays.toString(new ArrayList[]{res2}));

    }


    @Test
    public void test1(){


        //Integer [] nodes = Stream.generate(rnd).limit(6).toArray(Integer[]::new);
        Integer[] nodes = {0,1,4,2,3,5};
        Node node = new Node(nodes[0]);
        buildTree(node,nodes);

        ArrayList<Integer> res = new ArrayList<>();
        Traversal.recursiveInorder(node, res);

        for(int i =0; i < nodes.length; i++){
            assertEquals( res.get(i), nodes[matching[i]] );
        }

        recursivePass = true;

    }


    @Test
    public void test2(){

        Integer [] nodes = Stream.generate(rnd).limit(6).toArray(Integer[]::new);

        Node node = new Node(nodes[0]);
        buildTree(node,nodes);

        ArrayList<Integer> res = new ArrayList<>();
        Traversal.iterativeInorder(node, res);

        for(int i =0; i < nodes.length; i++){
            assertEquals( res.get(i), nodes[matching[i]] );
        }

        iterativePass = true;
    }


    @Test
    public void test3(){

        assumeTrue(iterativePass && recursivePass); // Skip this test if the two previous one didn't pass.

        Integer [] nodes = Stream.generate(rnd).limit(6).toArray(Integer[]::new);

        Node nodeIt = new Node(nodes[0]);
        Node nodeRec = new Node(nodes[0]);
        buildTree(nodeIt, nodes);
        buildTree(nodeRec, nodes);

        ArrayList<Integer> it = new ArrayList<>();
        ArrayList<Integer> rec = new ArrayList<>();
        Traversal.iterativeInorder(nodeIt, it);
        Traversal.recursiveInorder(nodeRec, rec);

        assertEquals(it.size(), rec.size());

        for(int i=0; i < it.size(); i++){
            assertEquals(it.get(i), rec.get(i));
        }

    }


    private void buildTree(Node node, Integer[] nodes){
        node.left = new Node(nodes[1]);
        node.right = new Node(nodes[2]);
        node.left.left = new Node(nodes[3]);
        node.left.right = new Node(nodes[4]);
        node.right.left = new Node(nodes[5]);
    }





}