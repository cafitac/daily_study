package com.example.LeaderBoard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    public static final String LEADERBOARD_KEY = "leaderBoard";
    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean setUserScore(String userId, int score) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.add(LEADERBOARD_KEY, userId, score);
    }

    public Long getUserRanking(String userId) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.reverseRank(LEADERBOARD_KEY, userId) + 1;
    }

    public List<String> getTopRank(int limit) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        final Set<String> rangeSet = zSetOperations.reverseRange(LEADERBOARD_KEY, 0, limit - 1);
        return new ArrayList<>(rangeSet);
    }
}
