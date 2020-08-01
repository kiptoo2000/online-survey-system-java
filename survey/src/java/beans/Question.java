package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
public class Question {
    private String id, text, answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SelectItem[] getOptions() {
        return options;
    }

    public void setOptions(SelectItem[] options) {
        this.options = options;
    }
    private SelectItem options[] = new SelectItem[3];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Question() {
    }
    public Question(String id, String text, String opt1, String opt2, String opt3) {
        this.id = id;
        this.text = text;
        this.options[0] = new SelectItem(1,opt1);
        this.options[1] = new SelectItem(2,opt2);
        this.options[2] = new SelectItem(3,opt3);
    }
}
