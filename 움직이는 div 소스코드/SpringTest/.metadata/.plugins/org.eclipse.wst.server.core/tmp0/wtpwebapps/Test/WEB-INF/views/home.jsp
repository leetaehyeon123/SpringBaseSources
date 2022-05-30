<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html onmouseup='mydragg.stopMoving();'>
    <head >

        <script>
        var id;
            var mydragg = function(){
                return {
                    move : function(divid,xpos,ypos){
                        divid.style.left = xpos + 'px';
                        divid.style.top = ypos + 'px';
                    },
                    startMoving : function(divid,evt){
                        id=divid;
                        evt = evt || window.event;
                        var posX = evt.clientX,
                            posY = evt.clientY,
                        divTop = divid.style.top,
                        divLeft = divid.style.left,
                        eWi = parseInt(divid.style.width),
                        eHe = parseInt(divid.style.height);
                        
               
                        divid.style.cursor='move';
                        divTop = divTop.replace('px','');
                        divLeft = divLeft.replace('px','');
                        var diffX = posX - divLeft,
                            diffY = posY - divTop;
                        document.onmousemove = function(evt){
                            evt = evt || window.event;
                            var posX = evt.clientX,
                                posY = evt.clientY,
                                aX = posX - diffX,
                                aY = posY - diffY;
                            if (aX <= 0) aX = 0;
                            if (aY <= 0) aY = 0;
                            if (aX + eWi >= document.body.offsetWidth ) aX = document.body.offsetWidth  - eWi;
                            if (aY + eHe >= document.body.offsetHeight) aY = document.body.offsetHeight -eHe;
                            mydragg.move(divid,aX,aY);
                        }
                    },
                    stopMoving : function(){

                        id.style.cursor='default';
                        document.onmousemove = function(){}
                    },
                }
            }();

        </script>
    </head>
    <body>
    <div style="width: 100%; height: 100vh">
            <div class="elem" onmousedown='mydragg.startMoving(this,event);'  style="width: 200px;height: 500px;background-color: gray;position: absolute;">
                <div style='width:100%;height:100%;padding:10px'>
            		<p>hi</p>
            		<p>hi</p>
                </div>
            </div>
                    <div class="elem" onmousedown='mydragg.startMoving(this,event);'  style="width: 200px;height: 500px;background-color:blue;position: absolute;">
                <div style='width:100%;height:100%;padding:10px'>
            		<p>hi</p>
            		<p>hi</p>
                </div>
            </div>
                    <div class="elem" onmousedown='mydragg.startMoving(this,event);'  style="width: 200px;height: 500px;background-color: red;position: absolute;">
                <div style='width:100%;height:100%;padding:10px'>
            		<p>hi</p>
            		<p>hi</p>
                </div>
            </div>
           
	</div>
    </body>
</html>