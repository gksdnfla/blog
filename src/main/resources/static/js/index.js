(function() {
    $(document).on('mousemove', function(ev) {
        var screenWidth = $(document).width();
        var screenHeight = $(document).height();
        var startPointX = screenWidth / 2;
        var startPointY = screenHeight / 2;
        var movePointX = ev.pageX - startPointX;
        var movePointY = ev.pageY - startPointY;
        var maxX = screenWidth - startPointX;
        var maxY = screenHeight - startPointY;
        var curX = movePointX / maxX;
        var curY = movePointY / maxY;
        var absCurX = Math.abs(curX);
        var absCurY = Math.abs(curY);

        $("#front-end-text").css('text-shadow', -Math.ceil(30 * curX) + 'px ' + -Math.ceil(30 * curY) + 'px ' + Math.ceil(7 * (absCurX > absCurY ? absCurX : absCurY) + 3)  + 'px #000000');
    });
})();