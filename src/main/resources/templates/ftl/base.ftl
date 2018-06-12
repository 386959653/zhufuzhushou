<#macro Html title="" css="">

<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>${title}</title>
    <style>
            ${css}
    </style>
</head>

<body>
<div id="top">
    <p><a href="/logout">退出</a></p>
</div>
<div>
        <#nested>
</div>
</body>

</html>

</#macro>