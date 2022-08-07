//При нажатии на ссылку "delete" вызвать диалоговое окно и передать ему id
$(document).on("click", ".deleteJewelry", function(){
    let id = $(this).attr("id");
    console.log(id);
    //console.log($("#modalDelete"));
    $("#modalDelete").val(id);
    //console.log($("#modalDelete"));
})

//При подтверждении удаления (нажатии на кнопку OK)
$(document).on("click", "#buttonDelete", function(){
    let id = $("#modalDelete").val();
    fetch(`http://localhost:8080/api/jewelries/${id}`, {
        method: 'DELETE'
    });

    $("#modalDelete").hide();
    location.reload();
});