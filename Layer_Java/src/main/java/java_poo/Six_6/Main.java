package java_poo.Six_6;

public class Main {

	public static void main(String[] args) {

		School school = new School();
		Student student1 = new Student("Mats Yatzil", 15);
		Student student2 = new Student("Karolina Ralf", 16);
		Student student3 = new Student("Felicie Anuschka", 16);
		Student student4 = new Student("Norbert Micha", 15);

		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student3);
		school.addStudent(student4);

		Teacher teacher1 = new Teacher("Jens Amalia", "Math");
		Teacher teacher2 = new Teacher("Elise Giiwedin", "English");
		Teacher teacher3 = new Teacher("Angelika Lotta", "Science");

		school.addTeacher(teacher1);
		school.addTeacher(teacher2);
		school.addTeacher(teacher3);

		SchoolClass mathClass = new SchoolClass("Mathematics", teacher1);
		mathClass.addStudent(student1);
		mathClass.addStudent(student2);
		mathClass.addStudent(student3);
		mathClass.addStudent(student4);

		SchoolClass englishClass = new SchoolClass("English", teacher2);
		englishClass.addStudent(student1);
		englishClass.addStudent(student2);
		englishClass.addStudent(student3);

		SchoolClass scienceClass = new SchoolClass("Science", teacher3);
		scienceClass.addStudent(student1);
		scienceClass.addStudent(student2);
		scienceClass.addStudent(student3);
		scienceClass.addStudent(student4);

		school.addClass(mathClass);
		school.addClass(englishClass);
		school.addClass(scienceClass);

		System.out.println("School information:");
		System.out.println("Number of students: " + school.getStudents().size());
		System.out.println("Number of teachers: " + school.getTeacher().size());
		System.out.println("Number of classes: " + school.getClasses().size());
		System.out.println();

		System.out.println("Math class information:");
		System.out.println("Class name: " + mathClass.getClassName());
		System.out.println("Teacher: " + mathClass.getTeachers().getName());
		System.out.println("Number of students: " + mathClass.getStudents().size());
		System.out.println();

		System.out.println("English class information:");
		System.out.println("Class name: " + englishClass.getClassName());
		System.out.println("Teacher: " + englishClass.getTeachers().getName());
		System.out.println("Number of students: " + englishClass.getStudents().size());
		System.out.println();

		System.out.println("Science class information:");
		System.out.println("Class name: " + scienceClass.getClassName());
		System.out.println("Teacher: " + scienceClass.getTeachers().getName());
		System.out.println("Number of students: " + scienceClass.getStudents().size());
		System.out.println();

		school.removeStudent(student1);
		school.removeTeacher(teacher2);
		school.removeClass(mathClass);

		System.out.println("School information after removing one student, teacher and Class:");
		System.out.println("Number of students: " + school.getStudents().size());
		System.out.println("Number of teachers: " + school.getTeacher().size());
		System.out.println("Number of classes: " + school.getClasses().size());
	}
}
