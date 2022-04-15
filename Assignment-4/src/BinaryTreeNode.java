/**
 * This class makes the various Nodes of the binary tree.
 * Methods provide utility for returning child nodes, left and right.
 *
 * data : Stores the data of generic type dataType
 * left : Points to the left child
 * right : Points to the right child
 * height : Stores current height of node
 *
 * @author Shadab Khan
 **/

public class BinaryTreeNode<dataType>
{
    dataType data;
    BinaryTreeNode<dataType> left;
    BinaryTreeNode<dataType> right;
    int height;

    /**
     * Constructor to initialize and set all values.
     *
     * @param d dataType
     * @param l BinaryTreeNode<dataType>
     * @param r BinaryTreeNode<dataType>
     **/
    public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
    {
        data = d;
        left = l;
        right = r;
        height = 0;
    }

    /**
     * Returns left node.
     *
     * @return left BinaryTreeNode<dataType>
     **/
    BinaryTreeNode<dataType> getLeft () { return left; }

    /**
     * Returns right node.
     *
     * @return right BinaryTreeNode<dataType>
     **/
    BinaryTreeNode<dataType> getRight () { return right; }
}