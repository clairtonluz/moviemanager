package br.com.clairtonluz.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "type")
public class Type extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "type_id_seq")
    @SequenceGenerator(name = "type_id_seq", sequenceName = "type_id_seq")
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
