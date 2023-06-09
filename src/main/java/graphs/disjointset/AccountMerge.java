package graphs.disjointset;

import graphs.disjointset.DisjointSet;
import javafx.util.Pair;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        List<Pair<String, List<String>>> accountMap = getAccountMap();
        Map<String, List<String>> mergedMap = mergeAccounts(accountMap);
        System.out.println(mergedMap);
    }

    // todo: logic is set, just need to code on Pair. previously used map, but as input changed from map to pair,
    // need to change code. will change it later
    private static Map<String, List<String>> mergeAccounts(List<Pair<String, List<String>>> accountInfo){
        Map<String, Integer> accountNameNumber = new HashMap<>();
        Map<Integer, String> accountNumberName = new HashMap<>();
        int i=0;
        for(Pair<String, List<String>> pair : accountInfo){
            accountNameNumber.put(pair.getKey(), i);
            accountNumberName.put(i, pair.getKey());
            i++;
        }

        DisjointSet set = new DisjointSet(accountInfo.size());
        Map<String, Integer> emailAccountNo = new HashMap<>();
        for(Pair<String, List<String>> mp : accountInfo){
            int v = accountNameNumber.get(mp.getKey());
            for(String email : mp.getValue()){
                if(emailAccountNo.containsKey(email)){
                    set.unionByRank(emailAccountNo.get(email), v);
                }
                else {
                    emailAccountNo.put(email, v);
                }
            }
        }

//        List<Pair<String, List<String>>> result = new ArrayList<>();
//        for(Map.Entry<String, Integer> mp : emailAccountNo.entrySet()){
//            int parent = set.findUParent(mp.getValue());
//            String account = accountNumberName.get(parent);
//            if(result.containsKey(account)){
//                result.get(account).add(mp.getKey());
//            }
//            else {
//                List<String> emails = new ArrayList<>();
//                emails.add(mp.getKey());
//                result.put(account, emails);
//            }
//        }
//        return result;

        return null;
    }

    private static List<Pair<String, List<String>>> getAccountMap() {
        List<Pair<String, List<String>>> accountMap = new ArrayList<>();
        accountMap.add(new Pair<>("John", Arrays.asList("j1@com", "j2@com", "j3@com")));
        accountMap.add(new Pair<>("John", Arrays.asList("j4@com")));
        accountMap.add(new Pair<>("Raj", Arrays.asList("r1@com", "r2@com")));
        accountMap.add(new Pair<>("Raj", Arrays.asList("r1@com", "r4@com")));
        accountMap.add(new Pair<>("John", Arrays.asList("j1@com", "j5@com")));
        accountMap.add(new Pair<>("Marry", Arrays.asList("m1@com")));

        return accountMap;
    }
}
