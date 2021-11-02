public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> S = new ArrayDeque<>();
        for (int i=0; i < word.length(); i++) {
            S.addLast(word.charAt(i));
        }
        return S;
    }

    public boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length()-1;
        for (; start <= end; start++, end--) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int start = 0;
        int end = word.length()-1;
        for (; start < end; start++, end--) {
            if (!cc.equalChars(word.charAt(start), word.charAt(end))) {
                return false;
            }
        }
        return true;
    }
}
