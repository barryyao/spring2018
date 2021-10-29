public class OffByN implements CharacterComparator {
    private int N = 0;
    public OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (x < 'a' || x > 'z' || y < 'a' || y > 'z') {
            throw new Error();
        }
        return x - y == N || y - x == N;
    }
}
