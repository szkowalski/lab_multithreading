package edu.iis.mto.multithread;

public class Radar {

    private static final int ROCKET_COUNT = 10;
    private PatriotBattery battery;

    public Radar(PatriotBattery battery) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, ROCKET_COUNT);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}
