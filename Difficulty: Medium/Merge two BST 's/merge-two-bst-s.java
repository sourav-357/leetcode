/*
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> merge(Node root1, Node root2) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (root1 != null) {
            s1.push(root1);
            root1 = root1.left;
        }

        while (root2 != null) {
            s2.push(root2);
            root2 = root2.left;
        }

        while (!s1.isEmpty() || !s2.isEmpty()) {

            Stack<Node> currStack;

            if (s1.isEmpty())
                currStack = s2;
            else if (s2.isEmpty())
                currStack = s1;
            else if (s1.peek().data <= s2.peek().data)
                currStack = s1;
            else
                currStack = s2;

            Node node = currStack.pop();
            ans.add(node.data);

            node = node.right;

            while (node != null) {
                currStack.push(node);
                node = node.left;
            }
        }

        return ans;
    }
}