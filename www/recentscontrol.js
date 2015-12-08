var exec = require('cordova/exec');

var RecentsControl = {
	
	setColor: function(colorStr) {
		exec(null, null, 'RecentsControl', [colorStr]);
	},
	
	setDescription: function(desc) {
		exec(null, null, 'RecentsControl', [desc]);
	},
	
	setOptions: function(colorStr, desc) {
		exec(null, null, 'RecentsControl', [colorStr, desc]);
	},
	
};

module.exports = RecentsControl;