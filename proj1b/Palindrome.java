public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> S = new ArrayDeque<>();
        for (int i=0; i < word.length(); i++) {
            S.addLast(word.charAt(i));
        }
        return S;
    }
}
