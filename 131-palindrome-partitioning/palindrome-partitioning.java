class Solution {
    List<List<String>> list;

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        this.list = list;
        List<String> li = new ArrayList<>();
        solve(li, 0, s);
        return list;
    }

    public boolean palindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void solve(List<String> li, int start, String s) {
        if (start == s.length()) {
            list.add(new ArrayList<>(li));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!palindrome(s, start, i))
                continue;
            li.add(s.substring(start, i + 1));
            solve(li, i + 1, s);
            li.remove(li.size() - 1);
        }
    }
}