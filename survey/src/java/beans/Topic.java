package beans;

import dao.TopicDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Topic {
    private String title, id;
    private ArrayList<Question> questions = null;
    private int position = 0;

    public int getPosition() {
        return position;
    }
    public Topic() {
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


    public Topic(String id, String title) {
        this.title = title;
        this.id = id;
    }

    public String process() {
         // get questions for the selected topic
         position = 0;
         questions  = TopicDAO.getQuestions(id);
         return "survey";
    }

    public ArrayList<SelectItem> getTopics() {
        ArrayList<Topic>  lst = TopicDAO.getTopics();
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();

        for ( Topic t : lst)
            items.add( new SelectItem( t.getId(), t.getTitle()));

        return items;
    }

    public Question getQuestion() {
        return  questions.get(position);
    }

    public int getQuestionCount() {
        return questions.size();
    }

    public void next(ActionEvent evt) {
          position ++;
    }

    public void previous(ActionEvent evt) {
          position --;
    }

    public String cancel() {
          return "index";
    }
   
    public String finish() {
        // process the results
        boolean done = TopicDAO.storeSurveyResults(id, questions);
        if ( done )
            return "finish";
        else
            return "error";
    }
    


}
