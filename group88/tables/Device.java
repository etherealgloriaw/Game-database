package group88.tables;

import java.util.Date;

//Device(DeviceID, systemVersion, UserID), userID cannot be NULL
//(D12345,3.1,U12345)
public class Device {
    private final String DeviceID;
    private Float systemVersion;
    private String UserID;

    public Device(String deviceID, Float systemVersion, String userID) {
        this.DeviceID = deviceID;
        this.systemVersion = systemVersion;
        this.UserID = userID;
    }

    public String getDeviceID(){
        return DeviceID;
    }

    public Float getsystemVersion(){
        return systemVersion;
    }

    public String getUserID(){
        return UserID;
    }

    public void setsystemVersion(Float systemVersion){
        this.systemVersion = systemVersion;
    }

    public void setUserID(String userID){
        this.UserID = UserID;
    }




}
