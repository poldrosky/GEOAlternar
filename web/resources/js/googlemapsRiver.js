var map;
var gml;
window.onload = function () {
///////////
    OpenLayers.Control.Click = OpenLayers.Class(OpenLayers.Control, {
        defaultHandlerOptions: {
            'single': true,
            'double': false,
            'pixelTolerance': 0,
            'stopSingle': false,
            'stopDouble': false
        },
        initialize: function (options) {
            //this.handlerOptions = OpenLayers.Util.extend({}, this.defaultHandlerOptions);
            //OpenLayers.Control.prototype.initialize.apply(this, arguments);
            this.handler = new OpenLayers.Handler.Click(
                    this, {
                        'click': this.trigger
                    }, this.handlerOptions
                    );
        },
        trigger: function (e) {
            var lonlat = map.getLonLatFromPixel(e.xy);

            document.getElementById('frmlatlon:latitudeCap').value = lonlat.lat;
            document.getElementById('frmlatlon:longitudeCap').value = lonlat.lon;

            //////////Evento disparado al simular click sobre el el mapa
            var fireOnThis = document.getElementById("frmlatlon:btAjax");
            var evObj = document.createEvent('Event');
            evObj.initEvent('click', true, true);
            fireOnThis.dispatchEvent(evObj);

        }

    });
////////////    
    var bounds = new OpenLayers.Bounds(
            -80.80241888771431, 0.5124091384021122,
            -78.63857187459485, 2.3940265905821643
            );
    var options = {
        maxExtent: bounds,
        maxResolution: 0.0084525273949979,
        projection: "EPSG:4326",
        units: 'degrees'
    };
    map = new OpenLayers.Map('map', options);
    map.addControl(new OpenLayers.Control.LayerSwitcher());

    var ghyb = new OpenLayers.Layer.Google(
            "Google Hybrid",
            {type: google.maps.MapTypeId.HYBRID, numZoomLevels: 20}
    );
    var general = new OpenLayers.Layer.WMS(
            "Viento", "http://190.254.4.128:8080/geoserver/MapGeneral/wms",
            {
                "LAYERS": "MapGeneral:Sun",
                "STYLES": '',
                format: 'image/png',
                transparent: true,
            },
            {
                buffer: 0,
                displayOutsideMaxExtent: true,
                visibility: true,
                isBaseLayer: false,
                yx: {'EPSG:4326': false}
            }
    );
   gml = new OpenLayers.Layer.Vector("narinoAdmin", {
        projection: new OpenLayers.Projection("EPSG:3857"),
        strategies: [new OpenLayers.Strategy.Fixed()],
        protocol: new OpenLayers.Protocol.HTTP({
            url: "http://localhost:8080/GEOAlternar/faces/resources/json/p.json",
            format: new OpenLayers.Format.GeoJSON()
        }),
        styleMap: new OpenLayers.StyleMap({
            "default": new OpenLayers.Style({
                pointRadius: 5,
                fillOpacity: 0,
                strokeColor: "#000000",
                strokeWidth: 1,
                strokeOpacity: 1}) //Text entspricht feature.attributes.name
        })

    });
    // Google.v3 uses EPSG:900913 as projection, so we have to // transform our coordinates
    map.addLayers([ghyb,general,gml]);// 
    map.setCenter(new OpenLayers.LonLat(-78.028, 1.409).transform(
            new OpenLayers.Projection("EPSG:4326"),
            map.getProjectionObject()
            ), 8);

    var click = new OpenLayers.Control.Click();
    map.addControl(click);
    click.activate();

    
}

//FUNCION PARA CARGAR LAS CAPAS SELECCIONADAS EN LA APLICACION