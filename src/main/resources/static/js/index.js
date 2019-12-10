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
                               + '<img src="' + element.image + '" class="img-thumbnail" onerror="this.onerror=null; this.src=\'image-not-found.jpg\'" width="100" height="100">'
                    + '</td></tr>'
                );
            });
        }
    });
}