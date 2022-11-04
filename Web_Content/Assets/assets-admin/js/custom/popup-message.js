(function () {

    let context = document.querySelector('#popup-message');
    let listItem = context.querySelectorAll('.item');
    
    listItem.forEach(function (item) {

        let close = item.querySelector('.close');
        close.addEventListener('click', function () {
            //remove bounceInRight delay-1
            item.classList.remove('bounceInRight');
            // item.classList.remove('delay-1');
            item.classList.add('bounceOutRight');
        });

    });

    

})();