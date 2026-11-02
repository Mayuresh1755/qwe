
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(Node left, Node right) {
            this.ch = '\0';
            this.freq = left.freq + right.freq;
            this.left = left;
            this.right = right;
        }
    }

    static void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] ch = new char[n];
        int[] freq = new int[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.freq, b.freq)
        );

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character: ");
            ch[i] = sc.next().charAt(0);

            System.out.print("Enter frequency: ");
            freq[i] = sc.nextInt();

            pq.add(new Node(ch[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left, right);
            pq.add(parent);
        }

        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");
        if (root != null && root.left == null && root.right == null) {
            System.out.println(root.ch + " : 0");
        } else {
            printCodes(root, "");
        }

        sc.close();
    }
}
