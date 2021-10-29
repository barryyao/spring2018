public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        if (word != null) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                result.addLast(chars[i]);
            }
        }
        return result;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque);
    }

    private boolean isPalindrome(Deque<Character> word) {
        if (word.isEmpty()) {
            return true;
        }
        Character first = word.removeFirst();
        Character last = word.removeLast();
        if (first.equals(last) || last == null) {
            return isPalindrome(word);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque, cc);
    }

    private boolean isPalindrome(Deque<Character> word, CharacterComparator cc) {
        if (word.isEmpty()) {
            return true;
        }
        Character first = word.removeFirst();
        Character last = word.removeLast();
        if (last == null || cc.equalChars(first, last)) {
            return isPalindrome(word, cc);
        }
        return false;
    }
}
