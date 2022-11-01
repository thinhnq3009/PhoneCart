(function () {

    function checkValue(value, data) {

        function disEnableButton() {
            if ($(".already-exist").length > 0) {
                $("#btn-submit").attr("disabled", true);
            } else {
                $("#btn-submit").attr("disabled", false);
            }
        }
        // Call ussing Ajax
        $.ajax({
            url: "/PhoneCartShop/helper/checker",
            type: "GET",
            data: { tab : data.tab, col : data.col, data : value },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                if (response.status_code == 200 && response.value == true) {
                    $(data.seletor).removeClass("loading");
                    $(data.seletor).removeClass("is-valid");
                    $(data.seletor).addClass("already-exist");
                    disEnableButton();
                    
                } else if (response.status_code == 200 && response.value == false){
                    $(data.seletor).removeClass("loading");
                    $(data.seletor).removeClass("already-exist");
                    $(data.seletor).addClass("is-valid");
                    disEnableButton();
                }
            },
          
        });
        


    }

    

    let validateData = function (data) {
        $(data.seletor).blur(function () {
            
            if (!$(data.seletor).val()) return;
            
            $(data.seletor).addClass("loading");
            if (data.tab && data.col) {
                checkValue($(data.seletor).val(), data);
            }


        });

        $(data.seletor).click(function () {
			
			if (!$(data.seletor).val()) return;
			
            $(data.seletor).removeClass("already-exist");
        });


    };

    let validateDatas = function (datas) {
        datas.forEach(function (data) {
            validateData(data);
        });
    };

    validateDatas([
        {
            seletor: "#email",
            tab: "Users",
            col: "email"
        },
        {
            seletor: "#username",
            tab: "Users",
            col: "username"
        },
        {
            seletor: "#phone-number",
            tab: "Users",
            col: "phone_number"
        }
        
    ]);


})();