import java.util.ArrayList;
import java.util.List;

public class DoorMan {
    protected List<ParkingLot> parkingLots;
    protected ParkingRule parkingRule;

    public DoorMan(ParkingRule parkingRule){
        this.parkingRule = parkingRule;
        this.parkingLots = new ArrayList<ParkingLot>();
    }

    public Receipt park(Car car) {
        ParkingLot suitableLots = getParkingRule().getSuitableLots(parkingLots);
        return suitableLots.park(car);
    }

    private ParkingRule getParkingRule() {
        return parkingRule;
    }

    public Car fetchCar(Receipt receipt) {
        for (ParkingLot lot : parkingLots) {
            Car car = lot.fetchCar(receipt);
            if (car != null)
                return car;
        }
        return null;
    }

    public void manage(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
