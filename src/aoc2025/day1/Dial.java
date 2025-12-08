package aoc2025.day1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Dial {

  public static final int capacity = 100;
  public static final Pattern pattern = Pattern.compile("(?<letter>[A-Z])(?<number>\\d+)");
  int position = 50; // starting position

  int zeros = 0;

  public void inc(int i) {
    int raw = position + i;
    zeros += raw / capacity;

    position = raw % capacity;
  }

  public void dec(int i) {
    for (int j = 0; j < i; j++) {
      position -=  1;
      if(position == -1) {
        position = 99;
      }
      if(position == 0) {
        zeros += 1;
      }
    }
  }


  public void move(String s) {
    Matcher matcher = pattern.matcher(s);
    if (matcher.matches()) {
      String direction = matcher.group("letter");
      int number = Integer.parseInt(matcher.group("number"));
      System.out.println("Playing  " + s + " from " + getPosition());
      switch (direction) {
        case "R" -> inc(number);
        case "L" -> dec(number);
      }
    }
    System.out.println("Position is " + getPosition());
    System.out.println("Zeros overflows is " + getZeros());
  }

  public int getPosition() {
    return position;
  }

  public int getZeros() {
    return zeros;
  }
}
