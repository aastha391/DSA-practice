class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int five=0,ten=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                five++;
            }
            if(bills[i]==10){
                ten++;
                if(five!=0){
                five--;
                }
                else{
                    return false;
                }
            }
            if(bills[i]==20){
                if(ten!=0 && five!=0){
                    ten--;
                    five--;
                }
                else if(five!=0 && five>=3){
                    five=five-3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}