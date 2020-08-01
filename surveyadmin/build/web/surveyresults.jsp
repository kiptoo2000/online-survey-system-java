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
            <title>Survey Results</title>
        </head>
        <body>
            <h:form  id="surveyResults">
                <%@include file="header.html"%>
                <table style="width:100%;height:600px">
                    <tr>
                        <td class="menu">
                            <%@include file="menu.jsp"%>
                        </td>
                        <td style="vertical-align: top">
                            <h2>Survey Results</h2>
                                    <h:dataTable  value="#{topic.surveyResults}" var="question" border="1" width="100%">
                                        <h:column>
                                            <f:facet name="header"><f:verbatim>Question</f:verbatim> </f:facet>
                                            <h:outputText value="#{question.question}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Option1</f:verbatim> </f:facet>
                                            <h:outputText value="#{question.option1}"/>
                                            : 
                                            <h:outputText value="#{question.opt1count}"/>%
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header"> <f:verbatim>Option2</f:verbatim>
                                            </f:facet>
                                            <h:outputText value="#{question.option2}"/>
                                            :
                                            <h:outputText value="#{question.opt2count}"/>%
                                        </h:column>
                                            <h:column>
                                            <f:facet name="header"> <f:verbatim>Option3</f:verbatim>
                                            </f:facet>
                                            <h:outputText value="#{question.option3}"/>
                                            :
                                            <h:outputText value="#{question.opt3count}"/>%
                                        </h:column>
                                    </h:dataTable>
                                </td>
                        </tr>
                </table>
            </h:form>
        </body>
    </html>
</f:view>


