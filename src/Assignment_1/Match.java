package Assignment_1;

class Match {
    private Team team1;
    private Team team2;
    private int team1Runs;
    private int team2Runs;

    // Existing constructor and methods...

    public Match(Team team1, Team team2, int team1Runs, int team2Runs) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Runs = team1Runs;
        this.team2Runs = team2Runs;
    }

    // Method to get the first team
    public Team getTeam1() {
        return team1;
    }

    // Method to get the runs scored by the first team
    public int getTeam1Runs() {
        return team1Runs;
    }

    // Method to get the second team
    public Team getTeam2() {
        return team2;
    }

    // Method to get the runs scored by the second team
    public int getTeam2Runs() {
        return team2Runs;
    }

    // Existing method to get the winning team
    public Team getWinningTeam() {
        return team1Runs > team2Runs ? team1 : team2;
    }
    
    
}