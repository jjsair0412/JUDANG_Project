window.onload = function BuyerMap(){
    let sch = location.search
    const params = new URLSearchParams(sch);

    data.latitude = params.get('lat');
    data.longitude = params.get('lon');

    showMap(data);
}