import java.util.*;

class Solution {
    public List<Integer> isUgly(int n) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int [] allowed = new int[]{1,2,3,5};
        for (int i = 1; i <= n ; i++) {
             if (n % i == 0 && checkForPrime(i))
                 list.add(i);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            for (int k : allowed) {
                if (list.contains(k))
                    count++;
            }
        }
        list.add(count);
//        if (n <= 0)
//            return false;
//        if (count/2 == list.size())
//            return true;
//        else
//            return false;

        return list;
    }


    static boolean checkForPrime(int inputNumber) {
        boolean isItPrime = true;

        if (inputNumber < 1) {
            isItPrime = false;

            return isItPrime;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;

                    break;
                }
            }

            return isItPrime;
        }
    }
}
