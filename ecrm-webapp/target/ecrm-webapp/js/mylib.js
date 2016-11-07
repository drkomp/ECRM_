/**
 * Created by drkomp on 07.11.2016.
 */

var auth = {
    login: function () {
        var log = $("#user").val();
        var pass = $("#pass").val();
        var request = {};
        request.log = log;
        request.pass = pass;
        request.requestType = "login";

        $.ajax({
            type: "POST",
            url: "/api",
            dataType: "json",
            data: request,
            success: function (response) {
                console.log(response.key);
                console.log(response.result);
            }
        });
    }

};
