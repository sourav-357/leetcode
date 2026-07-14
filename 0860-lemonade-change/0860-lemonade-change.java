class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int five = 0;
        int ten = 0;

        for (int num : bills) {
            if (num == 5) 
                five++;

            else if (num == 10) {
                if (five <= 0)
                    return false;

                five--;
                ten++;
            }

            else if (num == 20) {
                if (five >= 1 && ten >= 1) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else 
                    return false;
            }
        }
        return true;
    }
}