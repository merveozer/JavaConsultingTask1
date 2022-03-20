
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
    <title>JAVA | E-FATURA Kayıt Ol</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <h1 style = "color:darkorange "> JAVA E-Fatura Sistemine Hoşgeldiniz </h1>
    <br>
    <form action="<%= request.getContextPath() %>/register" method ="post" >      
        <input type="text" name="username" value="" />  <br> <br>
        <input type="password" name="password" value=""/>  <br> <br>
        <input style ="border-radius:5px;width:120px;height:30px" type="submit" value="Login" />  <br> <br>
    </form>
</body>
</html>
