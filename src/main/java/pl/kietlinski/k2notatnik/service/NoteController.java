package pl.kietlinski.k2notatnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notatnik")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("listNote", noteService.findAll());
        model.addAttribute("note", new Note());
        return "index";
    }

    @PostMapping
    public String addNote(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/notatnik";
    }

    @GetMapping("/delete")
    public String deleteNote(@RequestParam long id){
        noteService.delete(id);
        return "redirect:/notatnik";
    }

}
