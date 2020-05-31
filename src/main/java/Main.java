import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Alex", 23);
        Gson gson = new Gson();
        String json = gson.toJson(student);
        System.out.println(json);
        Student student1 = gson.fromJson(json, Student.class);
        System.out.println(student1);

    }

    public static class Student {
        public String name;
        public int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
