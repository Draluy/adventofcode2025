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
    pushButtons(0, buttons, new ArrayList<>());
  }

  private void pushButtons(int lights, List<Button> bToPush, List<Button> bPushed) {
    for (Button button : bToPush) {
      int newLights = lights ^ button.bitMask();
      List<Button> buttonsPushed = new ArrayList<>(bPushed);
      List<Button> buttonsToPush = new ArrayList<>(bToPush);
      buttonsPushed.add(button);
      buttonsToPush.remove(button);

      // System.out.println("[depth "+bPushed.size()+"] Pushed button: " + button +  " from " + intASStr(lights, nbLights) + " result is " + intASStr(newLights, nbLights) + " target is " +  intASStr(targetLights, nbLights));

      if (newLights == targetLights) {
          if(leastPushes > buttonsPushed.size()) {
              leastPushes = buttonsPushed.size();
          }
          // System.out.println("FOUND!!!!");
          continue;
      }
      pushButtons(newLights, buttonsToPush, buttonsPushed);
    }
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
