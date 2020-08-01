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
                            <h2>Topics</h2>
                                    <h:dataTable value="#{topic.questions}" var="question" border="1" width="100%">
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Question</f:verbatim> </f:facet>
                                            <h:outputText value="#{question.text}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Option1</f:verbatim> </f:facet>
                                            <h:outputText value="#{question.opt1}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Option2</f:verbatim>
                                            </f:facet>
                                            <h:outputText value="#{question.opt2}"/>
                                        </h:column>
                                            <h:column>
                                            <f:facet name="header"> <f:verbatim>Option3</f:verbatim>
                                            </f:facet>
                                            <h:outputText value="#{question.opt3}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>&nbsp;</f:verbatim> </f:facet>
                                            <h:outputLink value="deletequestion.jsp" onclick="return confirm('Do you want to delete question?','Confirmation')">
                                                <h:outputText value="Delete"/>
                                                <f:param name="questionid" value="#{question.id}"/>
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


