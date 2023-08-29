var pathname = window.location.pathname; // Returns path only
var url      = window.location.href;     // Returns full URL
var count = 0;
var $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');

$(function(){
  	$("#header").load("pageHeader.html");
  	$("#footer").load("pageFooter.html");
});

function clickMenu(obj){
	//控制nav點擊縮放
	$("div.navbar-collapse.collapse ul.nav.navbar-nav li.nav-item a").click(function(){
        var id = $(this).attr('id');
        //scroll
        $body.animate({
          scrollTop: $(id).offset().top-65
        }, 1500);
    });
     $("div.navbar-collapse.collapse").removeClass('show');
}