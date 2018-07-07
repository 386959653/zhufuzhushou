<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<h2>自定义登录页面</h2>
<form action="/user/login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="test"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" value="123"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">登录</button>
            </td>
        </tr>
    </table>
</form>
<#if error ??>
<h4>用户名或密码错误，请重新输入</h4>
</#if>
</body>
</html>