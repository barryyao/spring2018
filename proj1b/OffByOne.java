public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if (checkIfNoneAlphabetical(x) || checkIfNoneAlphabetical(y)) {
            throw new Error();
        }
        return x - y == 1 || y - x == 1;
    }

    private boolean checkIfNoneAlphabetical(char a) {
        return a > 'z' || a > 'Z' && a < 'a' || a < 'A';
    }
}
