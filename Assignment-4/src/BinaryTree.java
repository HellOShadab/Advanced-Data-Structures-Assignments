/**
 * This class consists of a binary tree data structure containing nodes with data of generic dataType.
 * The methods provide utility for various operations.
 *
 * @author Shadab Khan
 **/

public class BinaryTree<dataType>
{
    BinaryTreeNode<dataType> root;

    /**
     * BinaryTree class default constructor to set root to null.
     **/
    public BinaryTree ()
    {
        root = null;
    }

    /**
     * Return the size (number of nodes) of the binary tree data structure.
     *
     * @return int
     **/
    public int getSize ()
    {
        return getSize (root);
    }

    /**
     * Return the size (number of nodes) of the binary tree data structure.
     *
     * @param node BinaryTreeNode<dataType>
     * @return int
     **/
    public int getSize ( BinaryTreeNode<dataType> node )
    {
        if (node == null)
            return 0;
        else
            return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
    }
}