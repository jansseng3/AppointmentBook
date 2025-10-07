public class AppointmentBook {
    private boolean [][] schedule;

    public AppointmentBook(boolean[][] schedule) {
        this.schedule = schedule;
    }

    public void printPeriod(int period) {
        for(int i = 0; i < schedule[period - 1].length; i++)
            System.out.println(i + " " + schedule[period - 1][i]);
    }

    private boolean isMinuteFree(int period, int minute) {
        return schedule[period - 1][minute];
    }

    public int findFreeBlock(int period, int duration) {
        int block = 0;
        for(int i = 0; i < 60; i++)
            if(isMinuteFree(period, i)) {
                block++;
                if(block == duration) {
                    return i - duration + 1;
                }
                else {
                    block = 0;
                }
            }
        return -1;
    }

    public int reserveBlock(int startMinute, int duration) {
        for(int i = startMinute; i < startMinute + duration; i++) {
            schedule[period -1][i] = false;
            int freeBlock = findFreeBlock(i, duration);

            if (freeBlock > 1) {
                reserveBlock(i, freeBlock, duration);
                return true;
            }
            return false;
        }
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        for(int i = 25; i < 30; i++) schedule[1][i] = true;
        for(int i = 0; i < 15; i++) schedule[2][i] = true;
        for(int i = 41; i < 60; i++) schedule[2][i] = true;
        for(int i = 5; i < 30; i++) schedule[1][i] = true;
        for(int i = 44; i < 60; i++) schedule[3][i] = true;

        AppointmentBook b = new AppointmentBook(schedule);

        int period = 2;
        while (period < 5) {
            System.out.println("Period: " + period);
            b.printPeriod(period);
            period++;
        }

        for(int i = startMinute; i < startMinute + duration; i++) {
            schedule[period - 1][i] = false;
        }

        for(int i = startPeriod; i<= endPeriod; i++) {
            int freeBlock =  findFreeBlock(i, duration);
        }

        if (freeBlock > -1) {
            reserveBlock(i, freeBlock, duration);
            return true;

        }

        return false;
    }




}
