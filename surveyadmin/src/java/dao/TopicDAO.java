package dao;

import beans.Question;
import beans.SurveyResult;
import beans.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopicDAO {

    public static boolean add(String uname, String title) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement("insert into topics values(topicid_sequence.nextval,?,sysdate,?)");
            ps.setString(1, title);
            ps.setString(2, uname);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception ex) {
            System.out.println("Error in Topic.add() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(con);
        }
    }

    public static boolean delete(String topicid) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("delete from questions where topicid = ?");
            ps.setString(1, topicid);
            ps.executeUpdate();

            ps = con.prepareStatement("delete from topics where topicid = ?");
            ps.setString(1, topicid);
            ps.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Error in Topic.delete() -->" + ex.getMessage());
            try {
                con.rollback();
            } catch (Exception nex) {
            }
            return false;
        } finally {
            Database.close(con);
        }
    }

    public static boolean deleteQuestion(String questionid) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement("delete from questions where questionid = ?");
            ps.setString(1, questionid);
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Error in Topic.deleteQuestion() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(con);
        }
    }

    public static boolean addQuestion(Question q) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement("insert into questions values(questionid_sequence.nextval,?,?,?,?,?)");
            ps.setString(1, q.getText());
            ps.setString(2, q.getOpt1());
            ps.setString(3, q.getOpt2());
            ps.setString(4, q.getOpt3());
            ps.setString(5, q.getTopicid());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception ex) {
            System.out.println("Error in Topic.addQuestion() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(con);
        }
    }

    public static ArrayList<Topic> getTopics() {
        try {
            Connection con = Database.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from topics order by topictitle");
            ArrayList<Topic> al = new ArrayList<Topic>();
            while (rs.next()) {
                al.add(new Topic(rs.getString("topicid"), rs.getString("topictitle"), rs.getString("addedon"), rs.getString("uname")));
            }
            rs.close();
            return al;
        } catch (Exception e) {
            System.out.println("Error In TopicDAO.getTopics() -->" + e.getMessage());
            return (null);
        }
    }

    public static int getSurveyCount(String topicid) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select count(*) from answers_master where topicid = ?");
            ps.setString(1, topicid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            return count;
        } catch (Exception e) {
            System.out.println("Error In TopicDAO.getSurveyCount() -->" + e.getMessage());
            return -1;
        }
    }

    public static ArrayList<SurveyResult> getSurveyResults(String topicid) {
        try {
            Connection con = Database.getConnection();

            // get survey count

            PreparedStatement ps = con.prepareStatement("select count(*) cnt from answers_master where topicid = ?");
            ps.setString(1, topicid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            ps.close();

            // get questions for topic

            PreparedStatement psq = con.prepareStatement(
                    "select * from questions where topicid = ?");
            psq.setString(1, topicid);

            ArrayList<SurveyResult> al = new ArrayList<SurveyResult>();
            ResultSet questions = psq.executeQuery();

            while (questions.next()) {

                SurveyResult sr = new SurveyResult();
                sr.setQuestion(questions.getString("questiontext"));
                sr.setOption1(questions.getString("opt1"));
                sr.setOption2(questions.getString("opt2"));
                sr.setOption3(questions.getString("opt3"));

                // sum answers for a question
                PreparedStatement psa = con.prepareStatement(
                        "select sum(decode(answer,1,1,0)) opt1count, sum(decode(answer,2,1,0)) opt2count, sum(decode(answer,3,1,0)) opt3count from answers_details where questionid = ?");
                psa.setString(1, questions.getString("questionid"));

                ResultSet answers = psa.executeQuery();
                answers.next();

                // calculate % 
                sr.setOpt1count( (int) ((double) answers.getInt(1) / count * 100) );
                sr.setOpt2count((int) ((double) answers.getInt(2) / count * 100));
                sr.setOpt3count((int) ((double) answers.getInt(3) / count * 100));
                answers.close();
                al.add(sr);
            }

            return al;
        } catch (Exception e) {
            System.out.println("Error In TopicDAO.getSurveyResults() -->" + e.getMessage());
            return null;
        }
    }

    public static ArrayList<Question> getQuestions(String topicid) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from questions where topicid = ? order by questionid");
            ps.setString(1, topicid);
            ResultSet rs = ps.executeQuery();

            ArrayList<Question> al = new ArrayList<Question>();
            while (rs.next()) {
                al.add(new Question(rs.getString("questionid"), rs.getString("questiontext"), rs.getString("opt1"), rs.getString("opt2"), rs.getString("opt3")));
            }
            rs.close();
            return al;
        } catch (Exception e) {
            System.out.println("Error In TopicDAO.getQuestions() -->" + e.getMessage());
            return (null);
        }
    }
}
