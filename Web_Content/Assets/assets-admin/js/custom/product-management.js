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

                    //Select form update
                    let displayUpdate = document.querySelector('#updatePro');

                    // Get data from server
                    let data = JSON.parse(this.responseText);

                    // Get all input elements
                    let inputText = displayUpdate.querySelectorAll('input[type="text"]');
                    let inputNumber = displayUpdate.querySelectorAll('input[type="number"]');
                    let textarea = displayUpdate.querySelectorAll('textarea');

                    let listInput = [...inputText, ...textarea, ...inputNumber];

                    // Fill input elements with data from server
                    for (let i = 0; i < listInput.length; i++) {
                        listInput[i].value = data[listInput[i].name];
                    }

                    // Auto fill data to update form (image)
                    let image = displayUpdate.querySelector('#image_selected');
                    image.src = "/PhoneCartShop" + data['proImage'];

                    // Auto fill data to update form (select)
                    let select = displayUpdate.querySelectorAll('select');

                    for (let i = 0; i < select.length; i++) {
                        let options = select[i].querySelectorAll('option');
                        let dataSelect = data[select[i].name];


                        for (var item in dataSelect) {
                            if (item.toLowerCase() == 'id' + select[i].name) {
                                for (let j = 0; j < options.length; j++) {
                                    if (options[j].value == dataSelect[item]) {
                                        options[j].selected = true;
                                    }
                                }
                            }
                        }
                    }

                    for (let j = 0; j < options.length; j++) {
                        if (options[j].value == dataSelect) {
                            options[j].selected = true;
                        }
                    }

                }


                xhr.send();

            });


        });
    }


    updateButton();

    changeColorProcess();
})();