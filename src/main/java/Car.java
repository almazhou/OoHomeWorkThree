public class Car {
    private final String name;
    private String token;

    public Car(String name) {
        this.name = name;
        this.token = name;
    }

    public String getToken() {
        return this.token;
    }
}
