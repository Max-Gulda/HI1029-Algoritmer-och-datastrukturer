package F1;

import java.util.ArrayList;

public class ReplaceClass {
    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(oldItem)) {
                aList.set(i, newItem);
            }
        }
    }
}
