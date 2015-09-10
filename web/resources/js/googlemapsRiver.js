var map,markers,marker;
var gml,urlpath;
var arrMarkers = [];
window.onload = function () {
var layers = [
  new google.maps.Map(document.getElementById('map'), {
      disableDefaultUI: true,
      keyboardShortcuts: false,
      draggable: false,
      disableDoubleClickZoom: true,
      scrollwheel: false,
      streetViewControl: false
    }),
  new ol.layer.Image({
        source: new ol.source.ImageWMS({
          ratio: 1,
          url: 'http://geoalternar.udenar.edu.co:8080/geoserver/Hidraulica/wms',
          params: {'FORMAT': 'image/png',
                   'VERSION': '1.1.1',  
                STYLES: '',
                LAYERS: 'Hidraulica:Drenaje_Sencillo',
          }
        })
      })
];
var map = new ol.Map({
  layers: layers,
  target: 'map',
  view: new ol.View({
    center: [-78.028, 1.409],
    zoom: 4
  })
});

}