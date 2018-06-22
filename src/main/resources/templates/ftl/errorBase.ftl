<#import "base.ftl" as ListPage>
<#macro Html title="" css="">
    <@ListPage.Html title="${title}" css="${css}">
<div id="top">
    <p><a href="/logout">退出</a></p>
</div>
 <div>
        <#nested>
 </div>
    </@ListPage.Html>
</#macro>