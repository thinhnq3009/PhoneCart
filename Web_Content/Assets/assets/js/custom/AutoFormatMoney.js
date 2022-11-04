function autoFormat() {
	
	let list = document.querySelectorAll('.string-money');
	
	list.forEach(function(item) {
		
		const formatter = new Intl.NumberFormat('vi-VI', {
			style: 'currency',
			currency: 'VND',
		
		});

		item.innerHTML = formatter.format(item.innerHTML);
		
		
	})
		
}

autoFormat();

