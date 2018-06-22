<#import "base.ftl" as ListPage>
<#macro Html title="" css="">
    <@ListPage.Html title="${title}" css="${css}">
<div class="page-wrapper">
    <div class="column-menu column-menu-task">
        <div class="logo-wrap" id="switch-workplace">
            <img class="icon-m" src="../img/defaultAvatar.jpg" alt=""><i class="m-icon-black-frame">&nbsp;</i>
            <div class="user-name">用户名</div>
        </div>
        <hr>

        <div class="main-menu">
            <a href="#/task/list?version=person&amp;id=199419" class="active"><i class="glyphicon glyphicon-pencil">&nbsp;</i>点菜
            </a>
            <a href="#/note/list?version=person&amp;id=199419"><i class="m-icon-note">&nbsp;</i>我的订单</a>
            <hr>
            <a href="#/note/list?version=person&amp;id=199419"><i class="m-icon-task">&nbsp;</i>购买清单</a>
        </div>
        <hr>

        <div class="menu-bottom" style="margin-bottom: 0;height: 138px;width: 120px;">
            <a href="#/search/list?version=person&amp;id=199419"><i class="glyphicon glyphicon-log-out"
                                                                    style="font-size: medium">&nbsp;</i>退出</a>
        </div>

    </div>
    <#nested>
</div>
</@ListPage.Html>
</#macro>