package Assignment_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Tournament {
    private TournamentType tournamentType;
    private MatchFormat matchFormat;
    private List<Team> teams = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();
    private Map<Team, Integer> teamPoints = new HashMap<>();

    public Tournament(TournamentType tournamentType, MatchFormat matchFormat) {
        this.tournamentType = tournamentType;
        this.matchFormat = matchFormat;
    }

    public void addTeam(Team team) {
        teams.add(team);
        teamPoints.put(team, 0); // Initialize points
    }

    public void addMatch(Match match) {
        matches.add(match);
        Team winningTeam = match.getWinningTeam();
        teamPoints.put(winningTeam, teamPoints.getOrDefault(winningTeam, 0) + 2); // Assuming 2 points for a win
    }

    public List<Team> getSemiFinalists() {
    	
        return teams.stream()
                .sorted((team1, team2) -> teamPoints.get(team2).compareTo(teamPoints.get(team1)))
                .limit(2)
                .collect(Collectors.toList());
        
    }

    public List<Player> getTopRunScorers() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .sorted((player1, player2) -> player2.getStats().getRunsScored() - player1.getStats().getRunsScored())
                .limit(5)
                .collect(Collectors.toList());
    }

    public Team getTournamentWinner() {
        return Collections.max(teamPoints.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Player getHighestWicketTaker() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .max(Comparator.comparingInt(player -> player.getStats().getWicketsTaken()))
                .orElse(null);
    }

    public Player getPlayerByName(String name) {
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (player.getName().equalsIgnoreCase(name)) {
                    return player;
                }
            }
        }
        return null;
    }
    
   
 // Generic method to display top players
    public static <T> void displayTopPlayers(List<T> players, Comparator<T> comparator, Function<T, String> displayFunction, int limit) {
        players.stream()
                .sorted(comparator)
                .limit(limit)
                .forEach(player -> System.out.println(displayFunction.apply(player)));
    }
    
    public List<Match> getMatches() {
        return matches;
    }
    
    public void displayScoreBoard() {
        System.out.println("Scoreboard:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s %-7s %-20s %-15s %s\n", "Team 1", "Score", "Team 2", "Winner", "Team 1 : Team 2 Points");
        System.out.println("-------------------------------------------------");
        for (Match match : matches) {
            String winner = match.getWinningTeam().getName();
            Integer team1Points = teamPoints.getOrDefault(match.getTeam1(), 0);
            Integer team2Points = teamPoints.getOrDefault(match.getTeam2(), 0);
            System.out.printf("%-20s %-7d %-20s %-15s %d : %d\n", 
                              match.getTeam1().getName(), match.getTeam1Runs(), 
                              match.getTeam2().getName(), winner, team1Points, team2Points);
        }
        System.out.println("-------------------------------------------------");
        
        // Display teams and their points in descending order
        System.out.println("Team Standings:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s %s\n", "Team", "Points");
        System.out.println("-------------------------------------------------");
        teamPoints.entrySet().stream()
            .sorted(Map.Entry.<Team, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.printf("%-20s %d\n", entry.getKey().getName(), entry.getValue()));
        System.out.println("-------------------------------------------------");
    }
    
}