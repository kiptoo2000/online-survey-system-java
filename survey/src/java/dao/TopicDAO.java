package dao;
import beans.Question;
import beans.Topic;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TopicDAO {
    public static ArrayList<Topic> getTopics() {
        try {
            Connection con = Database.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from topics order by topictitle");
            ArrayList<Topic> al = new ArrayList<Topic>();
            while (rs.next()) {
                al.add( new Topic(rs.getString("topicid"), rs.getString("topictitle")));
            }
            rs.close();
            return al;
        } catch (Exception e) {
            System.out.println("Error In TopicDAO.getTopics() -->" + e.getMessage());
            return (null);
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

     public static boolean storeSurveyResults(String topicid, ArrayList<Question> questions) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("insert into answers_master values( surveyid_sequence.nextval,?,sysdate)");
            ps.setString(1, topicid);
            ps.executeUpdate();

            ps = con.prepareStatement("insert into answers_details values( surveyid_sequence.currval, ?,?)");

            for( Question q : questions) {
                ps.setString(1, q.getId());
                ps.setString(2, q.getAnswer());
                ps.executeUpdate();
            }
            con.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Error in TopicDAO.storeSurveyResults() -->" + ex.getMessage());
            try {
                con.rollback();
            } catch (Exception nex) {
            }
            return false;
        } finally {
            Database.close(con);
        }
    }
}
