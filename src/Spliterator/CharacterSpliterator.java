package Spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class CharacterSpliterator implements Spliterator<Character> {
    private final String string;
    private int curIdx;

    public CharacterSpliterator(String string) {
        this.string = string;
        this.curIdx = 0;
    }


    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        if (curIdx < string.length()) {
            action.accept(string.charAt(curIdx++));
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Character> trySplit() {
        int curSize = string.length() - curIdx;

        if (curSize < 2) return null;

        int splitIdx = curIdx + curSize / 2;
        String leftPart = string.substring(curIdx, splitIdx);
        curIdx = splitIdx;

        return new CharacterSpliterator(leftPart);
    }

    @Override
    public long estimateSize() {
        return string.length() - curIdx;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}
