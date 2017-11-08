/**
 * Created by josue on 07/11/17.
 */
public class IpData {
    private String realIp;
    private String fakeIp;
    private String fakePath;
    private int distance;
    private int port;

    public IpData(String realIp, String fakeIp, String fakePath,int distance, int port){
        this.realIp = realIp;
        this.fakeIp = fakeIp;
        this.fakePath = fakePath;
        this.distance = distance;
        this.port = port;
    }

    public String getRealIp() {
        return this.realIp;
    }

    public String getFakeIp() {
        return this.fakeIp;
    }

    public String getFakePath() {
        return this.fakePath;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getPort(){ return this.port; }
}