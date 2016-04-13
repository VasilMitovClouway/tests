public void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        else if (check(value) == true) {

            System.out.println(value + " already exist in the tree.");
        }
        else {
            add(root, node);
        }
    }

    private void add(Node lastRoot, Node node) {
        //check left
        if (lastRoot.value > node.value) {
            //check if left is free
            if (lastRoot.left == null) {
                lastRoot.left = node;
                return;
            }
            //recursion
            else {
                add(lastRoot.left, node);
            }
        }
        //check right
        else {
            //check if right is free
            if (lastRoot.right == null) {
                lastRoot.right = node;
                return;
            }
            //recursion if it is not free
            else {
                add(lastRoot.right, node);
            }
        }
    }