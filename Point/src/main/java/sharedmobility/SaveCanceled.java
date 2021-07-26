package sharedmobility;

public class SaveCanceled extends AbstractEvent {

    private Long id;
    private Long payId;
    private Long pointId;
    private String pointChangeDate;
    private String pointSataus;

    public SaveCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
    public String getPointChangeDate() {
        return pointChangeDate;
    }

    public void setPointChangeDate(String pointChangeDate) {
        this.pointChangeDate = pointChangeDate;
    }
    public String getPointSataus() {
        return pointSataus;
    }

    public void setPointSataus(String pointSataus) {
        this.pointSataus = pointSataus;
    }
}
