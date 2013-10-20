import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    public void manageParkingLot(ParkingLot parkingLot) {
         this.parkingLotList.add(parkingLot);
    }

    public String park(Car car) {
        for(ParkingLot lot : parkingLotList){
            if(lot.getCarNum()<lot.getLotNum()){
                return lot.park(car);
            }
        }
        return null;
    }

    public Car pullOutCar(String token) {
        for(ParkingLot lot : parkingLotList){
            if(lot.hasThisToken(token)){
                return lot.pullOutCar(token);
            }
        }
        return null;
    }
}
