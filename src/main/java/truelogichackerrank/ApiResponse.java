package truelogichackerrank;

public class ApiResponse {
    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer totalPages;
    private Show[] data;

    public ApiResponse() {
    }

    public ApiResponse(Integer page, Integer perPage, Integer total, Integer totalPages, Show[] data) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Show[] getData() {
        return data;
    }

}
