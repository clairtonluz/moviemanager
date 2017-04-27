package br.com.clairtonluz.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "movie_id_seq")
    @SequenceGenerator(name = "movie_id_seq", sequenceName = "movie_id_seq")
    private Integer id;
    @NotNull(message = "nome é obrigatório")
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_type", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> types;
    @NotNull(message = "Ano é obrigatório")
    private Integer year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
