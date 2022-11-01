(function () {

    function readFile(file) {

        console.log('read File')

        if (file.files && file.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#image_selected').attr('src', e.target.result);
            }
            reader.readAsDataURL(file.files[0]);
        }
    }

    let proImage = document.getElementById('proImage');
    proImage.addEventListener('change', function () {
        readFile(this);
    });


    //Clear Image and all input elements and select first elements 
    let clearButton = document.getElementById('clear-form');
    clearButton.addEventListener('click', function () {
        let inputElements = document.querySelectorAll('#create-product input');
        let selectElements = document.querySelectorAll('#create-product select');
        let imageElement = document.querySelector('#create-product #image_selected');
        let textAreaElement = document.querySelector('#create-product textArea');

        imageElement.src = '';
        inputElements.forEach(function (element) {
            element.value = '';
        });
        selectElements.forEach(function (element) {
            element.selectedIndex = 0;
        });
        textAreaElement.value = '';
    });

    function changeColorProcess() {
        let progress = document.querySelectorAll('.progress .progress-bar');
        progress.forEach(function (element) {
            let value = element.style.width;

            element.classList.remove('bg-success');

            if (value > '70%' || value == '100%') {
                element.classList.add('bg-success');
            } else if (value > '25%') {
                element.classList.add('bg-warning');
            } else {
                element.classList.add('bg-danger');
            }
        });

    }


    function updateButton() {
        let listButton = document.querySelectorAll('button.updateProduct');


        listButton.forEach(function (button) {

            button.addEventListener('click', function () {


                // AJAX request javascript
                let xhr = new XMLHttpRequest();
                xhr.open('GET', '/PhoneCartShop/data/product?id=' + button.getAttribute('idpro'), true);
                xhr.onload = function () {
                    let displayUpdate = document.querySelector('"#updatePro"');

                    let input = displayUpdate.querySelectorAll('input');
                    let select = displayUpdate.querySelectorAll('select');
                    let textarea = displayUpdate.querySelectorAll('textarea');

                    let listInput = [];
                    listInput.push(input).push(select).push(textarea);

                    console.log(listInput);

                    let data = JSON.parse(this.responseText);

                    listInput.forEach(function (element) {
                        element.forEach(function (input) {
                            input.value = data[input.name];
                        });
                    }

                });



            });


        });
    }



    changeColorProcess();
})();