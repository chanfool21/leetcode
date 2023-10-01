package DailyChallenges;
import java.util.*;

public class GroupPeopleGivenTheGroupTheyBelong {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groudSizeToPeopleMap = new HashMap<>();

        for(int i = 0; i < groupSizes.length; i++) {
            if(groudSizeToPeopleMap.containsKey(groupSizes[i])) {
                groudSizeToPeopleMap.get(groupSizes[i]).add(i);
            } else {
                List<Integer> peopleIds = new ArrayList<>();
                peopleIds.add(i);
                groudSizeToPeopleMap.put(groupSizes[i], peopleIds);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: groudSizeToPeopleMap.entrySet()) {
            int groupSize = entry.getKey();
            List<Integer> people = entry.getValue();
            int i = 0;
            while(i < people.size()) {

                List<Integer> temp = new ArrayList<>();
                for(int j = i; j < i+groupSize; j++) {
                    temp.add(people.get(j));
                }
                result.add(temp);
                i+=groupSize;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        new GroupPeopleGivenTheGroupTheyBelong().groupThePeople(new int[] {3,3,3,3,3,1,3});
    }
}
