// 创建新的函数
function getLoginStatus() {
    $.ajax({
        type:'get',
        url:'login',
        success: function(body) {
            // 得到 200 ， 此处不做任何工作
            console.log("当前已经登录过了！");
        },
        error: function() {
            //得到 403 (非 2 开头的状态码都会触发这个 error 分支）
            //让页面强行跳转到 login.html
            console.log("当前还未登录!");
            location.assign('login.html');
        }
    })
}