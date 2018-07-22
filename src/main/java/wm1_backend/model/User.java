package wm1_backend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "amountofinvestment")
    private Integer amountOfInvestment;

    @Column(name = "amountofrisk")
    private Integer amountOfRisk;

    @Column(name = "term")
    private Integer term;

    @Column(name = "comments")
    private String comments;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String lastName, String patronymic, Integer amountOfInvestment, Integer amountOfRisk, Integer term, String comments) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.amountOfInvestment = amountOfInvestment;
        this.amountOfRisk = amountOfRisk;
        this.term = term;
        this.comments = comments;
    }

    public User(String name, String lastName, String patronymic, Integer amountOfInvestment, Integer amountOfRisk, Integer term, String comments) {
        this(null, name, lastName, patronymic, amountOfInvestment, amountOfRisk, term, comments);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getAmountOfInvestment() {
        return amountOfInvestment;
    }

    public void setAmountOfInvestment(Integer amountOfInvestment) {
        this.amountOfInvestment = amountOfInvestment;
    }

    public Integer getAmountOfRisk() {
        return amountOfRisk;
    }

    public void setAmountOfRisk(Integer amountOfRisk) {
        this.amountOfRisk = amountOfRisk;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", amountOfInvestment=" + amountOfInvestment +
                ", amountOfRisk=" + amountOfRisk +
                ", term=" + term +
                ", comments='" + comments + '\'' +
                '}';
    }
}
