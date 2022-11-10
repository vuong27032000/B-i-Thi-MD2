package manager;

import io.ReadAndWrite;
import sinhvien.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();
    public final String REGEX_STRING = "[ny]";

    //Thông tin sinh viên
    public Student infProduct() {

        System.out.println("Nhập mã sinh viên: ");
        String code = scanner.nextLine();

        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên: ");
        int age = checkLoiNhap();
        System.out.println("Nhập giới tính sinh viên: ");
        String gender = scanner.nextLine();

        System.out.println("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();

        System.out.println("Nhập điểm trung bình sinh viên sinh viên: ");
        double medium;

        while (true) {
            try {
                medium = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng! Vui lòng chọn lại");
            }
        }

        Student product = new Student(code, name, age, gender, address, medium);
        System.out.println(product);
        return product;
    }

    //Hiển thị
    public void show() {
        System.out.println("-----------------------------------------------Danh sách học sinh-----------------------------------------------");
        System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s", "Mã học sinh", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s", student.getId(), student.getName(), student.getAge(), student.getGender(), student.getAddress(), student.getMedium());
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------");
        }

    }

    //Thêm
    public void add() {
        Student product = infProduct();
        students.add(product);
    }

    //Sửa
    public void update() {
        System.out.println("Nhập mã sinh viên bạn muốn sửa: ");
        String code = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(code)) {
                students.set(i, infProduct());
            }
        }
    }

    //Xóa
    public void delete() {
        System.out.println("Nhập mã sinh viên bạn muốn xóa:  ");
        String code = scanner.nextLine();
        System.out.println("Bạn có chắc sẽ xóa sinh viên (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equalsIgnoreCase(code)) {
                    students.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
        } else {
            System.out.println("Hủy bỏ xóa!");
        }

    }

    //Sắp xếp
    public void sort() {
        int choose = 3;
        System.out.println("1. Sắp xếp điểm trung bình tăng dần.");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần.");
        System.out.println("3. Thoát.");
        System.out.println("Nhập số để lựa chọn: ");
        do {
            if (choose > 3) System.out.println("Vui lòng nhập lại");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 3);

        switch (choose) {
            case 1 -> ascending();
            case 2 -> decrease();
            case 3 -> System.out.println("oke");
        }
    }

    //Tăng dần
    public void ascending() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getMedium() > students.get(j).getMedium()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();

    }

    //Giảm dần
    public void decrease() {

        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getMedium() < students.get(j).getMedium()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }

        show();

    }


    //Đọc từ file
    public void ReadFromFile() {
        System.out.println("Đọc từ File sẽ mất dữ liệu hiện tại, bạn có muốn tiếp tục? (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            students = ReadAndWrite.read();
            System.out.println("Đọc file thành công, chọn chức năng xem danh sách để kiểm tra.");
        }
    }

    //Ghi từ file
    public void WriteToFile() {
        System.out.println("Ghi vào File sẽ mất dữ liệu đang lưu, bạn có muốn tiếp tục? (yes:y hoặc no:n): ");
        String choice = validateString(REGEX_STRING);
        if (choice.equals("y")) {
            ReadAndWrite.write(students);
            System.out.println("Ghi file thành công, chạy lại chương trình và chọn chức năng đọc file để kiểm tra.");
        }
    }


    //Check lỗi
    public int checkLoiNhap() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng! Vui lòng nhập lại");
            }
        }
        return choice;
    }

    public String validateString(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Sai định dạng, vui lòng nhập lại.");
        }

    }
}
