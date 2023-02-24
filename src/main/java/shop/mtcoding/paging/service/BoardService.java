package shop.mtcoding.paging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.paging.dto.board.BoardResp.MainDto;
import shop.mtcoding.paging.dto.board.BoardResp.PagingDto;
import shop.mtcoding.paging.model.BoardRepository;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public PagingDto 게시글목록보기(Integer page, String keyword) {

        if (page == null) {
            page = 0;
        }

        int startNum = page * PagingDto.ROW;

        System.out.println("==========");
        System.out.println("keyword : " + keyword);
        System.out.println("==========");

        List<MainDto> boardsList = boardRepository.findAll(startNum, keyword, PagingDto.ROW);
        PagingDto pagingDto = boardRepository.paging(page, keyword, PagingDto.ROW);

        if (boardsList.size() == 0)
            pagingDto.setNotResult(true);
        pagingDto.makeBlockInfo(keyword);
        pagingDto.setMainDtos(boardsList);

        return pagingDto;
    }

}
