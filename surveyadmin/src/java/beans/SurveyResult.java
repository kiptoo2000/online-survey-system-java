package beans;


public class SurveyResult {
   private String question, option1, option2,option3;
   private int opt1count, opt2count,opt3count;

    public SurveyResult() {
    }

    public SurveyResult(String question, String option1, String option2, String option3, int opt1count, int opt2count, int opt3count) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.opt1count = opt1count;
        this.opt2count = opt2count;
        this.opt3count = opt3count;
    }

    public int getOpt1count() {
        return opt1count;
    }

    public void setOpt1count(int opt1count) {
        this.opt1count = opt1count;
    }

    public int getOpt2count() {
        return opt2count;
    }

    public void setOpt2count(int opt2count) {
        this.opt2count = opt2count;
    }

    public int getOpt3count() {
        return opt3count;
    }

    public void setOpt3count(int opt3count) {
        this.opt3count = opt3count;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
