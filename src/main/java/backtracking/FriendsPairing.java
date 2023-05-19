package backtracking;

//todo
public class FriendsPairing {
    public static void main(String[] args) {
        int friends = 3;

        boolean[] visited = new boolean[friends+1];
        pairFriends(friends, "",visited, 1);
    }

    private static void pairFriends(int friends, String op, boolean[] visited, int idx) {
        if(idx == friends+1){
            System.out.println(op);
            return;
        }
/*
        for(int i=0; i<friends.length(); i++){
            if(!visited[i]) {
                char c = friends.charAt(i);
                String s1 = friends.substring(i + 1);
                pairFriends(s1, );
            }
        }
*/
        /*String op1 = op;
        if(op.length()>0 && idx<=friends){
            op1 += "-"+idx;
        }*/
        if(!visited[idx]) {
            visited[idx] = true;
            pairFriends(friends, op.length() == 0 ? op + idx : op + "-" + idx, visited, idx + 1);
            pairFriends(friends, op + idx, visited, idx + 1);
            visited[idx] = false;
        }
    }
}
