package F1;

import java.util.ArrayList;
public class DeleteClass {
    public static void delete(ArrayList<String> aList, String target) {
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(target)) {
                aList.remove(i);
                return;
            }
        }
    }
}
