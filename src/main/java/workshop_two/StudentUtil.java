package workshop_two;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentUtil {

    public static Map<Integer, Student> mergeWithSameLength(List<Student> list1, List<Student> list2) {
        try {
            List<Student> safeList1 = list1 == null ? Collections.emptyList() : list1;
            List<Student> safeList2 = list2 == null ? Collections.emptyList() : list2;

            return Stream.concat(safeList1.stream(), safeList2.stream())
                    .filter(Objects::nonNull)
                    .collect(Collectors.toMap(
                            Student::getId,
                            Function.identity(),
                            (s1, s2) -> {
                                String name1 = s1.getName() == null ? "" : s1.getName();
                                String name2 = s2.getName() == null ? "" : s2.getName();
                                return name1.length() >= name2.length() ? s1 : s2;
                            },
                            LinkedHashMap::new
                    ));

        } catch (NullPointerException e) {
//            System.err.println(e.getMessage());
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}
