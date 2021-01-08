var Login = Login || {};

Login.MaskDate = (function() {
	
	function MaskDate() {
		this.inputDate = $('.js-date');
	}
	
	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00.00.0000');
		this.inputDate.datepicker({
			orientation: 'top',
			language: 'bg-BG',
			autoclose: true
		});
	}
	return MaskDate;
}());
	
$(function() {
	var maskDate = new Login.MaskDate();
	maskDate.enable();
});