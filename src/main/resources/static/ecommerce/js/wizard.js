$(document).ready(function () {

	$('#r11').on('click', function(){
		  $(this).parent().find('a').trigger('click')
		})

		$('#r12').on('click', function(){
		  $(this).parent().find('a').trigger('click')
		})
		
			$('#r13').on('click', function(){
		  $(this).parent().find('a').trigger('click')
		})
    var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
                $item = $(this);

        if (!$item.hasClass('disabled')) {
            navListItems.removeClass('btn-primary').addClass('btn-default');
            $item.addClass('btn-primary');
            allWells.hide();
            $target.show();
            $target.find('input:eq(0)').focus();
        }
    });

    allNextBtn.click(function(){
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
            curInputs = curStep.find("input[type='text'],input[type='url'],input[type='email'],input[type='number']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for(var i=0; i<curInputs.length; i++){
            if (!curInputs[i].validity.valid){
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid)
            nextStepWizard.removeAttr('disabled').trigger('click');
    });

    $('div.setup-panel div a.btn-primary').trigger('click');
    
    

        OpenPay.setId('mexcviwsqt2snzeylcy5');
        OpenPay.setApiKey('pk_41f1c1b5d9e3450a85f4e5e882c13ca7');
        OpenPay.setSandboxMode(true);
        //Se genera el id de dispositivo
        var deviceSessionId = OpenPay.deviceData.setup("payment-form", "deviceIdHiddenFieldName");
        
        $('#pay-button').on('click', function(event) {
         event.preventDefault();
            $("#pay-button").prop( "disabled", true);
            OpenPay.token.extractFormAndCreate('payment-form', sucess_callbak, error_callbak);                
        });
 
        var sucess_callbak = function(response) {
          var token_id = response.data.id;
        
          $('#token_id').val(token_id);
          $('#payment-form').submit();
        };

        var error_callbak = function(response) {
            var desc = response.data.description != undefined ? response.data.description : response.message;
            alert("FAVOR DE VERIFICAR SUS DATOS");
            $("#pay-button").prop("disabled", false);
        };
});