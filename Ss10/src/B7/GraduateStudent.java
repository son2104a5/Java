package B7;

public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);
        if (researchTopic == null || researchTopic.trim().isEmpty()) {
            System.out.println("Lỗi: Đề tài nghiên cứu không được để trống.");
        }
        if (supervisorName == null || supervisorName.trim().isEmpty()) {
            System.out.println("Lỗi: Tên giảng viên hướng dẫn không được để trống.");
        }
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        if (researchTopic == null || researchTopic.trim().isEmpty()) {
            System.out.println("Lỗi: Đề tài nghiên cứu không hợp lệ.");
        } else {
            this.researchTopic = researchTopic;
        }
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        if (supervisorName == null || supervisorName.trim().isEmpty()) {
            System.out.println("Lỗi: Tên giảng viên hướng dẫn không hợp lệ.");
        } else {
            this.supervisorName = supervisorName;
        }
    }

    @Override
    public String getDetails() {
        return super.getDetails()
                + ", Đề tài nghiên cứu: " + researchTopic
                + ", Giảng viên hướng dẫn: " + supervisorName;
    }
}

