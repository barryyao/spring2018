public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if (x < 'a' || x > 'z' || y < 'a' || y > 'z') {
            throw new Error();
        }
        return x - y == 1 || y - x == 1;
    }
}
