package apiTests.reqresTests.framework.apiTemplates;

public class SuccessReg {
    private Integer id;
    private String token;

    public SuccessReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessReg() {
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
