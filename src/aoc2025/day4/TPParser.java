package aoc2025.day4;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TPParser {

  private final static int WIDTH = 137;
  private final static int HEIGHT = 137;

  private boolean[][] tps = new boolean[WIDTH][HEIGHT];
  record TpToRemove (int i, int j){}
  private int nbAccessible = 0;

  public TPParser(Stream<String> lines) {
    List<String> ll = lines.toList();
    for (int i = 0; i < ll.size(); i++) {
      String line = ll.get(i);
      for (int j = 0; j < line.length(); j++) {
        tps[i][j] = line.charAt(j) == '@';
      }
    }

    List<TpToRemove> tpToRemoves = calculatedNbAccessible();
    while (!tpToRemoves.isEmpty()) {
      for (TpToRemove tpToRemove : tpToRemoves) {
        tps[tpToRemove.i][tpToRemove.j] = false;
      }
      tpToRemoves = calculatedNbAccessible();
    }
  }

  private List<TpToRemove> calculatedNbAccessible() {

    List<TpToRemove> list = new LinkedList<>();
    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        if (tps[i][j]) {
          // we are on a roll
          int nb = getNbNeighbours(i, j);

          if (nb < 4) {
            nbAccessible++;
            list.add(new TpToRemove(i, j));
          }
        }
      }
    }
    return list;
  }

  private int getNbNeighbours(int i, int j) {
    int left = j - 1 >0 ? j -1:  0;
    int right = j + 1 < WIDTH ? j + 1 : j;
    int up = Math.max(i - 1, 0);
    int down = i + 1 < HEIGHT ? i + 1 : i;

    int nbNeighbours = 0;
    for (int k = up; k <= down; k++) {
      for (int l = left; l <= right; l++) {
        if (this.tps[k][l]) {
          nbNeighbours++;
        }
      }
    }
    return nbNeighbours -1 ;

  }


  public int getNbAccessible() {
    return nbAccessible;
  }

}
