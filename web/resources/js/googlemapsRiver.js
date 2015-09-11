var wmsparams = [
"REQUEST=GetMap",
"SERVICE=WMS",
"VERSION=1.1.1",
"BGCOLOR=0xFFFFFF",
"TRANSPARENT=TRUE",
"SRS=EPSG:3857",
"WIDTH=255",
"HEIGHT=255",
"format=image/png"
];

var mapOptions = {
    zoom: 4,
    center: new google.maps.LatLng(37.609066626725,-97.423977848479),
    mapTypeControl:false,
    draggableCursor: 'crosshair',
    mapTypeId:'roadmap',
    backgroundColor: "#badbff"
}

map = new google.maps.Map(document.getElementById("map"),mapOptions);