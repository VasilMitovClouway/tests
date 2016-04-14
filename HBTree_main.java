package task8.HomogeneusTree;

/**
 * Created by clouway on 08.04.16.
  */
  public class HomogeneusTree {

  private HomogeneusNode root;

  /**
   * Checker if a getData exists
   *
   * @param value we are checking if it exists in the Tree
   * @return True if the getData exists and False if it does not;
   * We traverse the tree using the fact that every left/right child
   * is in its place depending on the getData.If the getData of the current
   * node is the one we are looking for it will return True.Otherwise we
   * check at the left child if its lower and at the right child if its
   * higher,and we do this until we get to a node with no children
   */
  public boolean checkIfExists(int value) {
    HomogeneusNode HomogeneusNode = root;
    while (HomogeneusNode != null) {
      if (value == HomogeneusNode.getData()) {
        return true;
      } else if (value < HomogeneusNode.getData()) {
        HomogeneusNode = HomogeneusNode.getLeft();
      } else {
        HomogeneusNode = HomogeneusNode.getRight();
      }
    }
    return false;

  }

  /**
   * The public method we are using to insert new Nodes in the Tree
   *
   * @param data the data that will be stored in the Node
   */
  public void insert(int data) {
    root = insert(root, data, null);
  }

  private HomogeneusNode insert(HomogeneusNode current, int data, HomogeneusNode parent) {
    if (!checkIfExists(data)) {
      if (current == null) {
        current = new HomogeneusNode();
        current.setData(data);
        current.setLeft(null);
        current.setRight(null);
        current.setParent(parent);
      } else if (data < current.getData())
        current.setLeft(insert(current.getLeft(), data, current));
      else current.setRight(insert(current.getRight(), data, current));

    }
    return current;

  }

  /**
   * inOrder traversing of the tree.
   *
   * @param root the root of the Tree we are traversing.
   *             Using recursion we traverse the tree to print it.
   */
  private void inOrder(HomogeneusNode root) {
    if (root != null) {
      inOrder(root.getLeft());
      System.out.printf("%d", root.getData());
      inOrder(root.getRight());
    }
  }

  /**
   * preOrder traversing of the tree.
   *
   * @param root the root of the Tree we are traversing.
   *             Using recursion we traverse the tree to print it.
   */
  private void preOrder(HomogeneusNode root) {

    if (root != null) {
      System.out.printf("%d", root.getData());
      preOrder(root.getLeft());
      preOrder(root.getRight());
    }
  }

  /**
   * postOrder traversing of the tree.
   *
   * @param root the root of the Tree we are traversing.
   *             Using recursion we traverse the tree to print it.
   */
  private void postOrder(HomogeneusNode root) {
    if (root != null) {
      postOrder(root.getLeft());
      postOrder(root.getRight());
      System.out.printf("%d", root.getData());
    }
  }

  /**
   * The public method we call so that the root of the tree stays hidden from the users.
   */
  public void preOrder() {
    preOrder(root);
  }

  /**
   * The public method we call so that the root of the tree stays hidden from the users.
   */
  public void postOrder() {
    postOrder(root);
  }

  /**
   * The public method we call so that the root of the tree stays hidden from the users.
   */
  public void inOrder() {
    inOrder(root);
  }
}

