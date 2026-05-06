package com.federation.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Activity {
    private String title;
    private LocalDate date;

    public Activity() {
    }

    public Activity(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }
}
