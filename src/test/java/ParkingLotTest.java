import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("1");
    }

    @Test
    public void should_park_car_in_the_parking_lot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);

        parkingLot.park(car);
        parkingLot.park(new Car("2"));
        parkingLot.park(new Car("3"));

        assertThat(parkingLot.contains(car),is(true));
    }

    @Test
    public void should_not_park_car_when_parking_lot_is_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(0);

        parkingLot.park(car);

        assertThat(parkingLot.contains(car),is(false));
    }

    @Test
    public void should_get_car_when_you_have_token() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5);

        String parkToken = parkingLot.park(car);

        assertThat(parkingLot.pullOutCar(parkToken),is(car));
    }

    @Test
    public void should_not_get_car_when_token_is_wrong() throws Exception {

        ParkingLot parkingLot = new ParkingLot(0);

        parkingLot.park(car);

        assertThat(parkingLot.pullOutCar("miss"),nullValue());
    }
}
