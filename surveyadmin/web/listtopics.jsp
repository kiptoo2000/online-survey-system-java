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
            <h:form  id="listTopicsForm">
                <%@include file="header.html"%>
                <table  style="width:100%;height:600px">
                    <tr>
                        <td style="width:15%; vertical-align:top;background-color:lightgreen">
                            <%@include file="menu.html"%>
                        </td>
                        <td style="vertical-align: top">
                            <h2>Topics</h2>
                                    <h:dataTable value="#{topic.topics}" var="topic" border="1" width="100%">
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Title</f:verbatim> </f:facet>
                                            <h:outputText value="#{topic.title}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Added On</f:verbatim> </f:facet>
                                            <h:outputText value="#{topic.addedon}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Added By</f:verbatim>
                                            </f:facet>
                                            <h:outputText value="#{topic.uname}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>&nbsp;</f:verbatim> </f:facet>
                                            <h:outputLink value="deletetopic.jsp"
                                                     onclick="return confirm('Do you want to delete topic and all its questions?')" >
                                                <h:outputText value="Delete"/>
                                                <f:param name="topicid" value="#{topic.id}"/>
                                            </h:outputLink>
                                            &nbsp;
                                            <h:outputLink value="addquestion.jsp">
                                                <h:outputText value="Add Question"/>
                                                <f:param name="topicid" value="#{topic.id}"/>
                                            </h:outputLink>
                                            &nbsp;
                                            <h:outputLink value="topicquestions.jsp">
                                                <h:outputText value="Questions"/>
                                                <f:param name="topicid" value="#{topic.id}"/>
                                            </h:outputLink>
                                        </h:column>
                                    </h:dataTable>
                                </td>
                        </tr>
                </table>
            </h:form>
        </body>
    </html>
</f:view>


