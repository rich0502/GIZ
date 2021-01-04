import constants from './commun/constants.js';

var drawControl, app, vectorLayer, tab, mapUI, layer_bat,layerArea, lastName, modifyControl, rect, vector, vectorPoint, activPts, sub;

	Ext.onReady(function () {
		var start_year = date_debut.substring(0,4);
		var start_month = date_debut.substring(5,7);
		var finish_year = date_fin.substring(0,4);
		var finish_month = date_fin.substring(5,7);
		var sub = subdivision + theme;
		var limit = new OpenLayers.Layer.WMS("limite",
				    constants.adresseIP + "/geoserver/mada/wms/", {
				        layers: "mada:" + subdivision + theme,
				        viewparams: "MIN_OBS_YEAR:"+start_year+";MAX_OBS_YEAR:"+finish_year+";MIN_OBS_MONTH:"+start_month+";MAX_OBS_MONTH:"+finish_month,
				        transparent: true,
				        format: "image/gif"
				    },
				    {
				        buffer: 0,
				        displayInLayerSwitcher: true,
				        visibility: true
				    });
	/*	var district = new OpenLayers.Layer.WMS("district",
			    constants.adresseIP + "/geoserver/mada/wms/", {
			        layers: "mada:" + subdivision,
			        transparent: true,
			        format: "image/gif"
			    },
			    {
			        buffer: 0,
			        displayInLayerSwitcher: true,
			        visibility: true
			    });
		*/
		console.log(limit);
		var osm_layer = new OpenLayers.Layer.OSM('osm');
	    // [1] - layer
	    layer_bat = [limit];
	    var mercator = constants.mercator;
	    //declarer le proxy cgi  a utiliser
	   // OpenLayers.ProxyHost = "/cgi-bin/proxy.cgi?url=";
	    layer_bat[0].setVisibility(true);
	    vectorLayer = new OpenLayers.Layer.Vector("Editable features");
	    vector = new OpenLayers.Layer.Vector();
	    vectorPoint = new OpenLayers.Layer.Vector();
		 rect = new OpenLayers.Control.DrawFeature(vector,
                OpenLayers.Handler.RegularPolygon,
                {handlerOptions: {sides: 4,irregular:true}});
		activPts = new OpenLayers.Control.DrawFeature(vectorPoint,
                OpenLayers.Handler.Point);
		
	    mapUI = new GeoExt.MapPanel({
	        ref: "mapPanel",
	        zoom: 23,
	        map: {
	            numZoomLevels: 10,
	            projection: mercator,
	            units: 'm',
	           // maxExtent: new OpenLayers.Bounds(49.1044387817383,-15.9973220825195,50.4848518371582,-12.7382574081421),
	            controls: [
	                new OpenLayers.Control.Navigation(),
	                new OpenLayers.Control.PanPanel(),
	                new OpenLayers.Control.ZoomPanel()
	
	
	            ]
	        }
	        , region: 'center',
	        id: "mp",
	        cls: 'pds-map',
	        title: 'couche',
	        layers: [limit]
	    }
	    );
	    //ajout du vecteur a editer
	    mapUI.map.addLayer(osm_layer);
	    mapUI.map.setCenter(
                new OpenLayers.LonLat(49.66633828357455,-14.154428089787606).transform(
                    new OpenLayers.Projection("EPSG:4326"),
                    mapUI.map.getProjectionObject()
                ), 8
            );
	    var modifyOptions = {
	        onModificationEnd: function (feature) {
	        	console.log("e",layerArea);
	            console.log("end modifying", feature);
	            var addHisto = Ext.Ajax.request({
                    async: false,
                    url: constants.dns + '/plan-de-surface/surfaceHisto/'+ layerArea +'/' + feature.attributes.layer +'/' + feature.attributes.color.substring(1) +'/' + feature.attributes.color.substring(1)    
                });
	            app.featureGrid.store.proxy.protocol.commit(
	                vectorLayer.features, {
	                    callback: function () {
	                        var layers = mapUI.map.layers;
	                        for (var i = layers.length - 1; i >= 0; --i) {
	                            layers[i].redraw(true);
	                        }
	                        app.featureGrid.store.reload();
	                    }
	                });
	        }
	    };
	    //ajouter des controls
	     modifyControl = new OpenLayers.Control.ModifyFeature(
	        vectorLayer, modifyOptions, { autoActivate: true }, { standalone: true });
	    drawControl = new OpenLayers.Control.DrawFeature(
	        vectorLayer,
	        OpenLayers.Handler.Polygon,
	        { handlerOptions: { multi: true } }
	    );
	
	    drawControl.events.register('featureadded', vectorLayer);
	
	    mapUI.map.addControl(modifyControl);
	    mapUI.map.addControl(drawControl);
	
	    vectorLayer.events.on({
	        featureselected: function (opts) {},
	        featureunselected: function (evt) {
	            modifyControl.deactivate();
	        }
	    });
	    tab = [];

	  //tree panel
	    tab.push({
	        xtype: "treepanel",
	        ref: "tree",
	        region: "west",
	        id: 'pds_panel_left',
	        cls: 'pds-panel-left',
	        width: 251,
	        title: 'Assets',
	        autoScroll: true,
	        enableDD: true,
	        collapsible: true,
	        collapsed: true,
	        split: true,
	        loader: new Ext.tree.TreeLoader({
	            applyLoader: false
	        }),
	        root: new GeoExt.tree.LayerContainer({
	            expanded: false
	        }),
	        rootVisible: false,
	        lines: false
	    });
	
	    // wfs affichage de store et synchronisation avec la map
	    tab.push({
	        xtype: "editorgrid",
	        ref: "featureGrid",
	        title: "Feature Table",
	        region: "south",
	        hidden: true,
	        collapsible: false,
	        collapsed: false,
	        height: 150,
	        sm: new GeoExt.grid.FeatureSelectionModel(),
	        store: new GeoExt.data.FeatureStore(),
	        columns: []
	    });
	
	    //fonction qui lit les attributs de la couche
	    var rawAttributeData;
	    var read = OpenLayers.Format.WFSDescribeFeatureType.prototype.read;
	    OpenLayers.Format.WFSDescribeFeatureType.prototype.read = function () {
	        rawAttributeData = read.apply(this, arguments);
	        return rawAttributeData;
	    };
	
	
	    //fonction qui reconfigure les parametres de l'affichage du grid selon la selection du node
	    function reconfigure(store, url) {
	        var fields = [], columns = [], geometryName, geometryType;
	        // regular expression to detect the geometry column
	        var geomRegex = /gml:(Multi)?(Point|Line|Polygon|Surface|Geometry).*/;
	        // mapping of xml schema data types to Ext JS data types
	        var types = {
	            "xsd:int": "int",
	            "xsd:short": "int",
	            "xsd:long": "int",
	            "xsd:string": "string",
	            "xsd:date": "string",
	            "xsd:double": "float",
	            "xsd:decimal": "float",
	            "Line": "Path",
	            "Surface": "Polygon"
	        };
	        store.each(function (rec) {
	            var type = rec.get("type");
	            var name = rec.get("name");
	            var match = geomRegex.exec(type);
	            if (match) {
	                // we found the geometry column
	                geometryName = name;
	                // Geometry type for the sketch handler:
	                // match[2] is "Point", "Line", "Polygon", "Surface" or "Geometry"
	                geometryType = types[match[2]] || match[2];
	            } else {
	                // we have an attribute column
	                fields.push({
	                    name: name,
	                    type: types[type]
	                });
	                columns.push({
	                    xtype: types[type] == "string" ?
	                        "gridcolumn" :
	                        "numbercolumn",
	                    dataIndex: name,
	                    header: name,
	                    // textfield editor for strings, numberfield for others
	                    editor: {
	                        xtype: types[type] == "string" ?
	                            "textfield" :
	                            "numberfield"
	                    }
	                });
	            }
	        });
	        app.featureGrid.reconfigure(new GeoExt.data.FeatureStore({
	            autoLoad: true,
	            proxy: new GeoExt.data.ProtocolProxy({
	                protocol: new OpenLayers.Protocol.WFS({
	                    url: url,
	                    version: "1.1.0",
	                    featureType: rawAttributeData.featureTypes[0].typeName,
	                    featureNS: rawAttributeData.targetNamespace,
	                    srsName: "EPSG:900913",
	                    geometryName: geometryName,
	                    //nombre de champ maximal a afficher
	                    maxFeatures: 250
	                })
	            }),
	            fields: fields
	        }), new Ext.grid.ColumnModel(columns));
	        app.featureGrid.store.bind(vectorLayer);
	        app.featureGrid.getSelectionModel().bind(vectorLayer);
	        // Set the correct sketch handler according to the geometryType
	        drawControl.handler = new OpenLayers.Handler[geometryType](
	            drawControl, drawControl.callbacks, drawControl.handlerOptions
	        );
	    }
	
	
	    //appel de la fonction de changement données et le titre
	    function setLayer(model, node) {
	        if (!node || node.layer instanceof OpenLayers.Layer.Vector) {
	            return;
	        }
	        vectorLayer.removeAllFeatures();
	        app.featureGrid.reconfigure(
	            new Ext.data.Store(),
	            new Ext.grid.ColumnModel([])
	        );
	        layerArea = node.layer.name;
	        var layer = node.layer;
	        var url = layer.url.split("?")[0]; // the base url without params
	        var schema = new GeoExt.data.AttributeStore({
	            url: url,
	            // request specific params
	            baseParams: {
	                "SERVICE": "WFS",
	                "REQUEST": "DescribeFeatureType",
	                "VERSION": "1.1.0",
	                "TYPENAME": layer.params.LAYERS
	            },
	            autoLoad: true,
	            listeners: {
	                "load": function (store) {
	                    app.featureGrid.setTitle(layer.name);
	                    reconfigure(store, url);
	                }
	            }
	        });
	    }
	    // contenue des éléments en haut du panel
	    	
	    //integrer la carte dans le tableau
	    tab.push(mapUI);
	    tab.push({
	        region: "east",
	        split: true,
	        width: 230,
	        id: 'panel_right',
	        //mila reference 
	        ref: "test",
	        layout: 'accordion',
	        collapsible: false,
	        collapsed: false,
	        // type du contenue 
	        // contenue du panel
	        items: [
	
	        	new GeoExt.LegendPanel({
	        	    region: "east",
	        	    title: "Legend",
	        	    width: 200,
	        	    autoScroll: true,
	        	    layers: mapUI.layers
	        	})
	        ]
	    });

	    //appeler le popup, layers fixera les couches a afficher
	   var info = new OpenLayers.Control.WMSGetFeatureInfo({
	        autoActivate: true,
	            //choisir les couches a afficher
	            layers: mapUI.map.layers,
	        infoFormat: "application/vnd.ogc.gml",
	        maxFeatures: 1,
	        eventListeners: {
	            "getfeatureinfo": function(e) {
	                var items = [];
	                Ext.each(e.features, function(feature) {
	                    items.push({
	                        xtype: "propertygrid",
	                        title: feature.fid,
	                        source: feature.attributes
	                    });
	                });
	                var shows = new GeoExt.Popup({
	                    title: "Feature Info",
	                    width: 200,
	                    height: 200,
	                    layout: "accordion",
	                    anchored: true,
	                    map: mapUI.map,
	                    location: e.xy,
	                    items: items
	                });

		                shows.show();
	                
	            }
	        }
	    });
	    //rajouter le control popup               
	    mapUI.map.addControl(info);
	   // activer le popup
	    info.activate();
	    
	    //interface finale
	    // [4] - Final User Interface
	    app = new Ext.Viewport({
	        layout: "border"
	        , items: tab
	    });
	    app.tree.getSelectionModel().on(
	        "selectionchange", setLayer
	    );
	    app.featureGrid.store.bind(vectorLayer);
	    app.featureGrid.getSelectionModel().bind(vectorLayer);
	    var sm = app.featureGrid.getSelectionModel();
	    sm.unbind();
	    sm.bind(vectorLayer);
	    sm.on("beforerowselect", function (opts) { });
	
	});        //EOF Ext.onReady

export { app, drawControl, vectorLayer, tab, mapUI, layer_bat, lastName, rect, vector, vectorPoint, activPts };