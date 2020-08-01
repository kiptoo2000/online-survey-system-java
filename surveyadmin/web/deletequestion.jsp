<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Question</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
                <%@include file="header.html"%>
                <table  style="width:100%;height:600px">
                    <tr>
                        <td class="menu">
                            <%@include file="menu.jsp"%>
                        </td>
                        <td style="vertical-align: top">
                            <%
                               boolean  done = dao.TopicDAO.deleteQuestion( request.getParameter("questionid"));
                               if ( done ) 
                                     out.println("<h3>Deleted Question Successfully! </h3>");
                               else
                                     out.println("<h3>Could Not Delete Question!</h3>");

                            %>
                            Click <a href="topicquestions.jsp?topicid=${sessionScope.topicid}">here</a> to go back to questions in the topic.
                        </td>
                    </tr>
                </table>
                <p/>
               
    </body>
</html>

