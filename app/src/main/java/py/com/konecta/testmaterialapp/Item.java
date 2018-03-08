package py.com.konecta.testmaterialapp;

/**
 * Created by Francisco on 25/02/2018.
 */

public class Item {

    private String linea1;
    private String linea2;
    private String linea3;

    public Item() {
    }

    public Item(String linea1, String linea2, String linea3) {
        this.linea1 = linea1;
        this.linea2 = linea2;
        this.linea3 = linea3;
    }

    public String getLinea1() {
        return linea1;
    }

    public void setLinea1(String linea1) {
        this.linea1 = linea1;
    }

    public String getLinea2() {
        return linea2;
    }

    public void setLinea2(String linea2) {
        this.linea2 = linea2;
    }

    public String getLinea3() {
        return linea3;
    }

    public void setLinea3(String linea3) {
        this.linea3 = linea3;
    }
}
