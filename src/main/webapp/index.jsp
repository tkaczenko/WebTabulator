<%@ page contentType="text/html;charset=UTF-8" %>
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
        <form action="${home}" method="post" target="_top">
            <table class="table table-responsive">
                <tr>
                    <td>
                        <input class="form-control" title="A" type="number" name="a" placeholder="A" step="any"
                               value="${a}">
                    </td>
                    <td>
                        <input class="form-control" title="Start" type="number" name="start"
                               placeholder="Start of interval"
                               step="any"
                               value="${start}">
                    </td>
                    <td>
                        <input class="form-control" title="End" type="number" name="end" placeholder="End of interval"
                               step="any"
                               value="${end}">
                    </td>
                    <td>
                        <input class="form-control" title="Step" type="number" name="step"
                               placeholder="Delta of interval"
                               step="any"
                               value="${step}">
                    </td>
                    <td>
                        <label for="submit" class="btn btn-success">Tabulate <i
                                class="glyphicon glyphicon-chevron-right"></i></label>
                        <input id="submit" type="submit" value="Submit" class="hidden"/>
                    </td>
                </tr>
            </table>
        </form>
        <c:if test="${not empty tabulator.results}">
            <p><b>Number of steps:</b> ${tabulator.results.size()}</p>
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
        </c:if>
    </div>
</div>
</body>
</html>
