<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>AJAX跨域请求测试</title>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.js">
</script>

</head>
<body>
  <input type='button' value='开始测试' onclick='getAjax()' />
  <div id="content"></div>

  <script type="text/javascript">
    function getAjax(){
$.ajax({
type : "post",
dataType : "json",
url : "http://192.168.35.30:8080/jk-hospital-api/api/user/regist",
data : {
id : 1
},
complete : function() {
},
success : function(result) {
var data = result['success'];
alert(result['msg']);
},
});
}
  </script>
  
  
     
  

</body>
</html>
