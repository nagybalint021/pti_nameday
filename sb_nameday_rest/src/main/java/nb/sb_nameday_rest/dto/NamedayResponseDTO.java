package nb.sb_nameday_rest.dto;

public class NamedayResponseDTO {
    private String status;
    private String namedays;

    public NamedayResponseDTO(String status, String namedays) {
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