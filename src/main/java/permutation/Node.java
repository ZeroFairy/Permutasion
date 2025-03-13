/**
* Author by Jordan Vincent
* Universitas Sanata Dharma
*/
package permutation;

public class Node {
    private static final Object DATA = null;

    private String label;
    private Node left, right;   //Masih dalam pertimbangan apakah dibutuhkan???
    private Object data;

    private Node(String label) {
        this.label = label;
        this.left = null;
        this.right = null;
    }

    private Node(String label, Object data) {
        this(label);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
