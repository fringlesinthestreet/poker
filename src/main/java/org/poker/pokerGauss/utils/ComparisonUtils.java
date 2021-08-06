package org.poker.pokerGauss.utils;

public class ComparisonUtils {

    public static boolean isASuperiorSuit (String suit1, String suit2) {
        if (suit1.equals(suit2)){
            return false;
        }
        if (suit1.equals("s")){
            return true;
        }
        if (suit1.equals("h") && suit2.equals("s")){
            return false;
        }
        return suit1.equals("c") && suit2.equals("d");
    }

    public static boolean isASuperiorNumber(int number1, int number2){
        if (number1 == number2) {
            return false;
        }
        if (number1 == 1) {
            return true;
        }
        if (number2 == 1){
            return false;
        }
        return number1 > number2;
    }
}
