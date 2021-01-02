cordova.define("com-badrit-base64.Base64", function(require, exports, module) {
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
		var xhr = new XMLHttpRequest();
		xhr.open("GET", filePath, true);
		xhr.responseType = "blob";
		xhr.onload = function (e) {
			var reader = new FileReader();
			reader.onload = () => sucess(reader.result);
			reader.onerror = error => failure(error);
			var file = this.response;
			reader.readAsDataURL(file);
		};
		xhr.send();
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
});