package Assignment_1;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String name;
    private List<Player> players = new ArrayList<>();
    private String homeGround;

    public Team(String name, String homeGround) {
        this.name = name;
        this.homeGround = homeGround;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this); // Use the setter method instead of direct access
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getHomeGround() {
        return homeGround;
    }
}