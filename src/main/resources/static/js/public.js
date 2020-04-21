<!-- 正则验证 start-->
/**
 * 判空
 *
 * @param obj
 * @returns {boolean}
 */
function isNull(obj) {
    if (obj == null || obj == undefined || obj.length == "") {
        return true;
    }
    return false;
}

/**
 * 参数长度验证
 *
 * @param obj
 * @param length
 * @returns {boolean}
 */
function validLength(obj, length) {
    if (obj.trim().length < length) {
        return true;
    }
    return false;
}

/**
 * 用户名称验证 4到16位（字母，数字，下划线，减号）
 *
 * @param userName
 * @returns {boolean}
 */
function validUserName(userName) {
    var pattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if (pattern.test(userName.trim())) {
        return (true);
    } else {
        return (false);
    }
}

/**
 * 用户密码验证 最少6位，最多20位字母或数字的组合
 *
 * @param password
 * @returns {boolean}
 */
function validPassword(password) {
    var pattern = /^[a-zA-Z0-9]{6,20}$/;
    if (pattern.test(password.trim())) {
        return (true);
    } else {
        return (false);
    }
}



<!-- cookie操作 start-->

/**
 * 写入cookie
 *
 * @param name
 * @param value
 */
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
}

/**
 * 读取cookie
 * @param name
 * @returns {null}
 */
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

/**
 * 删除cookie
 * @param name
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

/**
 * 检查cookie
 */
function checkCookie() {
    if (getCookie("token") == null) {
        alert("未登录！");
        window.location.href = "login.html";
    }
}

/**
 * 检查cookie
 */
