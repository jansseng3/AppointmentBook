//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        boolean[][] schedule = new boolean[8][60];
        AppointmentBook a = new AppointmentBook(schedule);
        for(int i = 10; i < 15; i++) schedule[1][i] = true;
        for(int i = 30; i < 44; i++) schedule[1][i] = true;
        for(int i = 50; i < 59; i++) schedule[1][i] = true;

        a.printPeriod(2);
        a.findFreeBlock(2,15);
        a.findFreeBlock(2,9);
        a.findFreeBlock(2,20);
        schedule = new boolean[8][60];
        
        for(int i = 25; i < 30; i++) schedule[1][i] = true;
        for(int i = 0; i < 15; i++) schedule[2][i] = true;
        for(int i = 41; i < 60; i++) schedule[2][i] = true;
        for(int i = 5; i < 30; i++) schedule[3][i] = true;
        for(int i = 44; i < 60; i++) schedule[3][i] = true;
        
        AppointmentBook b = new AppointmentBook(schedule);
        int period = 2;
        while(period < 5)
        {
            System.out.println("Period:" + period);
            b.printPeriod(period);
            period++;
        }
        
        b.printPeriod(4);
        System.out.println(b.makeAppointment(2, 4, 22));
        System.out.println(b.makeAppointment(3, 4, 3));
        System.out.println(b.makeAppointment(2, 4, 30));


    }
}
