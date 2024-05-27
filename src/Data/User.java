package Data;

import java.util.ArrayList;

public class User {
    public static ArrayList<User> usersList = new ArrayList<>();

    private String userName;
    private String key;
    private String idCard;
    private String phoneNumber;


    public User() {
    }

    public User(String userName, String key, String idCard, String phoneNumber) {
        this.userName = userName;
        this.key = key;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Data.User{userName = " + userName + ", key = " + key + ", idCard = " + idCard + ", phoneNumber = " + phoneNumber + "}";
    }
}
