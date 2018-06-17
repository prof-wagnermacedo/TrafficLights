<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="baseUrl" value="/" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sinais de Trânsito</title>
        <script>setTimeout(() => { location.reload(); }, 5000);</script>
        <style>
            .estado {
                display: inline-block;
                text-align: center;
                vertical-align: middle;
                margin-bottom: 0.25em;
                border-radius: 100%;
                width: 1em;
                height: 1em;
            }

            .R { background-color: red; }
            .Y { background-color: yellow; }
            .G { background-color: green; }

            a:link, a:visited {
                color: blue;
            }
        </style>
    </head>
    <body>
        <h1>Sinais de Trânsito</h1>
        <ul>
            <c:forEach var="semaforo" items="${semaforos}">
                <li>
                    <span class="estado ${semaforo.estado}"></span>
                    <a href="${baseUrl}/sinal/${semaforo.id}">${semaforo.id}</a>
                    <a href="${baseUrl}/painel/${semaforo.id}">Painel</a>
                </li>
            </c:forEach>
        </ul>
        <p>
            <a href="${baseUrl}/painel/add">Adicionar mais sinais</a>
        </p>
    </body>
</html>
