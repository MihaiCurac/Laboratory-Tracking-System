package laboratory_tracking.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private Laboratory laboratory;
    private String name;
    private String deadline;
    private String description;

    public Assignment() {
    }

    public Assignment(int id, Laboratory laboratory, String name, String deadline, String description) {
        this.id = id;
        this.laboratory = laboratory;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Assignment {" +
                "id = " + id +
                ", laboratory title = " + laboratory.getTitle() +
                ", name = " + name +
                ", deadline = " + deadline +
                ", description = " + description +
                '}';
    }
}
