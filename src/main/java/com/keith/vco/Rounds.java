package com.keith.vco;

import java.util.ArrayList;

/**
 * Created by Development on 11/26/2016.
 */
@SuppressWarnings("WeakerAccess")
public class Rounds {
    private static Rounds INSTANCE;
    private int defaultNumOfRounds = 10;
    private ArrayList<RoundInfo> rounds;

    public static Rounds getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new Rounds();
        INSTANCE.setNumOfRounds(INSTANCE.defaultNumOfRounds);
        return INSTANCE;
    }

    public void setNumOfRounds(int i) {
        rounds = null;
        rounds = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            rounds.add(new RoundInfo(i1, 0));
        }
    }

    public ArrayList<RoundInfo> getRounds() {
        return rounds;
    }

    public void join(int id) {
        //noinspection OptionalGetWithoutIsPresent
        rounds.stream().filter(roundInfo -> roundInfo.id == id).findFirst().get().join();
    }
}
