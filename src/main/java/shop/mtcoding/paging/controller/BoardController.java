package shop.mtcoding.paging.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.paging.model.Board;
import shop.mtcoding.paging.model.BoardRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String main(Model model) {

        List<Board> dtos = boardRepository.findAll();
        model.addAttribute("dtos", dtos);
        return "/board/main";
    }
}
