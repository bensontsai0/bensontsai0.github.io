var pathname = window.location.pathname; // Returns path only
var url      = window.location.href;     // Returns full URL
var $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');

$(function(){
  	$("#header").load("pageHeader.html");
  	$("#footer").load("pageFooter.html");
});

function clickMenu(obj){
	var url2 = $(obj).attr('href');
	if(pathname.indexOf('index.html') == -1){
		window.location = "index.html";
	} else {
		//控制nav點擊縮放
		$("ul.nav.navbar-nav li.dropdown ul.dropdown-menu li a").click(function(){
            var id = $(this).attr('id');
            $(".navbar-collapse.collapse").removeClass("in");
            //scroll
            $body.animate({
              scrollTop: $(id).offset().top
            }, 1500);
        });
	}
}

