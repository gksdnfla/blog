(function() {
    $('#login-btn').on('click', function() {
        var data = {
            username: $("#username").val(),
            password: $("#password").val()
        };

        $.ajax({
            url: '/api/login',
            method: 'POST',
            data: data,
            success: function() {
                // window.location.replace("/admin");
            },
            error: function(err) {
                console.error(err);
            }
        });
    });
})();