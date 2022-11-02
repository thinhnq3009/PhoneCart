(function() {

	/**
	Hiển thị ảnh khi người dùng chọn ở thẻ input lên thẻ chỉ định
	
	Useage: 
	+ Tạo một <div></div> làm thẻ hiển thị
	+ Thêm ID hoặc Class để select tới nó
	+ Thêm thuộc tính "divShow" vào thẻ input[type="file"] 
	+ Set value cho "divShow" là selector của div hiển thị
	*/
	function readFile(file, seletor) {

		console.log('read File')

		if (file.files && file.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$(seletor).attr('src', e.target.result);
			}
			reader.readAsDataURL(file.files[0]);
		}
	}

	let proImage = document.querySelectorAll('input[type="file"]')
	proImage.forEach(function(e) {
		e.addEventListener('change', function() {
			readFile(this, this.getAttribute('divShow'));
		});
	});


	/**
	Reset form 
	Input: {
			parentForm: selector,
			child: [selector1, selector2],
			button: selectorClearButton
			}
	*/
	function clearForm(data) {

		let parentForm = document.querySelector(data.parentForm);

		let clearButton = parentForm.querySelector(data.button);

		console.log(clearButton)

		clearButton.addEventListener('click', function() {
			for (let i = 0; i < data.child.length; i++) {
				let list = parentForm.querySelectorAll(data.child[i]);
				list.forEach(function(element) {
					if (element.tagName == 'INPUT') {
						if (element.type == 'text') {
							element.value = '';
						} else if (element.type == 'file') {
							element.value = '';
							let imageElement = parentForm.querySelector(element.getAttribute('divShow'));
							console.log(element.getAttribute('divShow'));
							imageElement.src = '';
						} else if (element.type == 'number') {
							element.value = 0;
						} else if (element.type == 'checkbox') {
							element.checked = true;
						}
					} else if (element.tagName == 'SELECT') {
						element.firstElementChild.selected = true;
					} else if (element.tagName == 'TEXTAREA') {
						element.value = '';
					}
				});
			}
		});
	}

	/**
	Set color cho ProcessBar trên bảng product
	 */
	function changeColorProcess() {
		let progress = document.querySelectorAll('.progress .progress-bar');
		progress.forEach(function(element) {
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


	/**
		Tạo sự kiện cho các nút update. 
		+ Gửi request lên server để lấy dữ liệu về product tưng ứng thông qua id
		+ Dựa trên thông tin từ sever tự động điền và form Update
	 */
	function updateButton() {
		let listButton = document.querySelectorAll('button.updateProduct');


		listButton.forEach(function(button) {

			button.addEventListener('click', function() {


				// AJAX request javascript
				let xhr = new XMLHttpRequest();
				xhr.open('GET', '/PhoneCartShop/data/product?id=' + button.getAttribute('idpro'), true);
				xhr.onload = function() {

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

					// Show image from server
					let image = displayUpdate.querySelector('#image_update');
					image.src = "/PhoneCartShop" + data['proImage'];

					// Set option 
					let select = displayUpdate.querySelectorAll('select');

					for (let i = 0; i < select.length; i++) {
						let options = select[i].querySelectorAll('option'); // Danh sách các option trong 1 select
						let dataSelect = data[select[i].name];	// Data được lưu trên server (id, name, image) ở dạng Object

						for (var item in dataSelect) {
							if (item.toLowerCase() == 'id' + select[i].name) { 
								for (let j = 0; j < options.length; j++) {
									if (options[j].value == dataSelect[item]) {
										options[j].selected = true;
										break;
									}
								}
								// Dừng khi kiếm đúng data và set option xong
								break;
							}
						}
					}

					// for (let j = 0; j < options.length; j++) {
					// 	if (options[j].value == dataSelect) {
					// 		options[j].selected = true;
					// 	}
					// }

				}

				// Gửi request lên server
				xhr.send();

			});


		});
	}


	updateButton();
	changeColorProcess();

	// Clear form new product
	clearForm({
		parentForm: '#create-product',
		child: ['input', 'select', 'textarea'],
		button: '#clear-form'
	});

	// Clear form update product
	clearForm({
		parentForm: '#update-product',
		child: ['input', 'select', 'textarea'],
		button: '#clear-form'
	});


})();