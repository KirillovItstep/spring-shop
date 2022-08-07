

var colors = ['Platinum','White','Yellow','Rose'];

var requestOptions={
    method: 'GET',
    redirect: 'follow'
};

fetch('http://localhost:8080/api/jewelries', requestOptions)
    .then(response=>response.json())
    .then(result=>addRows(result))
    .catch(error=>console.log('Get jewelries is wrong'));

function addRows(response){
    for (let i=0; i<response.length; i++){

        let tr = $('<tr>');

        let tdId = $('<td>');
        let id = response[i].id;
        tdId.html(id);
        tr.append(tdId);

        let tdImage = $('<td>');
        let src = 'data:image/png;base64,'+response[i].image;
        tdImage.html(`<img src="${src}" style="width:50px; height:50px">`);
        tr.append(tdImage);

        let tdName = $('<td>');
        tdName.html(response[i].name);
        tr.append(tdName);

        let tdPrice = $('<td>');
        let price = response[i].price / 100;
        tdPrice.html('$' + price.toFixed(2).toLocaleString('en-US'));
        tr.append(tdPrice);

        let tdPriceNew = $('<td>');
        let priceNew = response[i].priceNew / 100;
        tdPriceNew.html('$' + priceNew.toFixed(2).toLocaleString('en-US'));
        tr.append(tdPriceNew);

        let tdColor = $('<td>');
        let color = response[i].color;
        tdColor.html(color);
        tr.append(tdColor);

        let tdActions = $('<td>');
        tdActions.html(`<div class="container">
                <button type="button" class="btn btn-outline-primary btn-sm updateJewelry" data-bs-toggle="modal"
            data-bs-target="#modalUpdate" id="${id}">Change</button>
                <button type="button" class="btn btn-outline-danger btn-sm deleteJewelry" data-bs-toggle="modal"
            data-bs-target="#modalDelete" id="${id}">Delete</button>
                </div>
`);
        tr.append(tdActions);

        $('#data').append(tr);
    }
}