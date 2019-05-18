
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
        #allmap {width: 100%; height:80%; overflow: hidden;}
        #result {width:100%;font-size:12px;}
        dl,dt,dd,ul,li{
            margin:0;
            padding:0;
            list-style:none;
        }
        p{font-size:12px;}
        dt{
            font-size:14px;
            font-family:"微软雅黑";
            font-weight:bold;
            border-bottom:1px dotted #000;
            padding:5px 0 5px 5px;
            margin:5px 0;
        }
        dd{
            padding:5px 0 0 5px;
        }
        li{
            line-height:28px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=x0baOoLE2m6N9QKwHcZv8e53"></script>
    <!--加载鼠标绘制工具-->
    <script type="text/javascript" src="https://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="https://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
    <!--加载检索信息窗口-->
    <script type="text/javascript" src="https://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.js"></script>
    <!--bootstrap-->
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!--颜色选择器-->
    <script src="../js/colpick.js"></script>
    <link  rel="stylesheet" href="../css/colpick.css">
    <link rel="stylesheet" href="https://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.css" />
    <title>共和县营销及维护</title>
</head>
<body>
<div id="allmap" style="overflow:hidden;zoom:1;position:relative;">
    <div id="map" style="height:100%;-webkit-transition: all 0.5s ease-in-out;transition: all 0.5s ease-in-out;"></div>
</div>
<div id="result">
    <div class="form-group">
        <div class="col-md-6">
        <label for="department" class="col-sm-2 control-label" style="font-size: 24px">管理部门：</label>
        <div class="col-sm-10">
            <input type="text" class="form-control"  id="department" placeholder="请输入管理部门名字">
        </div>

        </div>
        <div class="col-md-6">
            <label for="color" class="col-sm-2 control-label " style="font-size: 24px">显示颜色：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  id='color' value="#FF0000">
            </div>

        </div>
    </div>
    <div class="center-block">

    <button  type="button" class="btn btn-danger center-block"  onclick="clearAll()">清除线路</button>
    <button type="button" class="btn btn-primary center-block">保存线路</button>

        </div>
</div>
</body>
</html>
<script type="text/javascript">
    $('#color').colpick({
        layout:'hex',
        submit:0,
        colorScheme:'light',
        onChange:function(hsb,hex,rgb,el,bySetColor) {
            $(el).css('border-color','#'+hex);
            if(!bySetColor) $(el).val('#'+hex);
        }
    }).keyup(function(){
        $(this).colpickSetColor(this.value);

    });
    // 百度地图API功能

    var map = new BMap.Map('map');
    var poi = new BMap.Point(100.627015,36.281313);
    map.centerAndZoom(poi, 16);//设置中心点坐标和地图级别
    map.enableScrollWheelZoom(); //启用鼠标滚动对地图放大缩小
    //产生随机数函数
    function RndNum(n){
        var rnd="";
        for(var i=0;i<n;i++)
            rnd+=Math.floor(Math.random()*10);
        return rnd;
    }

    //鼠标绘制完成回调方法   获取各个点的经纬度
    var overlays = [];
    var overlaycomplete = function(e){
       var group=RndNum(5);
        overlays.push(e.overlay);
        var path = e.overlay.getPath();//Array<Point> 返回多边型的点数组
        for(var i=0;i<path.length;i++){
            console.log("lng:"+path[i].lng+"\n lat:"+path[i].lat);
            var lng=path[i].lng
            var lat=path[i].lat
            addMap(lng,lat,i,group);
        }
        alert("添加成功！")
    }
    function addMap(lng,lat,i,group){
        /*var color=$('#color option:selected') .val(); */
        var color=$("#color") .val();
        var department=$("#department").val();
        $.ajax({
            url:"../map/addMap",
            data:{"num":i,"lng":lng, "lat":lat,"color":color, "department":department,"group":group},
            type:"POST",
            dataType:"text",
            success:function(obj){
            },
            error : function() {
                alert("请与管理员联系");
            }
        });
    }



    var styleOptions = {
        strokeColor:"red",    //边线颜色。
        fillColor:"",      //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight: 5,       //边线的宽度，以像素为单位。
        strokeOpacity: 0.5,       //边线透明度，取值范围0 - 1。
        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
        strokeStyle: 'solid' //边线的样式，solid或dashed。
    }
    //实例化鼠标绘制工具
    var drawingManager = new BMapLib.DrawingManager(map, {
        isOpen: false, //是否开启绘制模式
        enableDrawingTool: true, //是否显示工具栏
        drawingMode:BMAP_DRAWING_POLYLINE,//绘制模式  多边形
        drawingToolOptions: {
            anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
            offset: new BMap.Size(5, 5), //偏离值
            drawingModes:[
                BMAP_DRAWING_POLYLINE
            ]
        },
        polylineOptions: styleOptions, //多边形的样式
    });

    //添加鼠标绘制工具监听事件，用于获取绘制结果
    drawingManager.addEventListener('overlaycomplete', overlaycomplete);
    function clearAll() {
        for(var i = 0; i < overlays.length; i++){
            map.removeOverlay(overlays[i]);
        }
        overlays.length = 0
    }


</script>
