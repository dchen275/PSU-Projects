$(document).ready(function () {

    function Register() {
        var username = $("#Username").val();
        var password = $("#Password").val();
        $.ajax({
            type: "POST",
            url: "/home/CreateUser_Click",
            data: { username: username, password: password },
            success: function (data) {
                //call view to index
                alert('it somewhat works');
            },
            error: function () {
                alert('broken');
            }
        })
    }


    $("#btnRegister").click(function () {
        Register();
    })
})