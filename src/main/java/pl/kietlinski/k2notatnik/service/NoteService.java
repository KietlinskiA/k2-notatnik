package pl.kietlinski.k2notatnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll(){
        return noteRepository.findAllNotes();
    }

    public void add(Note note){
        note.setDate(LocalDateTime.parse(note.getFormattedDate() + ":00.000"));
        note.setFormattedDate(note.getDate().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM")) + " " + note.getDate().toLocalTime().toString());

        noteRepository.save(note);
    }

    public void delete(long id){
        Optional<Note> byId = noteRepository.findById(id);
        noteRepository.delete(byId.get());
    }

}
