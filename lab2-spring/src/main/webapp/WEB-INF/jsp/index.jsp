<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tabulator</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <%--jQuery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<c:url var="home" value="/"/>
<div class="container">
    <div class="page-header">
        <h1>Tabulate lab function</h1>
    </div>
    <div class="container">
        <p><b>Function:</b><br>
            <c:forEach items="${function}" var="value">
                if ${value}, ${value.toString()}<br>
            </c:forEach>
        </p>
        <form:form method="post" modelAttribute="tabulatorForm"
                   action="${home}"
                   target="_top">
            <table class="table table-responsive">
                <tbody>
                <tr>
                    <td>
                        <form:label path="a">A *</form:label>
                        <form:input path="a" type="number" name="a" step="any" class="form-control"
                                    placeholder="2.4"
                                    value="${customerForm.a}" required="required"/>
                    </td>
                    <td>
                        <form:label path="start">Start of interval *</form:label>
                        <form:input path="start" type="number" name="start" step="any" class="form-control"
                                    placeholder="1"
                                    value="${customerForm.start}" required="required"/>
                    </td>
                    <td>
                        <form:label path="end">End of interval *</form:label>
                        <form:input path="end" type="number" name="start" step="any" class="form-control"
                                    placeholder="5"
                                    value="${customerForm.end}" required="required"/>
                    </td>
                    <td>
                        <form:label path="step">Delta of interval *</form:label>
                        <form:input path="step" type="number" name="start" step="any" class="form-control"
                                    placeholder="5"
                                    value="${customerForm.step}" required="required"/>
                    </td>
                    <td>
                        <label for="submit" class="btn btn-success">Tabulate <i
                                class="glyphicon glyphicon-chevron-right"></i></label>
                        <input id="submit" type="submit" value="Submit" class="hidden"/>
                    <td>
                </tr>
                <tr>
                    <td><form:errors path="a"/></td>
                    <td><form:errors path="start"/></td>
                    <td><form:errors path="end"/></td>
                    <td><form:errors path="step"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <c:if test="${not empty tabulator.results}">
            <p><b>Number of steps:</b> ${tabulator.results.size()}</p>
        </c:if>
        <table class="table-responsive table">
            <tr>
                <th>X</th>
                <th>Y</th>
            </tr>
            <c:forEach items="${tabulator.results}" var="point">
                <tr>
                    <td><fmt:formatNumber value="${point.x}" maxFractionDigits="2"/></td>
                    <td><fmt:formatNumber value="${point.y}" maxFractionDigits="2"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>