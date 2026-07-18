class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> ans = new ArrayList<>();
        backtrack(ans, s, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(List<String> ans, String s, int index, StringBuilder str) {

        if (index == s.length()) {
            ans.add(str.toString());
            return;
        }

        char ch = s.charAt(index);

        if (Character.isDigit(ch)) {
            str.append(ch);
            backtrack(ans, s, index + 1, str);
            str.deleteCharAt(str.length() - 1);
        }

        else {
            str.append(Character.toLowerCase(ch));
            backtrack(ans, s, index + 1, str);
            str.deleteCharAt(str.length() - 1);

            str.append(Character.toUpperCase(ch));
            backtrack(ans, s, index + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}