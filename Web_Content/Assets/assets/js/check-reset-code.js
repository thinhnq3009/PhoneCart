(function () {

    function disableSubmitButton() {
       if ($('.is-invalid').length) {
          $('#submit').attr('disabled', 'disabled');
       } else {
          $('#submit').removeAttr('disabled');
       }
    }

    //On blur event check reset code is valid or not
    $("#reset-code").blur(function () {
        var resetCode = $("#reset-code").val();
        
        if (!resetCode) { return; }
        $("#reset-code").addClass("loading");

        $.ajax({
            url: "/PhoneCartShop/check-reset-code",
            type: "GET",
            data: {
                resetCode: resetCode,
                username: $("#username").val()
            },
            success: function (data) {
                let datajs = JSON.parse(data);

        
                if (datajs.status_code == 200 && datajs.value == true) {
                    console.log(datajs);
                    $("#reset-code").removeClass("loading");
                    $("#reset-code").removeClass("is-invalid");
                    $("#reset-code").addClass("is-valid");
                    disableSubmitButton();
                } else if (datajs.status_code == 200 && datajs.value == false) {

                    $("#reset-code").removeClass("loading");
                    $("#reset-code").removeClass("is-valid");
                    $("#reset-code").addClass("is-invalid");
                    disableSubmitButton();
                }
            }
        });


    });


    $("#confirm-pass").keyup(function (e) { 
        if ($("#confirm-pass").val() != $("#password").val()) {
            $("#confirm-pass").removeClass("is-valid");
            $("#confirm-pass").addClass("is-invalid");
            disableSubmitButton();
        } else {
            $("#confirm-pass").removeClass("is-invalid");
            $("#confirm-pass").addClass("is-valid");
            disableSubmitButton();
        }
    });
})();

