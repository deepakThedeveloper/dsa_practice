package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MInDevelopersNeeded {
    public static void main(String[] args) {
        List<List<String>> skills = Arrays.asList(
                Arrays.asList("c", "e"),
                Arrays.asList("a", "b"),
                Arrays.asList("b","c","d","e"));

        int dev = 3;
        int ski = 5;

        minDevNormalApproach(dev, 0, ski, skills, new HashSet<>());
        System.out.println(min);
//        int minDev1 = minDev1(dev, 0, ski, 0, skills, new HashSet<>());
//        System.out.println(minDev1);
    }

    static int min = Integer.MAX_VALUE;
    private static void minDevNormalApproach(int dev, int count, int ski, List<List<String>> skills, Set<String> skillSoFar){
        if(skillSoFar.size() == ski){
            min = Math.min(min, count);
            return;
        }
        if(dev == 0){
            return;
        }
        List<String> skill = skills.get(dev-1);
        skillSoFar.addAll(skill);
        minDevNormalApproach(dev-1, count+1, ski, skills, skillSoFar);
        for(String sk : skill){
            skillSoFar.remove(sk);
        }
        minDevNormalApproach(dev-1, count, ski, skills, skillSoFar);
    }

    //not working: todo
    private static int minDev(int dev, int ski, List<List<String>> skills, Set<String> skillSoFar){
        if(ski==0) return 1;
        if(dev == 0){
            if(ski>0){
                List<String> skill = skills.get(0);
                int count = ski;
                for(String sk : skill){
                    if(!skillSoFar.contains(sk)){
                        count--;
                    }
                }
                if(count == 0) return 1;
            }
            return Integer.MAX_VALUE;
        }

        int notTake = minDev(dev-1, ski, skills, skillSoFar);
        int take = Integer.MAX_VALUE;
        if(ski>0){
            List<String> skill = skills.get(dev);
            int count = ski;
            for(String sk : skill){
                if(!skillSoFar.contains(sk)){
                    skillSoFar.add(sk);
                    count--;
                }
            }
            take = 1 + minDev(dev-1, count, skills, skillSoFar);
            for(String sk : skill){
                skillSoFar.remove(sk);
            }
        }
        return Math.min(take, notTake);
    }

    //not working: todo
    private static int minDev1(int dev, int idx, int ski, int idx1, List<List<String>> skills, Set<String> skillSoFar){
        if(ski==idx1) return 1;
        if(dev == idx) return 0;

        int notTake = minDev1(dev, idx+1, ski, idx1, skills, skillSoFar);
        int take = Integer.MAX_VALUE;
        if(ski>0){
            List<String> skill = skills.get(idx);
            int count = idx1;
            for(String sk : skill){
                if(!skillSoFar.contains(sk)){
                    skillSoFar.add(sk);
                    count++;
                }
            }
            take = 1 + minDev1(dev, idx+1, ski, count, skills, skillSoFar);
            for(String sk : skill){
                skillSoFar.remove(sk);
            }
        }
        return Math.min(take, notTake);
    }
}
