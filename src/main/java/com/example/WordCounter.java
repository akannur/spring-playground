package com.example;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Service
public class WordCounter {

    private final WordConfig wordConfig;

    public WordCounter(WordConfig wordConfig) {
        this.wordConfig = wordConfig;
    }

    public Map<String, Integer> countWords (String sentence) {
        Map<String, Integer> countMap = new HashMap<>();

        if( !this.wordConfig.isCaseSensitive() ) { sentence = sentence.toLowerCase(); }

        Arrays.stream(sentence.split(" "))
                .filter( s -> !wordConfig.getWords().getSkip().contains(s))
                .filter( s -> {
                    if (countMap.containsKey(s)) {
                        countMap.put(s, countMap.get(s) + 1);
                        return false;
                    } else {
                        return true;
                    }
                })
                .forEach( s -> countMap.put(s, 1) );

        return countMap;
    }

}