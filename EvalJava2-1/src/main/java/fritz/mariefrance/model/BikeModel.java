package fritz.mariefrance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class BikeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private String conceptor;

    @Column
    private Date releaseDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status; // available or borrowed

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getConceptor() { return conceptor; }
    public void setConceptor(String conceptor) { this.conceptor = conceptor; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
