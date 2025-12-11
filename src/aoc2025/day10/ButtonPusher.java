package aoc2025.day10;

import java.util.LinkedList;
import java.util.List;

public class ButtonPusher {

    List<Integer> leastPushes = new LinkedList<>();

    public ButtonPusher(List<String> lines) {
        List<Machine> machines = lines.stream().map(Machine::new).toList();

        for (int i = 0; i < machines.size(); i++) {
            var machine = machines.get(i);

            machine.pushButtons();
            System.out.println("Pushed machine " + i + " least pushes "+ machine.getLeastPushes());
            leastPushes.add(machine.getLeastPushes());
        }
    }

    public Integer fewerPushes() {
        return leastPushes.stream().mapToInt(Integer::intValue).sum();
    }
}