function checkResultCode(code) {
    if (code == 402) {
        window.location.href = "login.html";
    }
}
function logout() {
    delCookie("Bearer");
    window.location.href = "/";
}
<!-- cookie操作 end-->
// 添加到购物车
function addToCartSon(id,pic,lifuName,count,price,size,color) {
    let username = $('#username').val();

    let l = window.localStorage.getItem(username);
    let list = JSON.parse(l);
    if( isNull(list) )
        list = [];
    lifuName = lifuName.substr(0,min(5,lifuName.length))+"...";
    console.log(lifuName);
    let temp = {id,lifuName,pic,count,price,size,color};
    insertToList(temp,list);
    window.localStorage.setItem(username,JSON.stringify(list));
    alert("加入购物车成功！");

}
function min(var1,var2) {
    return var1 > var2 ? var2 : var1;
}
function addToCart(id,pic,lifuName,count,price) {
    $('#id').val(id);
    $('#pic').val(pic);
    $('#lifuName').val(lifuName);
    $('#count').val(count);
    $('#price').val(price);
    $("#size").empty();
    $("#color").empty();
    axios.get("/sku/list?id="+id).then(function (res) {
        let sizes = res.data.data.sizes;
        let colors = res.data.data.colors;
        for (var i = 0; i < sizes.length; i++) {
            $("#size").append("<option value=\"" + sizes[i] + "\">" + sizes[i] + "</option>");
        }
        for (var i = 0; i < colors.length; i++) {
            $("#color").append("<option value=\"" + colors[i] + "\">" + colors[i] + "</option>");
        }
    });
    $('#temp').modal('show');
}
function formAddToCart(){
    let id = $('#id').val();
    let pic = $('#pic').val();
    let lifuName = $('#lifuName').val();
    let count = $('#count').val();
    let price = $('#price').val();
    let size = $('#size').val();
    let color = $('#color').val();
    addToCartSon(id,pic,lifuName,count,price,size,color);
    loadCart();
    $('#temp').modal('hide');
    // console.log(pic);
    // addToCartSon(id,pic,lifuName,count,price);
    // loadCart();
}
function removeForCart(id) {
    let username = $('#username').val();
    let l = window.localStorage.getItem(username);
    let list = JSON.parse(l);
    if( isNull(list) )
        list = [];

    list.forEach((item,index) => {
        if( item.id == id){
            list.splice(index,1);
            return;
        }
    });
    // list = list.filter(function(val){
    //     return val;
    // });
    window.localStorage.setItem(username,JSON.stringify(list));
    loadCart();
}
//初始化 购物车 ， 用于 用户登录后
function initCart(username) {
    // let username = $('#username').val();


    let defaultName = 'default';
    //将未登录前的购物车 加入 到 服务器 并获取本身在服务器的购物车
    let l = window.localStorage.getItem(username);
    let list = JSON.parse(l);
    if( isNull(list) ){
        list = [];
    }
    // axios.post("putLocalCartAndGetRemoteCart",ids).then(function (res) {
    //     if(res.code == 200){
    //
    //         //将远程的 购物车 加入到本地
    //         res.data.data.forEach((item,index) => {
    //             addToCartSon(item.id,item.pic,item.name,item.count,item.price);
    //         });
    //     }
    // });
    //将其加入到 localStorage
    //先移除之前的 购物车历史
    // window.localStorage.removeItem(username);

    //复制 default的
    console.log("list = " + list);
    let dl = window.localStorage.getItem(defaultName);
    if(isNull(dl)){
        loadCart();
        return;
    }

    let dlist = JSON.parse(dl);
    console.log("dlist = " + dlist);

    for( let i = 0; i < dlist.length;i++){
        insertToList(dlist[i],list);
    }
    console.log("list = " + list);

    let s = JSON.stringify(list);
    console.log("s = " + s);
    window.localStorage.removeItem(username);
    window.localStorage.setItem(username,s);
    //移除未登录 购物车 的所有
    window.localStorage.removeItem(defaultName);
    loadCart();
}
function insertToList(item,list){
    for( let i = 0;i < list.length; ++i){
        if( list[i].id == item.id && list[i].size == item.size && list[i].color == item.color){
            list[i].count += item.count;
            return;
        }
    }
    list.push(item);
}
function loadCart() {
    console.log("loadCart");

    let username = $('#username').val();
    console.log(username);
    let items = window.localStorage.getItem(username);

    if( isNull(items) ){
        $("#count").html(0);
        return;
    }
    $("#list").empty();
    let item = JSON.parse(items);
    $("#count").html(item.length);
    for ( let c of item){
        $("#list").append("<div class=\"mc-sin-pro fix\">\n" +
            "                                                    <a href=\"/product-details?id="+c.id+"\" class=\"mc-pro-image float-left\"><img src=\""+c.pic+"\" style=\"width: 38px;height: 60px\" alt=\"\" /></a>\n" +
            "                                                    <div class=\"mc-pro-details fix\">\n" +
            "                                                        <a href=\"/product-details?id="+c.id+"\">"+c.lifuName+"</a>\n" +
            "                                                        <span>"+c.count+"x"+c.price+"</span>\n" +
            "                                                        <span>"+c.size+"</span>\n" +
            "                                                        <span>"+c.color+"</span>\n" +
            "                                                        <a class=\"pro-del\" onclick=\"removeForCart("+c.id+")\"><i class=\"fa fa-times-circle\"></i></a>\n" +
            "                                                    </div>\n" +
            "                                                </div>")
    }
}
function collect(id) {
    axios.post("/user/collect?id="+id).then(function (res) {
        if(res.data.code == 200){
            alert("收藏成功!");
        }else {
            alert(res.data.message);
        }
    })
}
function downloadword() {
    var papername = "个人简历";
    $("#resume").wordExport(papername);  //papername为导出的word文件的命名,paperque为要导出的html内容容器
    html2canvas(document.getElementById("paperque"), {
        onrendered: function (canvas) {
            //通过html2canvas将html渲染成canvas，然后获取图片数据
            var imgData = canvas.toDataURL('image/jpeg');
            //初始化pdf，设置相应格式
            var doc = new jsPDF("p", "mm", "a4");
            doc.setFillColor(0, 0, 0);
            //这里设置的是a4纸张尺寸
            doc.addImage(imgData, 'JPEG', 0, 0, 210, 297);
            //输出保存命名为content的pdf
            doc.save(papername + '.word');
        }
    });
}
