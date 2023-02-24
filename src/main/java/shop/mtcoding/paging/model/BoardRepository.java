package shop.mtcoding.paging.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.paging.dto.board.BoardResp.DetailDto;
import shop.mtcoding.paging.dto.board.BoardResp.MainDto;
import shop.mtcoding.paging.dto.board.BoardResp.PagingDto;

@Mapper
public interface BoardRepository {

        public void insert(Board boards);

        public List<MainDto> findAll(@Param("startNum") int startNum, @Param("keyword") String keyword,
                        @Param("row") int row);

        public PagingDto paging(@Param("page") int page, @Param("keyword") String keyword, @Param("row") int row);

        public Board findById(Integer id);

        public void update(Board boards);

        public void deleteById(Integer id);

        public void updateByUsersId(Integer usersId);

        public DetailDto findByDetail(@Param("boardsId") Integer boardsId, @Param("principalId") Integer principalId);
}
