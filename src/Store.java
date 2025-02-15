import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Store {
    LinkedList<Student> students = new LinkedList<Student>();
    float average, minGrade, maxGrade = 0;
    double standardDeviation;
    public Store(List<Student> studentsList){
        students.addAll(studentsList);
        calculateStatistics();
    }
    public Store() {}
    public void addStudent(Student student){
        students.add(student);
        calculateStatistics();
    }
    public void removeStudent(Student student){
        students.remove(student);
        calculateStatistics();
    }

    public float calculateAverage(Float summation){
        return summation/ students.size();
    }
    public void findExtremaGrades(Float grade){
        if(grade > maxGrade){ maxGrade = grade; }
        if(grade < minGrade ||  minGrade==0){ minGrade = grade; }
    }
    public double calculateStandardDeviation(Float deviationSummation){
        return Math.sqrt(deviationSummation/ students.size());
    }
    public void calculateStatistics(){
        Iterator<Student> iterator = students.iterator();
        float sum = 0;
        while(iterator.hasNext()){
            Student student = iterator.next();
            sum += student.getGrade();
            findExtremaGrades(student.getGrade());
        }
        average = calculateAverage(average);
        Iterator<Student> iterator2 = students.iterator();
        float deviationSum = 0;
        while(iterator2.hasNext()){
            Student student = iterator2.next();
            deviationSum += Math.pow(Math.abs(student.getGrade() - average),2);
        }
        standardDeviation = calculateStandardDeviation(deviationSum);
    }
}
