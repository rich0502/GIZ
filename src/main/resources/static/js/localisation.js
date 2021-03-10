	var map = new OpenLayers.Map("mapdiv");
    map.addLayer(new OpenLayers.Layer.OSM());
    
    var epsg4326 =  new OpenLayers.Projection("EPSG:4326"); //WGS 1984 projection
    var projectTo = map.getProjectionObject(); //The map projection (Spherical Mercator)
    var lat = document.getElementById("lat").value;
    var lon = document.getElementById("lon").value;
    var nom_bat = document.getElementById("nom_bat").value;
    var adresse = document.getElementById("adresse").value;
    var lonLat = new OpenLayers.LonLat(lon,lat).transform(epsg4326, projectTo);
          
    
    var zoom=16;
    map.setCenter (lonLat, zoom);

    var vectorLayer = new OpenLayers.Layer.Vector("Overlay");
    
    // Define markers as "features" of the vector layer:
    var feature = new OpenLayers.Feature.Vector(
            new OpenLayers.Geometry.Point( lon,lat ).transform(epsg4326, projectTo),
            {description:'<div class="marker-item"><div class="libelle-pops"><img class="icon-popup" src="./img/pds_marker_build.svg"><span class="libelle-popup">Immeuble :</span></div><span class="popup-value-label">'+ nom_bat + '</span></div><div class="marker-item"><div class="libelle-pops"><img class="icon-popup" src="./img/pds_marker_pin.svg"> <span class="libelle-popup">Adresse:</div></span><span class="popup-value-label"> ' + adresse + '</span></div>' } ,
            {externalGraphic: 'img/marker.png', graphicHeight: 65, graphicWidth: 51, graphicXOffset:-12, graphicYOffset:-25  }
        );    
    vectorLayer.addFeatures(feature);   
   
    map.addLayer(vectorLayer);
 
    
    //Add a selector control to the vectorLayer with popup functions
    var controls = {
      selector: new OpenLayers.Control.SelectFeature(vectorLayer, { onSelect: createPopup, onUnselect: destroyPopup })
    };

    function createPopup(feature) {
      feature.popup = new OpenLayers.Popup.FramedCloud("pop",
          feature.geometry.getBounds().getCenterLonLat(),
          null,
          '<div class="markerContent">'+feature.attributes.description+'</div>',
          null,
          true,
          function() { controls['selector'].unselectAll(); }
      );
      //feature.popup.closeOnMove = true;
      map.addPopup(feature.popup);
    }

    function destroyPopup(feature) {
      feature.popup.destroy();
      feature.popup = null;
    }
    
    map.addControl(controls['selector']);
    controls['selector'].activate();
    