<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>支付页面</title>
</head>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.5.1/jquery.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
    window.onload=function () {
        jQuery("#myqrcode").qrcode({
            text: "${qrcode}"
        });
    }
</script>
<body>
<h1>请给可怜的孩子一点钱吧！</h1>

<div id="myqrcode"></div>
<img src="jun.jpg" alt="俊">
</body>
</html>

