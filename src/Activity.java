public class Activity implements Comparable<Activity> {
    public int number;
    public int start;
    public int end;
    public Activity(int n, int s, int e) {
        number = n;
        start = s;
        end = e;
    }

    public int compareTo(Activity other) {
        return this.start - other.start;
    }

    public String toString() {
        return number + ": (" + start + ", " + end + ")";
    }
}
