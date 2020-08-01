<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Login Page</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <f:view>
            <h:form  id="loginform">
                <%@include file="header.html"%>

                <div align="center">
                                    <h3>Login </h3>
                    <table>
                        <tr>
                            <td style="text-align:right">Username: </td>
                            <td style="text-align:left">
                                <h:inputText id="uname" value="#{loginBean.uname}"
                                             required="true" style="width:150px" />
                        </tr>
                        <tr>
                            <td style="text-align:right">Password : </td>
                            <td style="text-align:left">
                                <h:inputSecret id="pwd" value="#{loginBean.password}"
                                               required="true"  style="width:150px"/>
                        </tr>
                    </table>
                    <p/>
                    <h:commandButton action="#{loginBean.login}" value="Login" />
                    <p/>
                    <h3><h:outputText value="#{loginBean.message}"/> </h3>
                </div>
            </h:form>
        </f:view>
    </body>
</html>
