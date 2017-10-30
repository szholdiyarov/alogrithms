package sorting;

/**
 * Created by szholdiyarov on 10/26/17.
 */
public class NumberOfDiscIntersections {

    static class Node {
        String title;
        Node next;

        public Node(String title, Node next) {
            this.title = title;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Node D = new Node("D", null);
        Node C = new Node("C", D);
        Node B = new Node("B", C);
        Node A = new Node("A", B);


    }

    private static void reverse(Node lastNode) {


    }
}
