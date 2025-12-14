package aoc2025.day10;

import java.util.LinkedList;
import java.util.List;

public class ButtonPusher {

    private final List<Machine> machines;
    List<Integer> leastPushes = new LinkedList<>();

    public ButtonPusher(List<String> lines) {
        this.machines = lines.stream().map(Machine::new).toList();
    }

    public void part1(){
        for (int i = 0; i < machines.size(); i++) {
            var machine = machines.get(i);

            machine.pushButtonsPart1();
            System.out.println("Pushed machine " + i + " least pushes "+ machine.getLeastPushes());
            leastPushes.add(machine.getLeastPushes());
        }
    }

    public void part2(){
        for (int i = 0; i < machines.size(); i++) {
            var machine = machines.get(i);

            machine.pushButtonsPart2();
            System.out.println("Pushed machine " + i + " least pushes "+ machine.getLeastPushes());
            leastPushes.add(machine.getLeastPushes());
        }
    }

    public Integer fewerPushes() {
        return leastPushes.stream().mapToInt(Integer::intValue).sum();
    }
}
