import java.util.ArrayList;
import java.util.List;

public class DoorMan {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    public DoorMan() {
        parkingLots = new ArrayList<ParkingLot>();
    }

    public void manage(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Receipt park(Car car) {
        for (ParkingLot lot : parkingLots) {
            Receipt receipt = lot.park(car);
            if(receipt != null)
                return receipt;
        }
        return null;
    }

    public Car fetchCar(Receipt receipt) {
        for (ParkingLot lot : parkingLots) {
            Car car = lot.fetchCar(receipt);
            if(car != null)
                return car;
        }
        return null;
    }
}
