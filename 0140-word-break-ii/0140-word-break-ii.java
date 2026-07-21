class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> ans = new ArrayList<>();
        backtrack(s, wordDict, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, List<String> wordDict,int idx,
                           List<String> path, List<String> ans) {

        if (idx == s.length()) {
            ans.add(String.join(" ", path));
            return;
        }

        for (String word : wordDict) {

            if (!matches(s, word, idx))
                continue;

            path.add(word);
            backtrack(s, wordDict, idx + word.length(), path, ans);
            path.remove(path.size() - 1);
        }
    }

    private boolean matches(String s, String word, int idx) {

        if (idx + word.length() > s.length())
            return false;

        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(idx + i) != word.charAt(i))
                return false;
        }

        return true;
    }
}