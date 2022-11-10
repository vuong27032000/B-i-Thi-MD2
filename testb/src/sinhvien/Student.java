package sinhvien;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double medium;

    public Student(String id) {
    }

    public Student(String id, String name, int age, String gender, String address, double medium) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.medium=medium;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender= gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMedium() {
        return medium;
    }

    public void setMedium(double medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "sinhvien{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", diemtrungbinh=" + medium +
                '}';
    }
    public String in(){
        return id + ", " + name +
                ", " + age +
                ", " + gender +
                ", " + address + ", " + medium;
    }
}
