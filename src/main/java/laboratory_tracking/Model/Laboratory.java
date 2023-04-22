package laboratory_tracking.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "laboratories")
public class Laboratory {

    @Id
    private int id;
    private int nr;
    private String date;
    private String title;
    private String curricula;
    private String description;

    public Laboratory() {
    }

    public Laboratory(int id, int nr, String date, String title, String curricula, String description) {
        this.id = id;
        this.nr = nr;
        this.date = date;
        this.title = title;
        this.curricula = curricula;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Laboratory {" + "id = " + id + ", nr = " + nr + ", date = " + date + ", title = " + title + ", curricula = " + curricula + ", description = " + description + '}';
    }
}
