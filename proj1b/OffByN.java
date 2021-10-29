public class OffByN implements CharacterComparator {
    private int N = 0;
    public OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (checkIfNoneAlphabetical(x) || checkIfNoneAlphabetical(y)) {
            throw new Error();
        }
        return x - y == N || y - x == N;
    }

    private boolean checkIfNoneAlphabetical(char a) {
        return a > 'z' || a > 'Z' && a < 'a' || a < 'A';
    }
}
