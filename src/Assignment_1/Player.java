package Assignment_1;

class Player {
    private String name;
    private PlayerStats stats;
    private String role;
    private Team team; // Reference to the Team object

    public Player(String name, String role, Team team) {
        this.name = name;
        this.stats = new PlayerStats();
        this.role = role;
        this.team = team; // Set the team reference
    }

    public void updateStats(int runs, int wickets) {
        stats.updateStats(runs, wickets);
    }

    public String getName() {
        return name;
    }

    public PlayerStats getStats() {
        return stats;
    }

    public String getRole() {
        return role;
    }

    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
    }
}
