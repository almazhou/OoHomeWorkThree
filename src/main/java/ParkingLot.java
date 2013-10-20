import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int lotNum;
    private Map<String, Car> carMap;

    public ParkingLot(int lotNum) {
        this.lotNum = lotNum;
        this.carMap = new HashMap<String, Car>();
    }

    public String park(Car car) {
        if(lotNum == carMap.entrySet().size()) return null;
        String key = generateKey(car.getToken());
        carMap.put(key,car);
        return key;
    }

    private String generateKey(String token) {
        return "1234"+token;
    }

    public boolean contains(Car car) {
        return carMap.containsValue(car);
    }

    public Car pullOutCar(String parkToken) {
        return carMap.get(parkToken);
    }

    public int getCarNum() {
        return carMap.keySet().size();
    }

    public int getLotNum() {
        return lotNum;
    }

    public boolean hasThisToken(String token) {
        return carMap.keySet().contains(token);
    }
}
