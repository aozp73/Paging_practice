<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3">
            <div class="d-flex justify-content-end">
                <div style="width: 300px">
                    <form class="d-flex" method="get" action="/" onsubmit="checkSearch()">
                        <input id="searchBox" class="form-control me-2" type="text" placeholder="Search" name="keyword"
                            val="">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </form>
                </div>
            </div>
            <div class="my-board-box row">
                <c:forEach var="boards" items="${pagingDto.mainDtos}">

                    <div class="card col-lg-3 pt-2">
                        <img class="card-img-top" style="height: 250px;" src="/images/sampleimg.png" alt="Card image">
                        <hr>
                        <div class="card-body">
                            <div>작성자 : 아무개</div>
                            <h4 class="card-title my-text-ellipsis">${boards.title}</h4>
                            <a href="/board/${boards.id}" class="btn btn-primary">상세보기</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="d-flex justify-content-center">
                <ul class="pagination">

                    <li class='page-item ${pagingDto.first ? "disabled" : ""}'><a class="page-link"
                            href="javascript:void(0);" onclick="callPrev();">Prev</a></li>

                    <c:forEach var="num" begin="${pagingDto.startPageNum}" end="${pagingDto.lastPageNum}">
                        <li class='page-item'><a class='page-link' href="/?page=${num-1}">${num}</a></li>
                    </c:forEach>

                    <li class='page-item ${pagingDto.last ? "disabled" : ""}'><a class="page-link"
                            href="javascript:void(0);" onclick="callNext();">Next</a></li>

                </ul>
            </div>
        </div>

        <script>

            function callPrev() {
                let keyword = `${pagingDto.keyword}`;
                let currentPage = `${pagingDto.currentPage - 1}`
                if (keyword) {
                    location.href = "/?page=" + currentPage + "&keyword=" + keyword;
                } else {
                    location.href = "/?page=" + currentPage;
                }
            }

            function callNext() {
                let keyword = `${pagingDto.keyword}`;
                let currentPage = `${pagingDto.currentPage + 1}`

                if (keyword) {
                    location.href = "/?page=" + currentPage + "&keyword=" + keyword;
                } else {
                    location.href = "/?page=" + currentPage;
                }
            }
        </script>
        <%@ include file="../layout/footer.jsp" %>