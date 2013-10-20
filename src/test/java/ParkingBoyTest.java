import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;
    private Car car;

    @Before
    public void setUp() throws Exception {
        parkingBoy = new ParkingBoy();
        car = new Car("1");
        parkingBoy.manageParkingLot(new ParkingLot(1));
        parkingBoy.manageParkingLot(new ParkingLot(1));
    }

    @Test
    public void should_park_car_in_when_has_lot() throws Exception {
        String card = parkingBoy.park(car);

        assertThat(card,notNullValue());
    }

    @Test
    public void should_not_park_car_when_all_parking_lots_are_full() throws Exception {
       parkingBoy.park(new Car("2"));
       parkingBoy.park(new Car("3"));

        String park = parkingBoy.park(car);

        assertThat(park,nullValue());
    }

    @Test
    public void should_get_car_from_parking_boy_by_token() throws Exception {
        String token = parkingBoy.park(car);

        Car car1 = parkingBoy.pullOutCar(token);

        assertThat(car1.getToken(),is("1"));
    }

    @Test
    public void should_not_get_car_when_token_is_wrong() throws Exception {
        parkingBoy.park(car);

        Car miss = parkingBoy.pullOutCar("miss");
        assertThat(miss,nullValue());
    }

    @Test
    public void should_park_car_in_when_parking_boy_has_another_parkinglot() throws Exception {
        parkingBoy.manageParkingLot(new ParkingLot(1));

        parkingBoy.park(new Car("2"));
        parkingBoy.park(new Car("3"));
        String parkingToken = parkingBoy.park(car);
        assertThat(parkingToken,notNullValue());
    }
}
