import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;


class BestTrio {

    /*
     * Complete the 'bestTrio' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts UNWEIGHTED_INTEGER_GRAPH friends as parameter.
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */
    public static int bestTrio(int friendsNodes, List<Integer> friendsFrom, List<Integer> friendsTo) {
        final Map<Integer, Set<Integer>> nodeToFriends = new HashMap<>();

        for (int i = 0; i < friendsFrom.size(); i++) {
            Integer friendFrom = friendsFrom.get(i);
            Integer friendTo = friendsTo.get(i);

            nodeToFriends.compute(friendFrom, (key, val) -> {
                if (val == null) {
                    val = new HashSet<>();
                }
                val.add(friendTo);
                return val;
            });

            nodeToFriends.compute(friendTo, (key, val) -> {
                if (val == null) {
                    val = new HashSet<>();
                }
                val.add(friendFrom);
                return val;
            });
        }

        final Set<Set<Integer>> trios = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : nodeToFriends.entrySet()) {
            Integer node = entry.getKey();
            Set<Integer> friends = entry.getValue();
            for (Integer friend : friends) {
                Set<Integer> friendFriends = nodeToFriends.get(friend);
                for (Integer friendFriend : friendFriends) {
                    if (nodeToFriends.get(friendFriend).contains(node)) {
                        Set<Integer> trio = Arrays.asList(node, friend, friendFriend).stream()
                                .collect(Collectors.toSet());
                        trios.add(trio);
                    }
                }
            }
        }

        if (trios.isEmpty()) {
            return -1;
        }

        final List<Integer> results = new ArrayList<>();
        for (Set<Integer> trio : trios) {
            int outsideFriends = 0;
            for (Integer node : trio) {
                outsideFriends += nodeToFriends.get(node).size() - 2;
            }
            results.add(outsideFriends);
        }

        return Collections.min(results);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter = null;
        if (fileName != null) {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String[] friendsNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int friendsNodes = Integer.parseInt(friendsNodesEdges[0]);
        int friendsEdges = Integer.parseInt(friendsNodesEdges[1]);

        List<Integer> friendsFrom = new ArrayList<>();
        List<Integer> friendsTo = new ArrayList<>();

        IntStream.range(0, friendsEdges).forEach(i -> {
            try {
                String[] friendsFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                friendsFrom.add(Integer.parseInt(friendsFromTo[0]));
                friendsTo.add(Integer.parseInt(friendsFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = BestTrio.bestTrio(friendsNodes, friendsFrom, friendsTo);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
