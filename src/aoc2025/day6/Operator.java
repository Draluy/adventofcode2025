package aoc2025.day6;

public enum Operator{
    ADD, MULTIPLY;

    public static Operator getOperator(char s) {
        if(s == ' ') {
            return null;
        }
        return s == '+'? ADD : MULTIPLY;}

}