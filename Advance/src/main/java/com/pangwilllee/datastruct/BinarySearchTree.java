package com.pangwilllee.datastruct;

public class BinarySearchTree<K extends Comparable<K>, V> {
    private class Node {
        private K key; // 存储的key
        private V value; // 存储的值
        private Node leftNode; // 左节点
        private Node rightNode; // 右节点

        public Node(K key, V value, Node leftNode, Node rightNode) {
            super();
            this.key = key;
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "{\"key\":" + this.key + ", \"value\":" + "\"" + this.value + "\"" + ", \"leftNode\":"
                    + this.leftNode + ", \"rightNode\":" + this.rightNode + "}";
        }
    }

    private Node root; // 根节点

    /**
     * 插入新的节点，如果指定的key已经存在，则更新原来的值
     * 
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node newNode = new Node(key, value, null, null);
        if (null == root) {// 如果根节点为null
            root = newNode;// 则将新的节点赋值给根节点
        } else {// 如果根节点不为空，则进行插入
            upsert(null, root, newNode);
        }
    }

    private void upsert(Node parent, Node current, Node newNode) {
        if (null == current) {// 如果当前节点为空
            if (newNode.key.compareTo(parent.key) > 0) {// 如果新增节点的key值大于父节点的key值，则把新节点设置为父节点的右子节点
                parent.rightNode = newNode;
            } else {// 如果新增节点的key值小于父节点的key值，则把新节点设置为父节点的左子节点
                parent.leftNode = newNode;
            }
        } else {// 如果当前节点不为空
            int result = newNode.key.compareTo(current.key);// 对比两个节点的key值
            if (result == 0) {// 如果相当，则进行更新value操作
                current.value = newNode.value;
            }
            parent = current;
            if (result > 0) {
                upsert(parent, parent.rightNode, newNode);
            }
            if (result < 0) {
                upsert(parent, parent.leftNode, newNode);
            }
        }
    }

    /**
     * 根据 key 来获取指定的节点
     * 
     * @param key
     * @return
     */
    public Node get(K key) {
        if (null != key) {
            return find(key, root); // 从根节点开始找
        }
        return null;
    }

    private Node find(K key, Node root) {
        if (null != root) {
            int result = key.compareTo(root.key);
            if (result == 0) {
                return root;
            }
            if (result > 0) {
                return find(key, root.rightNode);
            }
            if (result < 0) {
                return find(key, root.leftNode);
            }
        }
        return null;
    }

    /**
     * 需要考虑以下3中情况
     * 
     * 3.
     * 
     * @param key
     * @return
     */
    public boolean delete(K key) {
        if (null != key) {
            if (null != root) {
                return deleteNode(key, root, null);
            }
        }
        return false;
    }

    private boolean deleteNode(K key, Node current, Node parent) {
        if (null != current) {
            if (key.compareTo(current.key) > 0) {
                return deleteNode(key, current.rightNode, current);
            }
            if (key.compareTo(current.key) < 0) {
                return deleteNode(key, current.leftNode, current);
            }
            if (key.compareTo(current.key) == 0) {
                // 将要删除的节点下有两个子节点:在将要被删除的节点的右子树中找到一个最小节点然后，用找到的最小节点与需要删除的节点替换，最后再将最小节点进行删除
                if ((null != current.leftNode) && (null != current.rightNode)) {
                    delTwoChildrenNode(current);
                    return true;
                } else if ((null == current.leftNode) && (null == current.rightNode)) {// 将要删除的节点没有子节点:直接删除
                    if (current.key.compareTo(parent.key) > 0) {
                        parent.rightNode = null;
                    } else {
                        parent.leftNode = null;
                    }
                    return true;
                } else { // 将要删除的节点下有一个子节点:将要被删除的节点的子节点挂靠到将要被删除的节点的父节点上即可
                    Node childNode = (null == current.leftNode) ? current.rightNode : current.leftNode;
                    if (current.key.compareTo(parent.key) > 0) {//判断当前节点是父节点的左节点还是右节点
                        parent.rightNode = childNode;
                    } else {
                        parent.leftNode = childNode;
                    }
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * 处理被删除节点有两个子节点的情况
     * 
     * @param parent
     *            将要被删除的节点
     */
    private void delTwoChildrenNode(Node parent) {
        Node parentRight = parent.rightNode;//右子树
        Node tmp = parentRight.leftNode;//右子树的左子树
        if (null == tmp) {
            parent.value = parentRight.value;
            parent.key = parentRight.key;
            parent.rightNode = parentRight.rightNode;
        } else {
            Node tmpParent = parentRight;
            while (null != tmp.leftNode) {
                tmpParent = tmp;
                tmp = tmp.leftNode;
            }
            parent.value = tmp.value;
            parent.key = tmp.key;
            tmpParent.leftNode = tmp.rightNode;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
        bst.put(100, "v100");
        bst.put(50, "v50");
        bst.put(150, "v150");
        bst.put(20, "v20");
        bst.put(85, "v85");
        bst.put(10, "v10");
        bst.put(15, "a15");
        bst.put(75, "v75");
        bst.put(95, "v95");
        bst.put(65, "v65");
        bst.put(76, "v76");
        bst.put(60, "v60");
        bst.put(66, "v66");
        bst.put(61, "v61");
        System.out.println(bst.get(100));// 打印根节点
    }
}
