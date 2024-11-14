package fritz.mariefrance.dto;

import java.util.Date;
import fritz.mariefrance.model.Status;

public class BikeDto {
    private Long id;
    private String model;
    private String conceptor;
    private Date releaseDate;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getConceptor() {
        return conceptor;
    }

    public void setConceptor(String conceptor) {
        this.conceptor = conceptor;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
