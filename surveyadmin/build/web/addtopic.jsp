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
             <h:form  id="addTopicForm">
                <%@include file="header.html"%>
                <table  style="width:100%;height:600px">
                    <tr>
                        <td class="menu">
                            <%@include file="menu.jsp"%>
                        </td>
                        <td style="vertical-align: top">
                            <h2>Add Topic </h2>
                            Topic Title : <h:inputText id="topictitle" value="#{topic.title}" required="true" style="width:350px" />
                            <p/>
                            <h:commandButton actionListener="#{topic.add}" value="Add Topic" />
                            <p/>
                            <h3><h:outputText value="#{topic.message}"/> </h3>
                        </td>
                    </tr>
                </table>
            </h:form>
        </body>
    </html>
</f:view>
