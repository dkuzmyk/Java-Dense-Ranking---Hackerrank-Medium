package DenseRanking;
import java.util.*;

class DenseRanking {

    public static void main(String[] args){
        List<Integer> ar = new ArrayList<>(Arrays.asList(100,100,50,40,40,20,10));
        List<Integer> ar2 = new ArrayList<>(Arrays.asList(5,25,50,120));

        System.out.println(Arrays.toString(climbingLeaderboard(ar, ar2).toArray()));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        //Vector<Integer> vec = new Vector<>();
        ArrayList<Integer> vec = new ArrayList<>();

        // figure out the positions
        int positions = ranked.size();
        int []rank = new int[positions];

        int[] ret = new int[positions];

        rank[0] = 1;
        int current=1;

        for(int q = 1; q < positions; q++){
            if(ranked.get(q-1) > ranked.get(q)){
                current++;
            }
            rank[q] = current;
        }

        System.out.println(Arrays.toString(rank));
        int j = positions-1;
        for (int i = 0; i < player.size(); i++) {
            current = 1;
            while(j > -1){
                System.out.println("comparing: "+player.get(i)+"<="+ranked.get(j));
                if(player.get(i) < ranked.get(j)){
                    if(j == positions-1)
                        current = rank[positions-1]+1;
                    else
                        current = rank[j]+1;
                    break;
                }
                else if(player.get(i).equals(ranked.get(j))){
                    current = rank[j];
                    break;
                }
                else
                    j--;
            }
            System.out.println(" current "+current);
            vec.add(current);
        }

        return vec;
    }

}
