package Assignment_1;

class PlayerStats {
    private int runsScored;
    private int wicketsTaken;
    private int halfCenturies;

    public void updateStats(int runs, int wickets) {
        this.runsScored += runs;
        this.wicketsTaken += wickets;
        if (runs > 50 ) {
            halfCenturies++;
        }
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public int getHalfCenturies() {
        return halfCenturies;
    }
}