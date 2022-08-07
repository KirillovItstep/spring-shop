//Update
$(document).on("click", ".updateJewelry", function(){
    let id = $(this).attr("id");
    $("#modalUpdate").val(id);

    fetch(`http://localhost:8080/api/jewelries/${id}`, {
        method: 'GET',
        redirect: 'follow'
    })
        .then(response => response.json())
        .then(result => {
            $("#modalUpdate #name").val(result.name);
            let selectColor =  $("#modalUpdate #color");
            selectColor.val(result.color);
            for (let i=0; i<colors.length; i++){
                let option = $('<option>');
                option.html(colors[i]);
                selectColor.append(option);
            }
            $("#modalUpdate #price").val(result.price);
            $("#modalUpdate #priceNew").val(result.priceNew);
            //console.log(result)
        })
        .catch(error => console.log('error', error));
});

//При подтверждении изменений (нажатии на кнопку OK)
$(document).on("click", "#buttonUpdate", async function() {
    let id = $("#modalUpdate").val();
    let name = $("#modalUpdate #name").val();
    let color = $("#modalUpdate #color").val();
    let price = $("#modalUpdate #price").val();
    let priceNew = $("#modalUpdate #priceNew").val();
    let file = $('#file').prop('files')[0];
    const toBase64 = file => new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });
    var image = await toBase64(file);

    const res = await fetch(`http://localhost:8080/api/jewelries/${id}`,
        {
            method:"PUT",
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify({id, name, color, price, priceNew, image})
        });

    //console.log(image);
    $("#modalUpdate").modal().hide();
    location.reload();

});