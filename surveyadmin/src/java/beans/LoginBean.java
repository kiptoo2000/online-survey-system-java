package beans;
import dao.UserDAO;

public class LoginBean {
    private String uname,password, message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public LoginBean() {
    }

    public String login() {
        boolean result = UserDAO.login(uname, password);
        if ( result)  {
            Request.getSession().setAttribute("uname",uname);
            return "home";
        }
        else {
            message = "Invalid Login. Please Try Again!";
            return "login";
        }


    }
}
