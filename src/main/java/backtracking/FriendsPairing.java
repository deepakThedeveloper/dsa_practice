package backtracking;

public class FriendsPairing {
    public static void main(String[] args){
        int n = 3;
        pairFriends(n, "", 1, new boolean[n+1]);
    }

    private static void pairFriends(int n, String op, int idx, boolean[] visited){
        if(idx > n){
            System.out.println(op);
            return;
        }
        if(visited[idx]){
            pairFriends(n, op, idx+1, visited);
        }
        else {
            visited[idx] = true;
            pairFriends(n, op + "(" + idx + ")", idx + 1, visited);
            for (int i = idx + 1; i <= n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                pairFriends(n, op + "(" + idx + i + ")", idx + 1, visited);
                visited[i] = false;
            }
            visited[idx] = false;
        }
    }
}
