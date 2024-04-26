package Assignment_1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Maintest {
    public static void main(String[] args) {
        try {
            Tournament ipl = new Tournament(TournamentType.IPL, MatchFormat.T20);
            Team csk = new Team("Chennai Super Kings", "M. A. Chidambaram Stadium");
            Team mi = new Team("Mumbai Indians", "Wankhede Stadium");
            Team rr = new Team("Rajasthan Royals", "Sawai Mansingh Stadium");
            Team rcb = new Team("Royal Challengers Bangalore", "M. Chinnaswamy Stadium");

            // Adding players to teams - Chennai Super Kings
            csk.addPlayer(new Player("MS Dhoni", "Wicketkeeper", csk));
            csk.addPlayer(new Player("Suresh Raina", "Batsman", csk));
            csk.addPlayer(new Player("Ravindra Jadeja", "Allrounder", csk));
            csk.addPlayer(new Player("Ambati Rayudu", "Batsman", csk));
            csk.addPlayer(new Player("Deepak Chahar", "Bowler", csk));
            csk.addPlayer(new Player("Imran Tahir", "Bowler", csk));
            csk.addPlayer(new Player("Faf du Plessis", "Batsman", csk));
            csk.addPlayer(new Player("Shardul Thakur", "Bowler", csk));
            csk.addPlayer(new Player("Dwayne Bravo", "Allrounder", csk));
            csk.addPlayer(new Player("Moeen Ali", "Allrounder", csk));
            csk.addPlayer(new Player("Robin Uthappa", "Batsman", csk));
            csk.addPlayer(new Player("Krishnappa Gowtham", "Allrounder", csk));

            // Adding players to teams - Mumbai Indians
            mi.addPlayer(new Player("Rohit Sharma", "Batsman", mi));
            mi.addPlayer(new Player("Kieron Pollard", "Allrounder", mi));
            mi.addPlayer(new Player("Jasprit Bumrah", "Bowler", mi));
            mi.addPlayer(new Player("Quinton de Kock", "Wicketkeeper", mi));
            mi.addPlayer(new Player("Suryakumar Yadav", "Batsman", mi));
            mi.addPlayer(new Player("Hardik Pandya", "Allrounder", mi));
            mi.addPlayer(new Player("Krunal Pandya", "Allrounder", mi));
            mi.addPlayer(new Player("Trent Boult", "Bowler", mi));
            mi.addPlayer(new Player("Ishan Kishan", "Batsman", mi));
            mi.addPlayer(new Player("Rahul Chahar", "Bowler", mi));
            mi.addPlayer(new Player("Jayant Yadav", "Allrounder", mi));
            mi.addPlayer(new Player("Anukul Roy", "Bowler", mi));

            // Adding players to teams - Rajasthan Royals
            rr.addPlayer(new Player("Steve Smith", "Batsman", rr));
            rr.addPlayer(new Player("Ben Stokes", "Allrounder", rr));
            rr.addPlayer(new Player("Sanju Samson", "Wicketkeeper", rr));
            rr.addPlayer(new Player("Jos Buttler", "Batsman", rr));
            rr.addPlayer(new Player("Jofra Archer", "Allrounder", rr));
            rr.addPlayer(new Player("Rahul Tewatia", "Allrounder", rr));
            rr.addPlayer(new Player("Shreyas Gopal", "Bowler", rr));
            rr.addPlayer(new Player("Andrew Tye", "Bowler", rr));
            rr.addPlayer(new Player("Mayank Markande", "Bowler", rr));
            rr.addPlayer(new Player("Manan Vohra", "Batsman", rr));
            rr.addPlayer(new Player("Kartik Tyagi", "Bowler", rr));
            rr.addPlayer(new Player("David Miller", "Batsman", rr));

            // Adding players to teams - Royal Challengers Bangalore
            rcb.addPlayer(new Player("Virat Kohli", "Batsman", rcb));
            rcb.addPlayer(new Player("AB de Villiers", "Batsman", rcb));
            rcb.addPlayer(new Player("Glenn Maxwell", "Allrounder", rcb));
            rcb.addPlayer(new Player("Mohammed Siraj", "Bowler", rcb));
            rcb.addPlayer(new Player("Yuzvendra Chahal", "Bowler", rcb));
            rcb.addPlayer(new Player("Devdutt Padikkal", "Batsman", rcb));
            rcb.addPlayer(new Player("Daniel Sams", "Allrounder", rcb));
            rcb.addPlayer(new Player("Washington Sundar", "Allrounder", rcb));
            rcb.addPlayer(new Player("Navdeep Saini", "Bowler", rcb));
            rcb.addPlayer(new Player("Kyle Jamieson", "Allrounder", rcb));
            rcb.addPlayer(new Player("Sachin Baby", "Batsman", rcb));
            rcb.addPlayer(new Player("Shahbaz Ahmed", "Allrounder", rcb));

            // Adding teams to the tournament
            ipl.addTeam(csk);
            ipl.addTeam(mi);
            ipl.addTeam(rr);
            ipl.addTeam(rcb);

            // Simulating matches
            Match match1 = new Match(csk, mi, 200, 180);
            Match match2 = new Match(rr, rcb, 180, 185);
            Match match3 = new Match(mi, csk, 190, 195);
            Match match4 = new Match(csk, rcb, 185, 190);
            Match match5 = new Match(rr, rcb, 120, 121);

            
            
            // Update player scores based on realistic match data
            updatePlayerScores(match1, csk, mi);
            updatePlayerScores(match2, rr, rcb);
            updatePlayerScores(match3, mi, csk);
            updatePlayerScores(match4, csk, rcb);
            updatePlayerScores(match5, rr, rcb);

            // Add matches to the tournament
            ipl.addMatch(match1);
            ipl.addMatch(match2);
            ipl.addMatch(match3);
            ipl.addMatch(match4);
            ipl.addMatch(match5);

            // Displaying the scoreboard
            ipl.displayScoreBoard();

            // Handling queries directly in main
            Player highestWicketTaker = ipl.getHighestWicketTaker();
            if (highestWicketTaker != null) {
                System.out.println("\nHighest wicket taker: " + highestWicketTaker.getName() + " from " + highestWicketTaker.getTeam().getName() + " with " + highestWicketTaker.getStats().getWicketsTaken() + " wickets");
            }

            List<Player> topRunScorers = ipl.getTopRunScorers();
            if (!topRunScorers.isEmpty()) {
                Player topRunScorer = topRunScorers.get(0);
                System.out.println("\nTop run scorer: " + topRunScorer.getName() + " from " + topRunScorer.getTeam().getName() + " with " + topRunScorer.getStats().getRunsScored() + " runs");
            }

            // Finding the player with the most half-centuries
            Player mostHalfCenturiesPlayer = ipl.getTopRunScorers().stream()
                    .max(Comparator.comparingInt(player -> player.getStats().getHalfCenturies()))
                    .orElse(null);
            if (mostHalfCenturiesPlayer != null) {
                System.out.println("\nPlayer with most half-centuries: " + mostHalfCenturiesPlayer.getName() + " from " + mostHalfCenturiesPlayer.getTeam().getName() + " with " + (mostHalfCenturiesPlayer.getStats().getRunsScored()) / 50 + " half-centuries");
            }

            System.out.println("\nSemi Finalists: " + ipl.getSemiFinalists().stream().map(Team::getName).collect(Collectors.joining(", ")));

            System.out.println("\nTop Run Scorers: " + 
            	    ipl.getTopRunScorers().stream()
            	        .map(player -> player.getName() + " (" + player.getStats().getRunsScored() + " runs)")
            	        .collect(Collectors.joining(", ")));
            System.out.println("\nTournament Winner: " + ipl.getTournamentWinner().getName());
           
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
    
    // Method to update player scores based on match data
    private static void updatePlayerScores(Match match, Team team1, Team team2) {
        for (Player player : team1.getPlayers()) {
            if (match.getWinningTeam() == team1) {
                // Player belongs to the winning team
                if (player.getRole().equals("Batsman")) {
                    player.updateStats((int) (Math.random() * 100), 0); // Random runs scored
                } else if (player.getRole().equals("Bowler")) {
                    player.updateStats(0, (int) (Math.random() * 5)); // Random wickets taken
                }
            }
        }
        for (Player player : team2.getPlayers()) {
            if (match.getWinningTeam() == team2) {
                // Player belongs to the winning team
                if (player.getRole().equals("Batsman")) {
                    player.updateStats((int) (Math.random() * 100), 0); // Random runs scored
                } else if (player.getRole().equals("Bowler")) {
                    player.updateStats(0, (int) (Math.random() * 5)); // Random wickets taken
                }
            }
        }
    }
}