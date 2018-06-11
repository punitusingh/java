package algorithm;

import java.util.ArrayList;

public class Permutation {

    private static String swapStrElements(int i, int j, char[] arr){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

        return String.valueOf(arr);
    }

    private static void findPermutationThroughListIteration(String s) {
        ArrayList<String> list = new ArrayList<>();
        int counter=0;
        int listLength;
        list.add(s);
        for (int loopString = 0; loopString < s.length()-1; loopString++) {
                listLength = list.size();
                for(int j=loopString+1; j<s.length(); j++){
                    for(int loopList=0;loopList<listLength;loopList++){
                        String name1 = swapStrElements(loopString, j, list.get(loopList).toCharArray());
                        list.add(name1);
                       counter++;
                    }
                }
        }

        System.out.println(list);
        System.out.println(list.size());
        System.out.println("counter is "+counter);
    }


    private static void findPermutationThroughListIteration1(String s) {
        ArrayList<String> list = new ArrayList<>();
        int counter=0;
        int listLength;
        int length = s.length()-1;
        for (int i = 0; i < length; i++) {
            if (list.isEmpty()) {
                for (int j = 0; j < s.length(); j++) {
                    String name1 = swapStrElements(i, j, s.toCharArray());
                    list.add(name1);
                    System.out.println(name1);
                    counter++;
                }
            } else {
                listLength = list.size();
                for(int m = i; m <= length - 1; m++) {
                    for (int k = 0; k < listLength; k++) {
                        String name1 = swapStrElements(m, m + 1, list.get(k).toCharArray());
                        list.add(name1);
                        System.out.println(name1);
                        counter++;
                    }
                }
            }
        }

        System.out.println(list.size());
        System.out.println("counter is "+counter);
    }

    public static void main(String[] args) {
        findPermutationThroughListIteration("ABCDE");
    }
}
