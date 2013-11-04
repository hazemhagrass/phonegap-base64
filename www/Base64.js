// window.plugins.Base64

function Base64() {
	this.resultCallback = null; // Function
}


EmailComposer.prototype.encodeFile = function(filePath) {
	var args = {};
	ags.filePath = filePath;
	
	cordova.exec(null, null, "Base64", "encodeFile", [args]);
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