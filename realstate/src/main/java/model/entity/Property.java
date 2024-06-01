package model.entity;

public class Property {
    private int idCustomer;
    private int enrollmentId;
    private String propertyName;
    private long basePrice;
    private String propertyAddress;
    private String offerType;
    private String propertyType;
    private String propertyStatus;
    private String furnishedStatus;
    private int bhk;
    private int bedrooms;
    private int bathrooms;
    private int balcony;
    private int propertyAge;
    private int floor;
    private String propertyDescription;
    private boolean lifts;
    private boolean securityGuard;
    private boolean playGround;
    private boolean garden;
    private boolean waterSupply;
    private boolean powerBackUp;
    private boolean parkingArea;
    private boolean gym;
    private boolean shopingMall;
    private boolean hospital;
    private boolean school;

    public Property() {
    }

    public Property(int balcony, long basePrice, int bathrooms, int bedrooms, int bhk, int enrollmentId, int floor, String furnishedStatus, boolean garden, boolean gym, boolean hospital, int idCustomer, boolean lifts, String offerType, boolean parkingArea, boolean playGround, boolean powerBackUp, String propertyAddress, int propertyAge, String propertyDescription, String propertyName, String propertyStatus, String propertyType, boolean school, boolean securityGuard, boolean shopingMall, boolean waterSupply) {
        this.balcony = balcony;
        this.basePrice = basePrice;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.bhk = bhk;
        this.enrollmentId = enrollmentId;
        this.floor = floor;
        this.furnishedStatus = furnishedStatus;
        this.garden = garden;
        this.gym = gym;
        this.hospital = hospital;
        this.idCustomer = idCustomer;
        this.lifts = lifts;
        this.offerType = offerType;
        this.parkingArea = parkingArea;
        this.playGround = playGround;
        this.powerBackUp = powerBackUp;
        this.propertyAddress = propertyAddress;
        this.propertyAge = propertyAge;
        this.propertyDescription = propertyDescription;
        this.propertyName = propertyName;
        this.propertyStatus = propertyStatus;
        this.propertyType = propertyType;
        this.school = school;
        this.securityGuard = securityGuard;
        this.shopingMall = shopingMall;
        this.waterSupply = waterSupply;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getFurnishedStatus() {
        return furnishedStatus;
    }

    public void setFurnishedStatus(String furnishedStatus) {
        this.furnishedStatus = furnishedStatus;
    }

    public int getBhk() {
        return bhk;
    }

    public void setBhk(int bhk) {
        this.bhk = bhk;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public int getPropertyAge() {
        return propertyAge;
    }

    public void setPropertyAge(int propertyAge) {
        this.propertyAge = propertyAge;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public boolean isLifts() {
        return lifts;
    }

    public void setLifts(boolean lifts) {
        this.lifts = lifts;
    }

    public boolean isSecurityGuard() {
        return securityGuard;
    }

    public void setSecurityGuard(boolean securityGuard) {
        this.securityGuard = securityGuard;
    }

    public boolean isPlayGround() {
        return playGround;
    }

    public void setPlayGround(boolean playGround) {
        this.playGround = playGround;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(boolean waterSupply) {
        this.waterSupply = waterSupply;
    }

    public boolean isPowerBackUp() {
        return powerBackUp;
    }

    public void setPowerBackUp(boolean powerBackUp) {
        this.powerBackUp = powerBackUp;
    }

    public boolean isParkingArea() {
        return parkingArea;
    }

    public void setParkingArea(boolean parkingArea) {
        this.parkingArea = parkingArea;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public boolean isShopingMall() {
        return shopingMall;
    }

    public void setShopingMall(boolean shopingMall) {
        this.shopingMall = shopingMall;
    }

    public boolean isHospital() {
        return hospital;
    }

    public void setHospital(boolean hospital) {
        this.hospital = hospital;
    }

    public boolean isSchool() {
        return school;
    }

    public void setSchool(boolean school) {
        this.school = school;
    }

    


}
