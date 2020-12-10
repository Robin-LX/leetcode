package leetcode_860;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for (int i = 0; i < bills.length; i++) {
            int moneyBack = bills[i] - 5;
            if (moneyBack % 5 != 0) {
                if (money[0] == 0) return false;
                money[0]--;
            }
            while (moneyBack != 0) {
                if (moneyBack >= 20 && money[2] > 0) {
                    moneyBack -= 20;
                    money[2]--;
                } else if (moneyBack >= 10 && money[1] > 0) {
                    moneyBack -= 10;
                    money[1]--;
                } else if (money[0] > 0) {
                    moneyBack -= 5;
                    money[0]--;
                } else {
                    return false;
                }
            }
            money[bills[i] / 7]++;
        }
        return true;
    }
}