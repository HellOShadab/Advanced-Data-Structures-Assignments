/**
 * This AVLTree class inherits from the BinaryTree class.
 * It consists of a binary tree data structure containing nodes with data of generic dataType.
 * The methods provide utility for search, node insertion, as well as methods
 * for balancing the tree(using rotations), and calculating the balance factor.
 *
 * @author Shadab Khan
 **/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
    /**
     * Calculates and returns the height of a subtree.
     *
     * @param node BinaryTreeNode<dataType>
     * @return int
     **/
    public int height ( BinaryTreeNode<dataType> node )
    {
        if (node != null)
            return node.height;
        return -1;
    }

    /**
     * Calculates and returns the balance factor of a subtree.
     *
     * @param node BinaryTreeNode<dataType>
     * @return int
     **/
    public int balanceFactor ( BinaryTreeNode<dataType> node )
    {
        return height (node.right) - height (node.left);
    }

    /**
     * Reassigns the correct height to the sub-tree's height variable.
     *
     * @param node BinaryTreeNode<dataType>
     **/
    public void fixHeight ( BinaryTreeNode<dataType> node )
    {
        node.height = Math.max (height (node.left), height (node.right)) + 1;
    }

    /**
     * Performs a right rotation on the given node.
     *
     * @param p BinaryTreeNode<dataType>
     **/
    public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
    {
        BinaryTreeNode<dataType> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight (p);
        fixHeight (q);
        return q;
    }

    /**
     * Performs a left rotation on the given node.
     *
     * @param q BinaryTreeNode<dataType>
     **/
    public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
    {
        BinaryTreeNode<dataType> p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight (q);
        fixHeight (p);
        return p;
    }

    /**
     * Balance the subtree if necessary through the necessary rotations.
     *
     * @param p BinaryTreeNode<dataType>
     **/
    public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
    {
        fixHeight (p);
        if (balanceFactor (p) == 2)
        {
            if (balanceFactor (p.right) < 0)
                p.right = rotateRight (p.right);
            return rotateLeft (p);
        }
        if (balanceFactor (p) == -2)
        {
            if (balanceFactor (p.left) > 0)
                p.left = rotateLeft (p.left);
            return rotateRight (p);
        }
        return p;
    }

    /**
     * Adds a node onto the AVL tree structure at root.
     *
     * @param d dataType
     **/
    public void insert ( dataType d )
    {
        root = insert (d, root);
    }

    /**
     * Adds a node onto the AVL tree structure.
     *
     * @param d dataType
     * @param node BinaryTreeNode<dataType>
     **/
    public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node)
    {
        if (node == null)
            return new BinaryTreeNode<> (d, null, null);
        if (d.compareTo (node.data) <= 0)
            node.left = insert (d, node.left);
        else
            node.right = insert (d, node.right);
        return balance (node);
    }

    /**
     * Locates the node with the given value.
     *
     * @param d dataType
     **/
    public BinaryTreeNode<dataType> find ( dataType d )
    {
        int[] opCount = {0};
        if (root == null)
            return null;
        else
            return find (d, root, opCount);
    }

    /**
     * Locates the node with the given value.
     * The number of comparison operations are recorded.
     *
     * @param d dataType
     * @param opCount int[]
     * @param node BinaryTreeNode<dataType>
     **/
    public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node, int [] opCount)
    {
        int check = d.compareTo (node.data);
        opCount[0] ++;

        if (check == 0){
            Voter v = (Voter)node.data;
            v.setOpCount(opCount[0]);
            return node;
        }
        else if (check < 0)
            return (node.left == null) ? null : find (d, node.left, opCount);
        else
            return (node.right == null) ? null : find (d, node.right, opCount);
    }
}