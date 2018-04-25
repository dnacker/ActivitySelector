import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelector {
    private List<Activity> activities;
    private List<Activity> result;

    public ActivitySelector(List<Activity> activities) {
        this.activities = activities;
        result = new ArrayList<>();
        solve();
    }

    private void solve() {
        Collections.sort(activities);
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

}
