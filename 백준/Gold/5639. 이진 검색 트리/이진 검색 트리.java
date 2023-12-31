import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    static String input;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(Files.newInputStream(Paths.get("src/input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()), null);

        while ((input = br.readLine()) != null){
            int data = Integer.parseInt(input);
            root.insert(root, data);
        }
        postOrder(root);
        System.out.println(ans);
        br.close();
    }

    static void postOrder(Node current){
        if(current == null) return;
        postOrder(current.left);
        postOrder(current.right);
        ans.append(current.data).append("\n");
    }
}

class Node{
    int data;
    Node parent;
    Node left;
    Node right;

    public Node(int data, Node parent) {
        this.data = data;
        this.parent = parent;
    }

    public void insert(Node current, int data){
        if(data < current.data){
            if (current.left == null) {
                current.left = new Node(data, current);
            } else{
                insert(current.left, data);
            }
        } else{
            if(current.right == null){
                current.right = new Node(data, current);
            } else{
                insert(current.right, data);
            }
        }
    }

}