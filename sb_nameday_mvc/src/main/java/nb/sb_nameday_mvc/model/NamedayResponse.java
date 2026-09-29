package nb.sb_nameday_mvc.model;

public class NamedayResponse {
    private String status;
    private String namedays;

    public NamedayResponse(String status, String namedays) {
        this.status = status;
        this.namedays = namedays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNamedays() {
        return namedays;
    }

    public void setNamedays(String namedays) {
        this.namedays = namedays;
    }
}