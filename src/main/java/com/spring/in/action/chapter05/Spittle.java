package com.spring.in.action.chapter05;

import lombok.Getter;

import java.util.Date;
import java.util.Objects;

/**
 * ****
 *
 * @author Alphonse
 * @date 2020/1/7 15:47
 * @since 1.0
 **/
@Getter
public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Spittle spittle = (Spittle) o;
        return Objects.equals(id, spittle.id) && Objects.equals(time, spittle.time);
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
