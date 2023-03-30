
class Solution {
    public boolean isUgly(int n) {
        int [] allowed = new int[]{2,3,5};

        if (n<=0)
            return false;

        for (int factor: allowed ){
            while (n%factor == 0){
                n =n/factor;
            }
        }
        return n==1;
    }



}
