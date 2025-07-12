package lld.battlefield.model;

public class HitResponse {
    public boolean status;
    public HitLocation location;
    public String id;
    public String shipOwner;

    public HitResponse(boolean status, HitLocation location) {
        this.status = status;
        this.location = location;
    }
} 