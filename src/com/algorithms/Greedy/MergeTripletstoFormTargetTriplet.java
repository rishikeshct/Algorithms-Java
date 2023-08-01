package Greedy;

import java.util.ArrayList;
import java.util.List;

public class MergeTripletstoFormTargetTriplet {
    public static void main(String[] args) {
        int[][] triplets = {{1,3,1}};

        int[] target = {1,3,1};

        System.out.println(MergeTripletstoFormTargetTripletFunc(triplets, target));

        System.out.println(mergeTriplets(triplets, target));
    }



    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false;
        boolean y = false;
        boolean z = false;

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                x = true;
                break;
            }
        }

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] == target[1] && triplets[i][2] <= target[2]) {
                y = true;
                break;
            }
        }

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] == target[2]) {
                z = true;
                break;
            }
        }

        if (x == true && y == true && z == true) {
            return true;
        }

        return false;
    }
    private static boolean MergeTripletstoFormTargetTripletFunc(int[][] triplets, int[] target) {

       List<List<Integer>> list =  convertToList(triplets);
        List<List<Integer>> remove = new ArrayList<>();
       boolean a = false,b = false,c = false;
       for (int i = 0; i < triplets.length; i++) {
           for (int j = 0; j < triplets[0].length; j++) {
               if (j == 0) {
                   if (list.get(i).get(j) > target[0]) {
                       remove.add(list.get(i));
                   }
               }
               if (j == 1) {
                   if (list.get(i).get(j) > target[1]) {
                       remove.add(list.get(i));
                   }
               }
               if (j == 2) {
                   if (list.get(i).get(j) > target[2]) {
                       remove.add(list.get(i));
                   }
               }
           }
       }



       list.removeAll(remove);


        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                if (j == 0) {
                if (list.get(i).get(j) == target[0]) {
                        a =true;
                    }
                }
                if (j == 1) {
                  if (list.get(i).get(j) == target[1]) {
                        b = true;
                    }
                }
                if (j == 2) {
                    if (list.get(i).get(j) == target[2]) {
                        c = true;
                    }
                }
            }
        }
        return a && b && c;
    }

    public static List<List<Integer>> convertToList(int[][] array) {
        List<List<Integer>> result = new ArrayList<>();

        for (int[] row : array) {
            List<Integer> sublist = new ArrayList<>();
            for (int element : row) {
                sublist.add(element);
            }
            result.add(sublist);
        }

        return result;
    }
}
