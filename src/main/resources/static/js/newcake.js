$(function() {
    $("#saveCake").click(function() {
        saveCake();
    });
});

function saveCake() {
    var title = $("#title").val();
    var desc = $("#desc").val();
    var image = $("#image").val();

    if (title === "" || desc === "" || image === "") {
        alert("All fields are required!");
    } else {
        var cake = {
            title: title,
            desc: desc,
            image: image
        };
        $.ajax({
            type: 'POST',
            url: '/cakes',
            data: cake,
            dataType: 'json',
            success: function (result) {
                if (result) {
                    window.location.href = "/";
                } else {
                    alert("Cannot add cake!");
                }
            }
        });
    }
}