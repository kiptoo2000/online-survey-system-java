<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" href="styles.css" />
            <title>Add Topic</title>

        </head>
        <body>
             <h:form  id="addQuestionForm">
                <%@include file="header.html"%>
                <table  style="width:100%;height:600px">
                    <tr>
                        <td class="menu">
                            <%@include file="menu.jsp"%>
                        </td>
                        <td style="vertical-align: top">
                            <h2>Add Question</h2>
                            <table>
                                <tr>
                                    <td>Question Text :</td>
                                    <td>
                                        <h:inputText id="text" value="#{question.text}" required="true" style="width:350px" requiredMessage="Question text is requierd!" />
                                        <h:message  for="text"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Option 1 :</td>
                                    <td>
                                        <h:inputText id="opt1" value="#{question.opt1}" required="true" style="width:150px"   requiredMessage="Option 1 is requierd!" />
                                        <h:message  for="opt1"/>
                                    </td>
                                </tr>


                                <tr>
                                    <td>Option 2 :</td>
                                    <td>
                                        <h:inputText id="opt2" value="#{question.opt2}" required="true" style="width:150px"  requiredMessage="Option 2 is requierd!"  />
                                        <h:message  for="opt2"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Option 3 :</td>
                                    <td>
                                        <h:inputText id="opt3" value="#{question.opt3}" required="true" style="width:150px"  requiredMessage="Option 3 is requierd!"  />
                                        <h:message  for="opt3"/>
                                    </td>
                                </tr>
                            </table>
                            <p/>
                            <h:commandButton actionListener="#{question.add}" value="Add Question"/>
                            <p/>
                            <h3><h:outputText value="#{question.message}"/> </h3>
                        </td>
                    </tr>
                </table>
            </h:form>

            <%
               if ( request.getParameter("topicid") != null)
                         session.setAttribute("topicid", request.getParameter("topicid"));
            %>
        </body>
    </html>
</f:view>