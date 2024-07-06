package mission.Nike;

public class NikeSneakers {
    private String nikeSneakersFeature; // 안정감 | 편안함 | 가벼움 등 신발 특징
    private long nikeSneakersPrice;
    private boolean havingNikeSneakersInStore; // 매장 Nike sneakers 재고 여부
    private boolean isWrapped = false;

    public NikeSneakers(String nikeSneakersFeature, long nikeSneakersPrice, boolean havingNikeSneakersInStore) {
        this.nikeSneakersFeature = nikeSneakersFeature;
        this.nikeSneakersPrice = nikeSneakersPrice;
        this.havingNikeSneakersInStore = havingNikeSneakersInStore;
    }

    public String getNikeSneakersFeature() {
        return nikeSneakersFeature;
    }

    public long getNikeSneakersPrice() {
        return nikeSneakersPrice;
    }

    public boolean isHavingNikeSneakersInStore() {
        return havingNikeSneakersInStore;
    }

    public boolean setWrapped(boolean wrapped) {
        isWrapped = wrapped;
        return isWrapped;
    }
}
