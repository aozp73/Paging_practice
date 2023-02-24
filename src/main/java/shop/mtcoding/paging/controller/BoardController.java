package shop.mtcoding.paging.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.paging.dto.board.BoardResp.PagingDto;
import shop.mtcoding.paging.model.BoardRepository;
import shop.mtcoding.paging.service.BoardService;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    private final BoardService boardService;

    private final HttpSession session;

    @GetMapping({ "/", "/boards" })
    public String getBoardList(Model model, Integer page, String keyword) { // 0 -> 0, 1->10, 2->20
        PagingDto pagingDto = boardService.게시글목록보기(page, keyword);
        model.addAttribute("pagingDto", pagingDto);
        // Map<String, Object> referer = new HashMap<>();
        // referer.put("page", pagingDto.getCurrentPage());
        // referer.put("keyword", pagingDto.getKeyword());
        // session.setAttribute("referer", referer);
        return "board/main";
    }
}
