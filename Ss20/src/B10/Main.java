package B10;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", Optional.of("quy@example.com"));
        User u2 = new User(2, "Lan", Optional.empty());
        User u3 = new User(3, "Huyền", Optional.of("huyen@example.com"));

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        System.out.println("===== Công việc quá hạn chưa hoàn thành =====");
        for (Task task: tasks) {
            if (!task.isCompleted()) {
                System.out.println("- " + task.getTitle() + " (Giao cho: " + task.getAssignedTo().getName() + ", hạn chót: " + task.getDueDate() + ")");
            }
        }
        System.out.println();

        long count = tasks.stream()
                .filter(Task::isCompleted).count();
        System.out.println("Tổng số công việc đã hoàn thành: " + count + "\n");

        System.out.println("===== Thống kê công việc theo người dùng =====");
        Map<User, List<Task>> userTasks = new LinkedHashMap<>();
        for (Task task: tasks) {
            userTasks.computeIfAbsent(task.getAssignedTo(), k -> new ArrayList<>()).add(task);
        }

        userTasks.forEach((user, userTaskList) -> {
            long overdueCount = userTaskList.stream()
                    .filter(task -> !task.isCompleted() && task.getDueDate().isBefore(LocalDate.of(2025, 3, 23)))
                    .count();
            System.out.println("- Tên: " + user.getName() + "\t| Email: " + user.getEmail()  +
                    "\t| Tổng việc: " + userTaskList.size() + "\t| Quá hạn: " + overdueCount);
        });
    }
}
