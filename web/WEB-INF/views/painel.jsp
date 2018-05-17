<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel do Sinal de Trânsito</title>
    </head>
    <body>
        <h1>Painel do Sinal de Trânsito</h1>
        <form method="POST">
            Alterar para:
            <select name="estado">
                <option value="R" ${aceso == 'R' ? 'selected' : ''}>Vermelho</option>
                <option value="Y" ${aceso == 'Y' ? 'selected' : ''}>Amarelo</option>
                <option value="G" ${aceso == 'G' ? 'selected' : ''}>Verde</option>
            </select>
            <button>Enviar</button>
        </form>
    </body>
</html>
