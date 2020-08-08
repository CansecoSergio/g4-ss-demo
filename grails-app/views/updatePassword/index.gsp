<%--
  Created by IntelliJ IDEA.
  User: sergiocanseco
  Date: 08/08/20
  Time: 14:21
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cambio de Contraseña</title>
</head>

<body>
<div id='login'>
    <div class='inner'>
        <g:if test='${flash.message}'>
            <div class='login_message'>${flash.message}</div>
        </g:if>
        <div class='fheader'>Please update your password..</div>
        <g:form action='updatePassword' id='passwordResetForm' class='cssform' autocomplete='off'>
            <p>
                <label for='username'>Username</label>
                <span class='text_'>${username}</span>
            </p>

            <p>
                <label for='password'>Current Password</label>
                <g:passwordField name='password' class='text_'/>
            </p>

            <p>
                <label for='password'>New Password</label>
                <g:passwordField name='password_new' class='text_'/>
            </p>

            <p>
                <label for='password'>New Password (again)</label>
                <g:passwordField name='password_new_2' class='text_'/>
            </p>

            <p>
                <input type='submit' value='Reset'/>
            </p>
        </g:form>
    </div>
</div>
</body>
</html>