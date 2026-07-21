class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Map<Integer, List<String>> memo = new HashMap<>();

        return dfs(s, wordDict, 0, memo);
    }

    private List<String> dfs(String s,
                             List<String> wordDict,
                             int idx,
                             Map<Integer, List<String>> memo) {

        // Already solved?
        if (memo.containsKey(idx))
            return memo.get(idx);

        List<String> ans = new ArrayList<>();

        // Reached end of string
        if (idx == s.length()) {
            ans.add("");
            return ans;
        }

        for (String word : wordDict) {

            if (!s.startsWith(word, idx))
                continue;

            List<String> next = dfs(s,
                                    wordDict,
                                    idx + word.length(),
                                    memo);

            for (String sentence : next) {

                if (sentence.isEmpty())
                    ans.add(word);
                else
                    ans.add(word + " " + sentence);
            }
        }

        memo.put(idx, ans);

        return ans;
    }
}