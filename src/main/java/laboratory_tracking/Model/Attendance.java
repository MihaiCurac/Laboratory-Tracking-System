package laboratory_tracking.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private Laboratory laboratory;
    private String students;

    public Attendance() {
    }

    public Attendance(int id, Laboratory laboratory, String students) {
        this.id = id;
        this.laboratory = laboratory;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Attendance { " +
                "id = " + id +
                ", laboratory title = " + laboratory.getTitle() +
                ", students = " + students +
                '}';
    }
}
