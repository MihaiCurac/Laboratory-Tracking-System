package laboratory_tracking.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;
    private String full_name;
    private int group_nr;
    private String hobby;
    private String token;

    public Student() {
    }

    public Student(int id, User user, String full_name, int group_nr, String hobby, String token) {
        this.id = id;
        this.user = user;
        this.full_name = full_name;
        this.group_nr = group_nr;
        this.hobby = hobby;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGroup_nr() {
        return group_nr;
    }

    public void setGroup_nr(int group_nr) {
        this.group_nr = group_nr;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        if(user == null)
            return "Student {" +
                    "id = " + id +
                    ", email = " + "No email corresponding to a student account yet" +
                    ", full_name = " + full_name +
                    ", group_nr = " + group_nr +
                    ", hobby = " + hobby +
                    ", token = " + token +
                    '}';
        return "Student {" +
                "id = " + id +
                ", email = " + user.getEmail() +
                ", full_name = " + full_name +
                ", group_nr = " + group_nr +
                ", hobby = " + hobby +
                ", token = " + token +
                '}';
    }
}
