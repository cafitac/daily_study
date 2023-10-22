package com.example.LeaderBoard;

import com.example.LeaderBoard.service.RankingService;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.DoubleStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private RankingService rankingService;

    @Test
    void getRanks() {
        rankingService.getTopRank(1);

        Instant before = Instant.now();
        final Long userRank = rankingService.getUserRanking("user_100");
        Duration elapsed = Duration.between(before, Instant.now());
        System.out.printf("Rank(%d) - Took %d ms%n", userRank, elapsed.getNano() / 1000000);

        before = Instant.now();
        final List<String> topRankers = rankingService.getTopRank(10);
        elapsed = Duration.between(before, Instant.now());

        System.out.printf("Range - Took %d ms%n", elapsed.getNano() / 1000000);
    }

    @Test
    void insertScore() {
        final ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<1000000; i++) {
            int score = (int) (Math.random() * 1000000);
            final String userId = "user_" + i;

            rankingService.setUserScore(userId, score);
        }
    }

    @Test
    void inMemorySortPerformance() {
        final TreeSet<Integer> set = new TreeSet<>();
        final ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<1000000; i++) {
            int score = (int) (Math.random() * 1000000);
            set.add(score);
        }

        final Instant before = Instant.now();
        final Iterator<Integer> iterator = set.iterator();
        final SortedSet<Integer> integers = set.subSet(0, 10);
//        Collections.sort(list); // nlongn
        final Duration elapsed = Duration.between(before, Instant.now());
        for (int i=0; i<10; i++) {
            System.out.println(iterator.next());
        }
        System.out.println(integers);
        System.out.println(elapsed.getNano() / 1000000 + " ms");
    }
}
