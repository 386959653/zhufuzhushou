<#import "../ftl/myPanelSidebar.ftl" as ListPage>

<@ListPage.Html title="点菜 - 煮妇助手">
<div class="main main-task" id="main"
     data-listwhere="{&quot;scope_start&quot;:1529596800,&quot;scope_end&quot;:1529683199,&quot;type&quot;:&quot;day&quot;,&quot;mode&quot;:&quot;four&quot;}"
     style="width: 1447px;">
    <div class="title">
        <div class="title-left">
            <div class="dropdown" id="dropdown-display-mode">菜品：
                <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                    全部<span class="caret"></span></button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="ul-task-mode">
                    <li role="presentation" id="mode-four" class="active">
                        <a role="menuitem" tabindex="-1" href="#" data-mode="four">全部</a>
                        <i class="m-icon-ok">&nbsp;</i></li>
                    <li role="presentation" id="mode-timeline">
                        <a role="menuitem" tabindex="-1" href="#" data-mode="timeline">荤菜</a>
                    </li>
                    <li role="presentation" id="mode-timeline">
                        <a role="menuitem" tabindex="-1" href="#" data-mode="timeline">素菜</a>
                    </li>
                    <li role="presentation" id="mode-timeline">
                        <a role="menuitem" tabindex="-1" href="#" data-mode="timeline">汤</a>
                    </li>
                </ul>
            </div>
        </div>

    </div>
    <div class="content" id="content" style="height: 546px;">
        <div class="box-task box-task2">
            <div id="ul-task-wrap-2" class="ul-task-wrap">
                <ul class="ul-task margin-l20"
                    style="transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1); transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);">
    <#list menuList as item>
        <li class="unfinished" style="display: list-item;">
            <div v-on:click="orderOrCancel('${item.id}',$event)"
                 class="icheckbox_todo-yellow <#if item.orderListId ??>checked</#if>" style="position: relative;">
                <input type="hidden" id="orderListId" value="${item.orderListId?if_exists?c}">
                <input type="checkbox" class="rank2"
                       style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">
                <ins class="iCheck-helper"
                     style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
            </div>
            <span class="task-name">${item.dishName}</span>
        </li>
    </#list>
                </ul>
                <div class="iScrollVerticalScrollbar iScrollLoneScrollbar"
                     style="position: absolute; z-index: 9999; width: 7px; bottom: 2px; top: 2px; right: 1px; overflow: hidden; transform: translateZ(0px); transition-duration: 0ms; opacity: 0;">
                    <div class="iScrollIndicator"
                         style="box-sizing: border-box; position: absolute; background: rgba(0, 0, 0, 0.498039); border: 1px solid rgba(255, 255, 255, 0.901961); border-radius: 3px; width: 100%; transition-duration: 0ms; display: none; height: 202px; transform: translate(0px, 0px) translateZ(0px); transition-timing-function: cubic-bezier(0.1, 0.57, 0.1, 1);"></div>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<script>
    var menu = new Vue({
        el: '#ul-task-wrap-2',
        data: {
            ajaxStatus: false
            , menuId: -1
            , orderListId: -1
        },
        methods: {
            orderOrCancel: function (menueId, event) {
                this.menuId = menueId;
                $.ajaxSettings.async = false;
                // 取消
                if ($(event.currentTarget).hasClass("checked")) {
                    this.orderListId = $(event.currentTarget.firstChild).val();
                    var url = "orderOrCancel?flag=cancel&orderListId=" + this.orderListId;
                    var _self = this;
                    AjaxHelper.post(url, function (data) {
                        if (data.status = "ok") {
                            _self.ajaxStatus = true;
                        }
                    });
                } else {// 选取
                    var url = "orderOrCancel?flag=order&menuId=" + this.menuId;
                    var _self = this;
                    AjaxHelper.post(url, function (data) {
                        if (data.status = "ok") {
                            _self.ajaxStatus = true;
                            if (data.data != undefined) {
                                $(event.currentTarget.firstChild).val(data.data)
                            }
                        }
                    });
                }
                if (this.ajaxStatus) {
                    event.currentTarget.classList.toggle("checked");
                }
            }
        }
    })
</script>
</@ListPage.Html>