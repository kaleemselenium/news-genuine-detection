package org.example.test.utility;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Class To Calculate The News Match Percentage
 */
@Component
public class NewsMatchPercentage {

    /**
     * Method to calculate the news match percentage
     * @param articleOne - Actual news article to verify
     * @param articleTwo - Search result news article to compare
     * @return - Match percentage
     */
    public int matchPercentage(String articleOne, String articleTwo) {
        Set<String> setOne = Arrays.stream(articleOne.split(" ")).map(String::toLowerCase).collect(Collectors.toSet());
        Set<String> setTwo = Arrays.stream(articleTwo.split(" ")).map(String::toLowerCase).collect(Collectors.toSet());

        AtomicInteger counter = new AtomicInteger();
        setOne.forEach(word -> {
            if (setTwo.contains(word)) {
                counter.incrementAndGet();
            }
        });

        return (int) ((float) counter.get() / (float) setOne.size() * 100);
    }
}
