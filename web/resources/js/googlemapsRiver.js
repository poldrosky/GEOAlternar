window.onload = function () {
///////////
    
    var loc = window.location.href;
    var fileNamePart = loc.split('/');
    urldrenajeSencillo=fileNamePart[0]+'/'+fileNamePart[1]+'/'+fileNamePart[2]+'/'+fileNamePart[3]+'/'+'resources/js/json/drenajeSencillo.json';
    urldrenajeDoble=fileNamePart[0]+'/'+fileNamePart[1]+'/'+fileNamePart[2]+'/'+fileNamePart[3]+'/'+'resources/js/json/drenajeDoble.json';
    urlEstaciones=fileNamePart[0]+'/'+fileNamePart[1]+'/'+fileNamePart[2]+'/'+fileNamePart[3]+'/'+'resources/js/json/estaciones.json';
    urlLimites=fileNamePart[0]+'/'+fileNamePart[1]+'/'+fileNamePart[2]+'/'+fileNamePart[3]+'/'+'resources/js/json/narinoAdmin.json';
    // tiles for background
var raster = new ol.layer.Tile({
    source: new ol.source.MapQuest({
        layer: 'sat'
    })
});
//Admin Nariño
var limites = new ol.layer.Vector({
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: urlLimites
    }),
    style: new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: '#000000',
            width: 1
        })
    })
});
// drenaje Sencillo
var drenajeSencillo = new ol.layer.Vector({
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: urldrenajeSencillo
    }),
    style: new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: '#0080FF',
            width: 1.2
        })
    })
});
// drenaje doble
var drenajeDoble = new ol.layer.Vector({
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: urldrenajeDoble
    }),
    style: new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: '#0080FF',
            width: 1.2
        })
    })
});
//estaciones
var estaciones = new ol.layer.Vector({
    source: new ol.source.Vector({
        format: new ol.format.GeoJSON(),
        url: urlEstaciones
    }),
    style: new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: '#0080FF',
            width: 0.5
        })
    })
});

// render the map    
var map = new ol.Map({
    target: 'map',
    renderer: 'canvas',
    layers: [raster,limites, drenajeSencillo,drenajeDoble,estaciones],
    view: new ol.View({
    center: ol.proj.transform([-78.028, 1.409], 'EPSG:4326', 'EPSG:3857'),//[-8644780, 200452],
    zoom: 8
  })
});

    
}

//FUNCION PARA CARGAR LAS CAPAS SELECCIONADAS EN LA APLICACION