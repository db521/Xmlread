package zhang.xmlread;

/**
 * Created by zhang on 16/6/23.
 */
public class City {
    private String name;
    private String temp;
    private String pm25;

    public City() {
        this.name = name;
        this.temp = temp;
        this.pm25 = pm25;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
