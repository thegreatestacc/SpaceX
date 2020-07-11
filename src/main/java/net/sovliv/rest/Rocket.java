package net.sovliv.rest;

public class Rocket {
    private String rocket_id;

    public Rocket() {
    }

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "rocket_id='" + rocket_id + '\'' +
                '}';
    }
}
