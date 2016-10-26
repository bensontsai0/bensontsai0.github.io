var pathname = window.location.pathname; // Returns path only
var url      = window.location.href;     // Returns full URL

$(function(){
  	$("#header").load("pageHeader.html");
  	$("#footer").load("pageFooter.html");
});

function clickMenu(obj){
	var url2 = $(obj).attr('href');
	console.log(pathname);
	console.log(url);
	console.log(url2);
}
