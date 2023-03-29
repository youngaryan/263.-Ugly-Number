import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isUgly(int n) {
        int[] allowed = new int[]{1,2,3,5};
        boolean result = true;
        List<Integer> listPrime = new ArrayList<>(primeFactor(n));
        listPrime.add(0, 1);

        if (Math.sqrt(n) == (int) Math.sqrt(n) && n!=1)
            listPrime.add((int)Math.sqrt(n));


        if (n>1)
            throw new RuntimeException(String.valueOf(listPrime)+ primeFactor(n));

        for (int j : allowed) {
            if (isPrime(n) && n == j) {
                result = true;
                break;
            } else if (isPrime(n)&& n!=j) {
                result = false;
            }
        }
        if (n<=0)
            return false;
        for (int i = allowed.length-1; i >=0; i--) {
            if (listPrime.contains(allowed[i])) {
                listPrime.remove(i);
            }
        }

        return listPrime.size() == 0 && result ;
    }



    public List<Integer> primeFactor(int n){

        List<Integer> listPrime = new ArrayList<>();
        for (int i = 1; i <= n/2; i++) {
            if (n%i == 0 && isPrime(i)) listPrime.add(i);
        }
        return listPrime;
    }
    static  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }
}