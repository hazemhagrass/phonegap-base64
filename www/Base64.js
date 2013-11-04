// window.plugins.Base64

function Base64() {
}


Base64.prototype.encodeFile = function(filePath, sucess, failure) {
	var args = {};
	args.filePath = filePath;
	//handle android using native code because toDataURL is not supported on android version < 3
	if (device.platform == "Android")
		cordova.exec(sucess, failure, "Base64", "encodeFile", [args]);
	else{
		var c = document.createElement('canvas');
		var ctx = c.getContext("2d");
		var img = new Image();
		
		img.onload = function() {
			c.width = this.width;
			c.height = this.height;

			ctx.drawImage(img, 0, 0);

			var dataUri = c.toDataURL("image/png");
			
			sucess(dataUri);
		};
		img.src = filePath;
	}
}

cordova.addConstructor(function()  {
	if(!window.plugins)
	{
		window.plugins = {};
	}
	
   // shim to work in 1.5 and 1.6
   if (!window.Cordova) {
   	window.Cordova = cordova;
   };
   
   window.plugins.Base64 = new Base64();
});