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

    int leastPushes = Integer.MAX_VALUE;

    public Machine(String l) {
        var machineParser = new MachineParser(l);
        this.targetLights = machineParser.getLights();
        this.buttons.addAll(machineParser.getButtons());
    }


    public int getLeastPushes() {
        return leastPushes;
    }

    public void pushButtons() {
        int lights = 0;

        List<Button> pushedButtons = new LinkedList<>();
        pushButtons(lights, pushedButtons);
    }

    private void pushButtons(int lights, List<Button> pushedButtons) {
        List<Button> newButtons = new ArrayList<>(buttons);
        newButtons.removeAll(pushedButtons);

        for (int i = 0; i < newButtons.size(); i++) {
            Button button = newButtons.get(i);
            pushedButtons.add(button);
            pushButtons(lights, pushedButtons);

            lights |= button.bitMask();
            System.out.println("Pushing button: " + button + " result is " + lights + " target is " + targetLights);
        }
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
