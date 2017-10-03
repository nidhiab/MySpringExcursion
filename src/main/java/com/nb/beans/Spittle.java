package com.nb.beans;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="spittle")

@NamedQuery(
        name="Spittle.findAllSpittlesForASpitter",
        query="SELECT s FROM Spittle s where s.spitterId = :spitterId"
)
public class Spittle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long spitterId;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle() {
    }

    public Spittle(Long id, Long spitterId, String message, Date time) {
        this(id, spitterId, message, time, null, null);
    }
    public Spittle(Long id, Long spitterId,
            String message, Date time, Double longitude, Double latitude) {
        this.id = id;
        this.spitterId = spitterId;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpitterId() {
        return spitterId;
    }

    public void setSpitterId(Long spitterId) {
        this.spitterId = spitterId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", spitterId=" + spitterId +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
