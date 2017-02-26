package tw.conway;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import java.util.Random;

import tw.conway.enumeration.LifeStatus;
import tw.conway.util.ConwayGame;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConwayGame conwayGame = new ConwayGame();
        int size = 30;
        if (args.length > 0) {
            size = parseInt(args[0]);
        }

        LifeStatus[][] initial = new LifeStatus[size][size];
        Random random = new Random();
        final int finalSize = size;
        range(0, size).forEach(w -> range(0, finalSize).forEach(h -> initial[w][h] = random.nextBoolean() ? LIVE : DEAD));
        int generation = 1;
        output(generation, initial);
        LifeStatus[][] previous = initial;
        while (true) {
            ++generation;
            LifeStatus[][] next = conwayGame.nextGeneration(previous);
            output(generation, next);
            previous = next;
        }

    }

    private static void output(int generation, LifeStatus[][] lifeStatuses) throws InterruptedException {
        System.out.println(format("Generation %d:\n", generation));
        stream(lifeStatuses).forEach(row -> {
            stream(row).forEach(status -> {
                String flag = LIVE.equals(status) ? "●" : "○";
                System.out.print(flag + " ");
            });
            System.out.println();
        });
        System.out.println("\n");
//        System.out.println("\n=========================================\n");
        Thread.sleep(500);
        System.out.print("\033\143");
    }
}
