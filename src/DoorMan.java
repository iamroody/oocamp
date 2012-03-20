import java.util.ArrayList;
import java.util.List;

public class DoorMan implements ParkingFacility {
    protected List<ParkingFacility> parkingLots;
    protected SuperParkingRule superRule;

    public DoorMan(ParkingRule parkingRule) {
        this(new SuperRuleAdapter(parkingRule));
    }


    public DoorMan(SuperParkingRule superRule) {
        this.superRule = superRule;
        this.parkingLots = new ArrayList<ParkingFacility>();
    }


    public static class SuperRuleAdapter implements SuperParkingRule {
        private ParkingRule rule;

        public SuperRuleAdapter(ParkingRule rule) {
            this.rule = rule;
        }

        public ParkingLot getSuitableLots(List<ParkingFacility> input) {
            return rule.getSuitableLots(getParkingLots(input));
        }
    }

    public Receipt park(Car car) {
        ParkingLot suitableLots = superRule.getSuitableLots(parkingLots);
        return suitableLots.park(car);
    }

    private static List<ParkingLot> getParkingLots(List<ParkingFacility> parkingLots) {
        List<ParkingLot> result = new ArrayList<ParkingLot>();
        for (ParkingFacility facility : parkingLots) {
            if (facility instanceof ParkingLot)
                result.add((ParkingLot) facility);
        }
        return result;
    }

    public Car fetchCar(Receipt receipt) {
        for (ParkingFacility lot : parkingLots) {
            Car car = lot.fetchCar(receipt);
            if (car != null)
                return car;
        }
        return null;
    }

    public void manage(ParkingFacility parkingLot) {
        parkingLots.add(parkingLot);
    }
}
