package dynamicProgramming;

/*
there are n players and k teams. find out total ways the players can be placed in all the teams such that a team should
have atleast one player
 */
//todo
public class PlayersInTeam {
    public static void main(String[] args) {
        int players = 3;
        int teams = 2;

        String player = "123";
        placePlayersInTeams(teams, "", player);
    }

    private static void placePlayersInTeams(int teams, String op, String player) {
        if(player.length() == teams-1){
            System.out.println(op+"-"+player);
            return;
        }
        if(player.length()<teams){
            return;
        }

        for(int i=0; i<player.length(); i++){
            char c = player.charAt(0);
            String s1 = player.substring(1);

            placePlayersInTeams(teams, op+c, s1);
        }

//        placePlayersInTeams(teams, op+c, s1);
//        placePlayersInTeams(teams, op, s1);
    }
}
