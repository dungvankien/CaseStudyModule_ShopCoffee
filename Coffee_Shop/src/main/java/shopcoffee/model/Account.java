package shopcoffee.model;

public class Account {
    private int idAccount;
    private  String username;
    private String password;
    private int limitAccount;

    public Account() {
    }

    public Account(int idAccount, String username, String password, int limitAccount) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.limitAccount = limitAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLimitAccount() {
        return limitAccount;
    }

    public void setLimitAccount(int limitAccount) {
        this.limitAccount = limitAccount;
    }
}
