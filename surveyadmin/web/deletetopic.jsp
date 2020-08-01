<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <%@include file="header.html"%>
                <table  style="width:100%;height:600px">
                    <tr>
                        <td class="menu">
                            <%@include file="menu.jsp"%></td>
                        <td style="vertical-align: top">
                            <%
                               boolean  done = dao.TopicDAO.delete( request.getParameter("topicid"));
                               if ( done )
                                     out.println("<h3>Deleted Topic Successfully! </h3>");

                               else
                                     out.println("<h3>Could not delete topic!</h3>");

                            %>

                        </td>
                    </tr>
                </table>

        
    </body>
</html>

