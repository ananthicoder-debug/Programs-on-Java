class Solution {
    public boolean isPalindrome(int x) {
        int rem=0;
        int k=x;
        while (x>0){
            int dig=x%10;
            rem=(rem*10)+dig;
            x/=10;
        }
        return rem==k;
    }
}
