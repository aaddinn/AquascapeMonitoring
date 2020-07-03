package me.crackn.aquascapemonitoring;

public class modelData {
    private float suhu;
    private float ph;
    private String status;

    public modelData() {
    }

    public modelData(float suhu, float ph, String status) {
        this.suhu = suhu;
        this.ph = ph;
        this.status = status;
    }

    public float getSuhu() {
        return suhu;
    }

    public void setSuhu(float suhu) {
        this.suhu = suhu;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
