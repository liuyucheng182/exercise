 alert("hello world");
 document.write("<h1>Hello world<h1>");
console.log("你好");
var data =new Array(3);
for(var x=0;x<data.length;x++){
	document.write(data[x]+"</BR>");
}

function fun(){
	alert("被点击了");
}
function button(){
	alert("被点击了");
}
window.onload=function(){
	var obj=document.getElementById("mybutton");
	if(obj!=null){
		obj.addEventListener("click",function(){
			button();
			},false);
	}
}