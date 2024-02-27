package ru.ivankrn.footballercatalog.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "footballer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String firstName;
    @Column(nullable = false)
    @NotBlank
    private String lastName;
    @Enumerated
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private LocalDate birthdate;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @Enumerated
    @Column(nullable = false)
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footballer that = (Footballer) o;
        if (id == null && that.id == null) {
            return false;
        }
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
