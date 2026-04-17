/*
2. Create a class time that has hour, minute and second as data members. Create a 
parameterized constructor to initialize Time Objects. Create a member Function Time 
Sum (Time, Time) to sum two time objects
*/
public class Time {

    int hour;   // stores hours
    int minute; // stores minutes
    int second; // stores seconds

    // Constructor - initialize time with given values
    Time(int hour, int minute, int second) {
        this.hour = hour;     // set hour
        this.minute = minute; // set minute
        this.second = second; // set second
    }

    // display() - print time in readable format
    void display() {
        System.out.println(hour + " hours  " + minute + " minutes  " + second + " seconds");
    }

    // Sum() - add two time objects and return result
    Time Sum(Time t1, Time t2) {

        // Step 1 - add seconds of both times
        int totalSeconds = t1.second + t2.second;
        int sec = totalSeconds % 60;      // remaining seconds after converting to minutes
        int carryMin = totalSeconds / 60; // extra minutes to carry forward

        // Step 2 - add minutes of both times + carry from seconds
        int totalMinutes = t1.minute + t2.minute + carryMin;
        int min = totalMinutes % 60;       // remaining minutes after converting to hours
        int carryHour = totalMinutes / 60; // extra hours to carry forward

        // Step 3 - add hours of both times + carry from minutes
        int hr = t1.hour + t2.hour + carryHour;

        // return new Time object with result
        return new Time(hr, min, sec);
    }

    public static void main(String[] args) {

        // create first time object
        Time t1 = new Time(2, 45, 30);
        System.out.print("Time 1: ");
        t1.display(); // 2 hours 45 minutes 30 seconds

        // create second time object
        Time t2 = new Time(1, 20, 40);
        System.out.print("Time 2: ");
        t2.display(); // 1 hours 20 minutes 40 seconds

        // create third object just to call Sum()
        Time t3 = new Time(0, 0, 0);

        // add t1 and t2, store result in t3
        t3 = t3.Sum(t1, t2);
        System.out.print("Sum    : ");
        t3.display(); // 4 hours 6 minutes 10 seconds
    }
}