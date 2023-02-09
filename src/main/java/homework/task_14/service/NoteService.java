package homework.task_14.service;

import homework.task_14.entiti.Note;
import homework.task_14.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        return new ArrayList<Note>(noteRepository.findAll());
    }
    @Transactional
    public Note add(Note note){
        return noteRepository.save(note);
    }

    @Transactional
    public void deleteById(long id){
        if(noteRepository.existsById(id)){
            noteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id not found");
        }
    }
    @Transactional
    public void update(Note note){
        if(noteRepository.existsById(note.getId())){
            noteRepository.save(note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    public Note getById(long id){
        if (noteRepository.existsById(id)){
            return noteRepository.getReferenceById(id);
        } else {
            throw new RuntimeException("Id not found");
        }
    }
}
