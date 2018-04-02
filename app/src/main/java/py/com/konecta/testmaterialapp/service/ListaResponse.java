package py.com.konecta.testmaterialapp.service;

import java.util.List;

public class ListaResponse<T> {

    private int count;
    private List<T> rows;

    public ListaResponse() {
    }

    public ListaResponse(int count, List<T> rows) {
        this.count = count;
        this.rows = rows;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
