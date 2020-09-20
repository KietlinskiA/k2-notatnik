package pl.kietlinski.k2notatnik.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private LocalDateTime date;
    private String formattedDate;
    private String description;

    public Note(int number, LocalDateTime date, String description) {
        this.number = number;
        this.date = date;
        this.formattedDate = date.format(DateTimeFormatter.ofPattern("dd.MM HH:mm"));
        this.description = description;
    }


}
