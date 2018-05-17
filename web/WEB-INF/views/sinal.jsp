<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            div.sinal {
                width: 100px;
                height: 100px;
                margin-bottom: 10px;
                border-radius: 100%;
            }

            div.vermelho {
                background: red;
            }

            div.amarelo {
                background: yellow;
            }

            div.verde {
                background: green;
            }

            div.sinal:not(.aceso) {
                opacity: 0.25;
            }
        </style>
        <title>Sinal de Trânsito</title>
    </head>
    <body>
        <h1>Sinal de Trânsito</h1>
        <div class="sinal vermelho ${aceso == 'R' ? 'aceso' : ''}"></div>
        <div class="sinal amarelo ${aceso == 'Y' ? 'aceso' : ''}"></div>
        <div class="sinal verde ${aceso == 'G' ? 'aceso' : ''}"></div>
    </body>
</html>
