class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k != 0) {
                stack.pop();
                k -= 1;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k -= 1;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String ans = sb.substring(idx);
        return ans.length() == 0 ? "0" : ans;
    }
}