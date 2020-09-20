package pl.kietlinski.k2notatnik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "SELECT * FROM notes ORDER BY date ASC", nativeQuery = true)
    List<Note> findAllNotes();

}
