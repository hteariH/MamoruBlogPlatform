package com.mamoru.controller;

import com.mamoru.model.Note;
import com.mamoru.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * user: alekseyb
 * date: 4/20/17
 */

@Controller
public class IndexController {

    private final NoteRepository noteRepository;

    @Autowired
    public IndexController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping("/notes")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                        @RequestParam(value = "size",required = false, defaultValue = "10") int size, Model model) {

        List<Note> all = noteRepository.findAll();
//        List<Note> content = all.getContent();
//        model.ad
        model.addAttribute("notes",all);
//        model.addAttribute("page",page);
//        model.addAttribute("countPages",all.getTotalPages());
//        model.addAttribute("countElems",all.getNumberOfElements());
        return "notes";
    }

}
