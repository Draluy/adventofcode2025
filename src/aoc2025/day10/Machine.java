package aoc2025.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Machine {

  private final int targetLights;
  private final List<Button> buttons = new ArrayList<>();
  private final int nbLights;

  int leastPushes = Integer.MAX_VALUE;

  public Machine(String l) {
    var machineParser = new MachineParser(l);
    this.targetLights = machineParser.getLights();
    this.nbLights = machineParser.getNbLights();
    this.buttons.addAll(machineParser.getButtons());
    leastPushes = Integer.MAX_VALUE;
  }


  public int getLeastPushes() {
    return leastPushes;
  }

  public void pushButtons() {
    List<Button> buttonsPushed = pushButtons(0, buttons, new ArrayList<>());
    System.out.println("Best result was "+buttonsPushed);
  }

  private List<Button> pushButtons(int lights, List<Button> bToPush, List<Button> bPushed) {
    // System.out.println("pushButtons called with light " + intASStr(lights, nbLights) + " with buttonsToPush "+ bToPush);

    List<Button> bestResult = new ArrayList<>();
    for (Button button : bToPush) {

      int newLights = lights ^ button.bitMask();
      List<Button> buttonsPushed = new ArrayList<>(bPushed);
      List<Button> buttonsToPush = new ArrayList<>(bToPush);
      buttonsPushed.add(button);
      buttonsToPush.remove(button);
      List<Button> btns = pushButtons(newLights, buttonsToPush, buttonsPushed);
      System.out.println("Pushed button: " + button +  " from " + intASStr(newLights, nbLights) + " result is " + intASStr(newLights, nbLights) + " target is " +  intASStr(targetLights, nbLights));

      if (newLights == targetLights) {
        return buttonsPushed;
      }

//      List<Button> btns = pushButtons(newLights, buttonsToPush, buttonsPushed);
//      if (btns.isEmpty() || btns.size() < bestResult.size()) {
//        bestResult = btns;
//        return btns;
//      }
    }
    return bestResult;
  }

  String intASStr(int i, int nblights) {
    return String.format("%"+nblights+"s", Integer.toBinaryString(i)).replace(' ', '0');
  }

//    private void pushButtonsInThisOrder(Button[] pushes) {
//        Boolean[] array = new Boolean[targetLightsArray.length];
//        Arrays.fill(array, false);
//
//        int nbPushes = 0;
//
//        for (Button push : pushes) {
//            nbPushes++;
//            for(Integer lightIndex : push.lightsChanged()){
//                array[lightIndex] = !array[lightIndex];
//            }
//            boolean allLightsOk = Arrays.equals(array, targetLightsArray);
//            if(allLightsOk){
//                if(leastPushes > nbPushes) {
//                    System.out.println("pushed times = " + nbPushes + " with "+ Arrays.toString(pushes));
//                    leastPushes = nbPushes;
//                }
//                return;
//            }
//        }
//    }

}
