var exec = require('cordova/exec');

var RecentsControl = {
	
	setColor: function(colorStr) {
		exec(null, null, 'RecentsControl', 'setColor', [colorStr]);
	},
	
	setDescription: function(desc) {
		exec(null, null, 'RecentsControl', 'setDescription', [desc]);
	},
	
	setOptions: function(colorStr, desc) {
		exec(null, null, 'RecentsControl', 'setOptions', [colorStr, desc]);
	},
	
};

module.exports = RecentsControl;