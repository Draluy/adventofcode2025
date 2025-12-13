package aoc2025.day10;

import java.util.*;

public class Machine {

    private final int targetLights;
    private final List<Button> buttons = new ArrayList<>();
    private final int nbLights;
    private final List<Integer> targetJoltages;

    int leastPushes = Integer.MAX_VALUE;

    public Machine(String l) {
        var machineParser = new MachineParser(l);
        this.targetLights = machineParser.lights();
        this.targetJoltages = machineParser.joltages();
        this.nbLights = machineParser.nbLights();
        this.buttons.addAll(machineParser.getButtons());
        leastPushes = Integer.MAX_VALUE;
    }


    public int getLeastPushes() {
        return leastPushes;
    }

    public void pushButtons() {
        Queue<State> states = new LinkedList<>();
        states.add(new State(0, new LinkedList<>(buttons), 0));
        leastPushes = pushButtonsBFS(states);
    }

    private record State(int startingPosition, Queue<Button> buttons, int depth) {
        @Override
        public String toString() {
            return "startingPosition=" + Integer.toBinaryString(startingPosition) +
                    ", buttons=" + buttons;
        }
    }

    private int pushButtonsBFS(Queue<State> queue) {
        while (!queue.isEmpty()) {
            State state = queue.poll();
            for (Button button : state.buttons) {
                int newLights = state.startingPosition ^ button.bitMask();
                if (newLights == targetLights) {
                    return state.depth + 1;
                }
                // System.out.println("Pushing button " + button + " from " + intASStr(state.startingPosition, nbLights) + " result is " + intASStr(newLights, nbLights));
                Queue<Button> remainingButtons = new LinkedList<>(state.buttons);
                remainingButtons.remove(button);
                int newDepth = state.depth + 1;
                queue.add(new State(newLights, remainingButtons, newDepth));
            }
            // System.out.println("Queue is "+queue);
        }
        return 0;
    }
}
