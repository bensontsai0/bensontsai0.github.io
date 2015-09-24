var business = ["越南",
			    "廣東粥", 
			    "超大碗麵", 
			    "湖北熱麵", 
			    "鍋貼", 
			    "一品滷肉",
			    "豬腳飯",
			    "素食",
			    "對面" 
			    ];

function changeChoice(obj){

}

function start(){
	var index = Math.floor(Math.random() * business.length);
	document.getElementById('eat').innerHTML = business[index];
}


if(window.DeviceOrientationEvent) {
    window.addEventListener('deviceorientation', function(event) {
  		var a = document.getElementById('alpha');
        var b = document.getElementById('beta');
        var g = document.getElementById('gamma');
        var alpha = event.alpha;
        var beta = event.beta;
        var gamma = event.gamma;

		a.innerHTML = Math.round(alpha);
		b.innerHTML = Math.round(beta);
		g.innerHTML = Math.round(gamma);

    }, false);
}else{
    document.querySelector('body').innerHTML = '你的瀏覽器不支援喔';
}