package com.algo2prepare.leetcode;

import java.util.*;

public class _1244_Design_A_Leaderboard {

    static class Leaderboard {

        private TreeMap<Integer, Integer> scoreCounterMap;
        private Map<Integer, Integer> playerIdScoreMap;


        public Leaderboard() {
            scoreCounterMap = new TreeMap<>(Collections.reverseOrder());
            playerIdScoreMap = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            if (playerIdScoreMap.containsKey(playerId)) {
                int oldScore = playerIdScoreMap.get(playerId);
                int newScore = oldScore + score;

                // Remove the old score from the map
                scoreCounterMap.put(oldScore, scoreCounterMap.get(oldScore) - 1);
                scoreCounterMap.put(newScore, scoreCounterMap.getOrDefault(newScore, 0) + 1);
                playerIdScoreMap.put(playerId, newScore);
            } else {
                playerIdScoreMap.put(playerId, score);
                scoreCounterMap.put(score, scoreCounterMap.getOrDefault(score, 0) + 1);
            }
        }

        public int top(int K) {
            Set<Integer> scores = scoreCounterMap.keySet();
            int sum = 0;
            int countK = 0;
            for (int score : scores) {
                int countScore = scoreCounterMap.get(score);
                while (countK < K && countScore > 0) {
                    sum += score;
                    countK++;
                    countScore--;
                }
                if (countK >= K) {
                    break;
                }
            }

            return sum;
        }

        public void reset(int playerId) {
            if (playerIdScoreMap.containsKey(playerId)) {
                int score = playerIdScoreMap.get(playerId);
                playerIdScoreMap.remove(playerId);
                int count = scoreCounterMap.get(score);
                if (count == 1) {
                    scoreCounterMap.remove(score);
                } else {
                    scoreCounterMap.put(score, count - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }

}


