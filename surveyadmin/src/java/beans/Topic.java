package beans;

import dao.TopicDAO;
import java.util.List;
import javax.faces.event.ActionEvent;


public class Topic {
    private String title, id, addedon, uname , message;

    public Topic() {
    }


    public Topic(String id, String title, String addedon, String uname) {
        this.title = title;
        this.id = id;
        this.addedon = addedon;
        this.uname = uname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddedon() {
        return addedon;
    }
    public void setAddedon(String addedon) {
        this.addedon = addedon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void add(ActionEvent evt) {
        boolean done = TopicDAO.add( Request.getSession().getAttribute("uname").toString() , title);
        if ( done )
            message = "Topic has been added!";
        else
            message = "Sorry! Topic was not added!";
    }

    public List<Topic> getTopics() {
        return TopicDAO.getTopics();
    }

    public List<Question> getQuestions() {
        // get id from querystring
        return TopicDAO.getQuestions( Request.getRequest().getParameter("topicid"));
    }

     public List<SurveyResult> getSurveyResults() {
        // get id from querystring
        return TopicDAO.getSurveyResults(Request.getRequest().getParameter("topicid"));
    }
    

}
