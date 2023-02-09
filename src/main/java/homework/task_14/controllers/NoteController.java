package homework.task_14.controllers;

import homework.task_14.entiti.Note;
import homework.task_14.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getAll(){
        ModelAndView result = new ModelAndView("list");
        result.addObject("note", noteService.listAll());
        return result;

    }

    @PostMapping("/delete")
    public View delete(@RequestParam long id){
        noteService.deleteById(id);

        return new RedirectView("/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView editNoteById(@RequestParam long id){

        ModelAndView result = new ModelAndView("edit");
        return result.addObject(noteService.getById(id));

    }

    @PostMapping("/edit")
    public View edit(@ModelAttribute("note") Note note){
        noteService.update(note);

        return new RedirectView("/note/list");
    }

    @GetMapping("/create")
    public void createNew(){
    }

    @PostMapping("/create")
    public View create(@ModelAttribute("note") Note note){
        noteService.add(note);
        return new RedirectView("/note/list");
    }

}
