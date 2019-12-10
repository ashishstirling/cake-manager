$(function() {
    populateCakeTable();
});

function populateCakeTable() {
    $('#cakeTable tbody > tr').remove();
    $.ajax({
        type: 'GET',
        url: '/cakes',
        data: { get_param: 'value' },
        dataType: 'json',
        success: function (data) {
            $.each(data, function(index, element) {
                $('#cakeTable > tbody:last-child').append(
                    '<tr><td>' + element.title + '</td><td>'
                               + element.desc + '</td><td>'
                               + '<img src="' + element.image + '" alt="' + element.title + '" class="img-thumbnail" width="200" height="200">' + '</td></tr>'
                );
            });
        }
    });
}