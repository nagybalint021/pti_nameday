package nb.sb_nameday_mvc.dto;

public class NamedayDTO {
    private String date;
    private String name;

    public NamedayDTO(String date, String name) {
        this.date = date;
        this.name = name;
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