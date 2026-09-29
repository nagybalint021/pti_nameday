package nb.sb_nameday_rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Nameday {
    @Id
    @Column
    private Integer id;

    @Column
    private String date;

    @Column
    private String name;

    public Nameday(Integer id, String date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}