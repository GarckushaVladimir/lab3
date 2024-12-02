package Spliterator;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorMain {
    public static void main(String[] args) {
        String inputString = "Hello, World!";

        Stream<Character> characterStream = StreamSupport.stream(new CharacterSpliterator(inputString), true);

        Map<Character, Long> map = characterStream
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .collect(Collectors.groupingBy(
                        c -> c, Collectors.counting()
                ));

        map.forEach((ch, count) -> System.out.println(ch + ":" + count));
    }
}