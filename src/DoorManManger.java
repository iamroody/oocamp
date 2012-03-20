public class DoorManManger extends DoorMan {

    public DoorManManger(ParkingRule parkingRule) {
        super(parkingRule);
    }

    public Receipt park(Car car) {
        for (ParkingFacility doorMan : parkingLots) {
            Receipt receipt = doorMan.park(car);
            if(null != receipt) {
                return receipt;
            }
        }
        return null;
    }

}
