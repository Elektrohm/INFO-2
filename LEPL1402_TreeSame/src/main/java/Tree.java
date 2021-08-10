public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){return true;}
        if (!(o instanceof Tree)){return false;}

        Tree other = (Tree) o;
        Node thisStart = this.root;
        Node otherStart = other.root;

        if (thisStart== null && otherStart == null){return true;}
        if ((thisStart==null)||(otherStart==null)){return false;}
        if (thisStart.equals(otherStart)){
            Tree thisTreeLeft = new Tree(thisStart.left);
            Tree thisTreeRight = new Tree(thisStart.right);
            return (thisTreeLeft.equals(new Tree(otherStart.left)) &&
                   thisTreeRight.equals(new Tree(otherStart.right)));

        }
        return false;


    }

}