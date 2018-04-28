import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelector {
    private List<Activity> activities;
    private List<Activity> result;

    public ActivitySelector(List<Activity> activities) {
        this.activities = new ArrayList<>();
        for (Activity a: activities) {
            this.activities.add(new Activity(a));
        }
        Sorting.mergeSort(this.activities);
        result = new ArrayList<>();
        solve();
    }

    private void solve() {
        int curr = activities.size() - 1;
        result.add(activities.get(curr));
        while (curr >= 0) {
            int prev = curr - 1;
            while (prev >= 0 && (activities.get(curr).start < activities.get(prev).end)) {
                prev--;
            }
            if (prev >= 0) {
                result.add(activities.get(prev));
            }
            curr = prev;
        }
        Collections.sort(result);
    }

    public List<Activity> getResult() {
        return result;
    }

    public void printResults() {
        System.out.println("Number of activities selected: " + result.size());
        System.out.print("Activities: ");
        for (Activity a: result) {
            System.out.print(a.number + " ");
        }
        System.out.println();
    }
}
