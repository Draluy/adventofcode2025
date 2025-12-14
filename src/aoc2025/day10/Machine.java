package aoc2025.day10;

import java.util.*;

public class Machine {

    private final int targetLights;
    private final List<Button> buttons = new ArrayList<>();
    private final int nbLights;
    private final Joltages targetJoltages;

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

    public void pushButtonsPart1() {
        Queue<State> states = new LinkedList<>();
        states.add(new State(0, new LinkedList<>(buttons), 0));
        leastPushes = pushButtonsBFS(states);
    }

    public void pushButtonsPart2() {
        precomputeHeuristicData();
        PriorityQueue<State2> states = new PriorityQueue<>( Comparator.comparingInt((State2 s) -> {
            return s.depth + heuristic(s.startingPosition);
        }));
        states.add(new State2(Joltages.allZeroes(targetJoltages.size()), 0));
        leastPushes = pushButtonsBFS2(states);
    }

    private int maxLightsPerPress;

    private void precomputeHeuristicData() {
        maxLightsPerPress = buttons.stream()
                .mapToInt(b -> b.lightsChanged().size())
                .max()
                .orElse(1);
    }

    private int heuristic(Joltages current) {
        int remainingSum = 0;
        int maxSingle = 0;

        for (int i = 0; i < current.size(); i++) {
            int remaining = targetJoltages.get(i) - current.get(i);
            if (remaining > 0) {
                remainingSum += remaining;
                maxSingle = Math.max(maxSingle, remaining);
            }
        }

        int byCoverage =
                (remainingSum + maxLightsPerPress - 1) / maxLightsPerPress;

        // take the strongest admissible bound
        return Math.max(maxSingle, byCoverage);
    }

    private record State2(Joltages startingPosition, int depth) {
        @Override
        public String toString() {
            return "startingPosition=" + startingPosition;
        }
    }

    private int pushButtonsBFS2(Queue<State2> queue) {
        Map<Joltages, Integer> alreadyVisited = new HashMap<>();

        while (!queue.isEmpty()) {
            State2 state = queue.poll();
            if (state.depth >= leastPushes) {
                continue;
            }
            for (Button button : buttons) {

//                if (!button.affectsAnyRemainingLight(state.startingPosition, targetJoltages)) {
//                    continue;
//                }
                Joltages newJoltage = state.startingPosition.applyButton(button);

                int newDepth = state.depth + 1;
                Integer seenDepth = alreadyVisited.get(newJoltage);
                if (seenDepth != null && seenDepth <= newDepth) {
                    continue;
                }

                if(newJoltage.greater(targetJoltages)){
                    continue;
                }

                alreadyVisited.put(newJoltage, newDepth);
                if (newJoltage.equals(targetJoltages)) {
                    System.out.println(newJoltage+ " is equal target " + targetJoltages);
                    return state.depth + 1;
                }
                // System.out.println("Pushing button " + button + " from " + intASStr(state.startingPosition, nbLights) + " result is " + intASStr(newLights, nbLights));
                queue.add(new State2(newJoltage, newDepth));
            }
            // System.out.println("Queue is "+queue);
        }
        return 0;
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
