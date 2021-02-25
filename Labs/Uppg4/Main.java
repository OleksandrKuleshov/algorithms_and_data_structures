package Labs.Uppg4;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

  static int TEN_YEARS = 60 * 24 * 365 * 10;

  public static void main(String[] args) {

    int totalLandings = 0;
    int totalWaitLandingTime = 0;
    int totalStartings = 0;
    int totalWaitStartingTime = 0;
    int maxWaitLandingTime = 0;
    int maxWaitStartingTime = 0;
    Queue<Integer> starting = new LinkedList<>();
    Queue<Integer> landing = new LinkedList<>();

    for (int i = 0; i < TEN_YEARS; i += 5) {

      if (needToStart())
        starting.add(i);
      if (needToLand())
        landing.add(i);

      while (!landing.isEmpty() || !starting.isEmpty()) {
        if (!landing.isEmpty()) {
          totalWaitLandingTime += i - landing.peek();
          if (maxWaitLandingTime < i - landing.peek())
            maxWaitLandingTime = i - landing.peek();

          totalLandings++;
          for (int k = 0; k < 4; k++) {
            i += 5;
            if (needToStart())
              starting.add(i);
            if (needToLand())
              landing.add(i);
          }
          landing.poll();
        } else if (landing.isEmpty() && !starting.isEmpty()) {
          totalWaitStartingTime += i - starting.peek();
          if (maxWaitStartingTime < i - starting.peek())
            maxWaitStartingTime = i - starting.peek();
          totalStartings++;
          for (int k = 0; k < 4; k++) {
            i += 5;
            if (needToStart())
              starting.add(i);
            if (needToLand())
              landing.add(i);
          }
          starting.poll();
        }
      }
    }
    System.out.println("Avg waiting time for landing: " + getAvg(totalWaitLandingTime, totalLandings)
        + ", max waiting time for landing: " + maxWaitLandingTime);
    System.out.println("Avg waiting time for starting: " + getAvg(totalWaitStartingTime, totalStartings)
        + ", max waiting time for starting: " + maxWaitStartingTime);
  }

  static float getAvg(int time, int count) {
    return (float) time / count;
  }

  static boolean needToStart() {
    if (Math.random() <= 0.05)
      return true;
    return false;
  }

  static boolean needToLand() {
    if (Math.random() <= 0.05)
      return true;
    return false;
  }
}