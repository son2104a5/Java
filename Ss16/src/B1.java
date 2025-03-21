import java.util.*;

public class B1 {
    public static void main(String[] args) {
        ArrayList<String> stuList = new ArrayList<>();
        stuList.add("Nguyễn Văn A");
        stuList.add("Trần Văn B");
        stuList.add("Lê Thị C");
        stuList.add("Đào Hà D");
        stuList.add("Đỗ Duy E");

        System.out.println("Vòng for:");
        for (int i = 0; i < stuList.size(); i++) {
            System.out.println(stuList.get(i));
        }

        System.out.println("Vòng foreach:");
        for (String stu : stuList) {
            System.out.println(stu);
        }

        System.out.println("Iterator:");
        Iterator<String> iterator = stuList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
