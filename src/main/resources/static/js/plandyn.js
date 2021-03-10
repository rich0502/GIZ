import { mapColor } from './mapColor.js';
import datajson from './commun/datajson.js';
import nodChange from './commun/nodChange.js';
import { nodLayer } from './commun/utils.js';
import urlJson from './commun/urlJson.js';
import { rdc, ssol1, ssol2, ssol3, ssol4, etage1, etage2, etage3, etage4, etage5, etage6, etage7, etage8, etage9, etage10 } from './layerBat.js';
import { addComm } from './gestionCommentaire.js';
import constants from './commun/constants.js';
import { draw, onAdded, onClickAnnotation, onCheckchangeAnnotation } from './gestionAnnotation.js'
//sfdsdsdsdsdsdsd
var drawControl, app, vectorLayer, tab, mapUI, layer_bat,layerArea, lastName, modifyControl, rect, vector, vectorPoint, activPts;

	Ext.onReady(function () {
	    // [1] - layer
	    layer_bat = [rdc, ssol1, ssol2, ssol3, ssol4, etage1, etage2, etage3, etage4, etage5, etage6, etage7, etage8, etage9, etage10];
	    var mercator = constants.mercator;
	    lastName = document.getElementById("lastUser").innerHTML;
		var displayNumber = number == 0 ? "<div></div>" : '<span class="notification-number">'+ number +'</span>';
	    //declarer le proxy cgi  a utiliser
	   // OpenLayers.ProxyHost = "/cgi-bin/proxy.cgi?url=";
	    var data_rdc = datajson(urlJson.rdc);
	    var data_ssol1 = datajson(urlJson.ssol1);
	    var data_ssol2 = datajson(urlJson.ssol2);
	    var data_ssol3 = datajson(urlJson.ssol3);
	    var data_ssol4 = datajson(urlJson.ssol4);
	    var data_etage1 = datajson(urlJson.etage1);
	    var data_etage2 = datajson(urlJson.etage2);
	    var data_etage3 = datajson(urlJson.etage3);
	    var data_etage4 = datajson(urlJson.etage4);
	    var data_etage5 = datajson(urlJson.etage5);
	    var data_etage6 = datajson(urlJson.etage6);
	    var data_etage7 = datajson(urlJson.etage7);
	    var data_etage8 = datajson(urlJson.etage8);
	    var data_etage9 = datajson(urlJson.etage9);
	    var data_etage10 = datajson(urlJson.etage10);
	    layer_bat[0].setVisibility(true);
	    vectorLayer = new OpenLayers.Layer.Vector("Editable features");
	    vector = new OpenLayers.Layer.Vector();
	    vectorPoint = new OpenLayers.Layer.Vector();
		 rect = new OpenLayers.Control.DrawFeature(vector,
                OpenLayers.Handler.RegularPolygon,
                {handlerOptions: {sides: 4,irregular:true}});
		activPts = new OpenLayers.Control.DrawFeature(vectorPoint,
                OpenLayers.Handler.Point);
	    var bt_choix = new Ext.Panel
	        (
	            {
	                layout: 'column',
	                layoutConfig: { columns: 6 },
	                height: 30,
	                hidden: false,
	                items:
	                    [
	                        {
	                            columnWidth: 0.5,
	                        },	{
		                            xtype: 'button',
		                            text: 'ajouter',
		                            id: 'bt_comm',
		                            cls: 'pds-btn',
		                            hidden: true,
		                            toggleGroup: 'mygroup',
		                            height: 30,
		                            handler: function () {
		                            	this.pressed ? addComm() : rect.deactivate(); 
									}
	                        	},{
		                            xtype: 'button',
		                            text: 'Supprimer',
		                            id: 'bt_delcomm',
		                            hidden: true,
		                            cls: 'pds-btn',
		                            toggleGroup: 'mygroup',
		                            height: 30,
		                            handler: function () {
		                            	if(this.pressed){
		                            		console.log("vector",vector);
			                            	rect.deactivate();
			                            	activPts.deactivate();
		                            	}else{
		                            		rect.deactivate();
		                            		activPts.deactivate();
		                            	}
		                            }
		                        },{
		                            xtype: 'button',
		                            text: 'Surface',
		                            id: 'bt_surf',
		                            cls: 'pds-btn',
		                            toggleGroup: 'mygroup',
		                            height: 30,	                            
		                            handler: function () {
		                                if (this.pressed) {
		                                	modifyControl.activate();
		                                } else {
		                                	modifyControl.deactivate();
		                                }
		                            }
	                        	}, 
	                        	{
		                            xtype: 'button',
		                            id: 'bt_cat',
		                            text: 'Catégorie',
		                            cls: 'pds-btn',
		                            toggleGroup: 'mygroup',
		                            height: 30,	                            
		                            handler: function () {
		                                if (this.pressed) {
		                                	modifyControl.activate();
		                                } else {
		                                	modifyControl.deactivate();
		                                }
		                            }
	                        }, {
	                            xtype: 'button',
	                            id: 'bt_annot',
	                            cls: 'pds-btn',
	                            text: 'Ajouter',
	                            hidden: true,
	                            toggleGroup: 'mygroup',
	                            height: 30,
	                            enableToggle: false,
	                            control: drawControl,
	                            handler: function () {
	                                if (this.pressed) {
	                                    drawControl.activate();
	                                } else {
	                                    drawControl.deactivate();
	                                }
	                            }
	                        }, {
	                            xtype: 'button',
	                            id: 'bt_delAnnot',
	                            cls: 'pds-btn',
	                            text: 'Supprimer',
	                            hidden: true,
	                            toggleGroup: 'mygroup',
	                            height: 30,
	                            enableToggle: false,
	                            handler: function () {
	                                drawControl.deactivate();
	                            }
	                        },
	                        {
	                            columnWidth: 0.5,
	                        }
	                    ]
	            }
	        );
	    mapUI = new GeoExt.MapPanel({
	        ref: "mapPanel",
	        zoom: 3,
	        map: {
	            numZoomLevels: 10,
	            projection: mercator,
	            numZoomLevels: 10,
	            units: 'm',
	            maxExtent: new OpenLayers.Bounds(1673.42114257813, 1832.56384277344, 1794.62121582031, 1916.86401367188),
	            controls: [
	                new OpenLayers.Control.Navigation(),
	                new OpenLayers.Control.PanPanel(),
	                new OpenLayers.Control.ZoomPanel()
	
	
	            ]
	        }
	        , region: 'center',
	        items: [bt_choix],
	        id: "mp",
	        cls: 'pds-map',
	        title: 'couche',
	        layers: layer_bat
	    }
	    );
	    //ajout du vecteur a editer
	    mapUI.map.addLayer(vectorLayer);
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
	
	    drawControl.events.register('featureadded', vectorLayer, onAdded);
	
	    mapUI.map.addControl(modifyControl);
	    mapUI.map.addControl(drawControl);
	
	    vectorLayer.events.on({
	        featureselected: function (opts) {
	            if (Ext.getCmp('bt_delAnnot').pressed == true || Ext.getCmp('bt_delcomm').pressed == true) {
	                var feature = opts.feature;
	                vectorLayer.removeFeatures([feature]);
	                feature.state = OpenLayers.State.DELETE;
	                vectorLayer.addFeatures([feature]);
	
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
	
	            modifyControl.activate();
	            if (Ext.getCmp('bt_cat').pressed == true) {
	                setTimeout(function () {
	                    var getcouche = opts.feature.fid;
	                    var n = getcouche.indexOf(".");
	                    var couche = getcouche.substring(0, n);
	                    if (couche == "rdc_pieces") {
	                        mapColor(opts, data_rdc, rdc);
	                    } else if (couche == "ssol1_pieces") {
	                        mapColor(opts, data_ssol1, ssol1);
	                    } else if (couche == "ssol2_pieces") {
	                        mapColor(opts, data_ssol2, ssol2);
	                    } else if (couche == "ssol3_pieces") {
	                        mapColor(opts, data_ssol3, ssol3);
	                    } else if (couche == "ssol4_pieces") {
	                        mapColor(opts, data_ssol4, ssol4);
	                    } else if (couche == "etage1_pieces") {
	                        mapColor(opts, data_etage1, etage1);
	                    } else if (couche == "etage2_pieces") {
	                        mapColor(opts, data_etage2, etage2);
	                    } else if (couche == "etage3_pieces") {
	                        mapColor(opts, data_etage3, etage3);
	                    } else if (couche == "etage4_pieces") {
	                        mapColor(opts, data_etage4, etage4);
	                    } else if (couche == "etage5_pieces") {
	                        mapColor(opts, data_etage5, etage5);
	                    } else if (couche == "etage6_pieces") {
	                        mapColor(opts, data_etage6, etage6);
	                    } else if (couche == "etage7_pieces") {
	                        mapColor(opts, data_etage7, etage7);
	                    } else if (couche == "etage8_pieces") {
	                        mapColor(opts, data_etage8, etage8);
	                    } else if (couche == "etage9_pieces") {
	                        mapColor(opts, data_etage9, etage9);
	                    } else if (couche == "etage10_pieces") {
	                        mapColor(opts, data_etage10, etage10);
	                    }
	                }, 500);
	            }
	        },
	        featureunselected: function (evt) {
	            modifyControl.deactivate();
	        }
	    });
	    tab = [];
	    var LayerNodeUI = Ext.extend(GeoExt.tree.LayerNodeUI, new GeoExt.tree.TreeNodeUIEventMixin());
	
	    var treeConfig = new OpenLayers.Format.JSON().write(nodLayer, true);
	
	    //tree panel
	    tab.push({
	        xtype: "treepanel",
	        ref: "tree",
	        region: "west",
	        id: 'pds_panel_left',
	        cls: 'pds-panel-left',
	        width: 251,
	        title: 'NIVEAU',
	        autoScroll: true,
	        enableDD: true,
	        collapsible: true,
	        collapsed: true,
	        split: true,
	        loader: new Ext.tree.TreeLoader({
	            applyLoader: false,
	            uiProviders: {
	                "layernodeui": LayerNodeUI
	            }
	        }),
	        root: {
	            nodeType: "async",
	            expanded: true,
	            children: Ext.decode(treeConfig)
	        },
	        rootVisible: false,
	        lines: false,
	        listeners: {
	            'click': onClickAnnotation,
	            'checkchange': onCheckchangeAnnotation
	        }
	    });
	
	    // wfs affichage de store et synchronisation avec la map
	    tab.push({
	        xtype: "editorgrid",
	        ref: "featureGrid",
	        title: "Feature Table",
	        region: "south",
	        hidden: true,
	        collapsible: false,
	        collapsed: true,
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
	            "xsd:dateTime": "string",
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
	                "TYPENAME": node.item
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
	    tab.push({
	        xtype: "grid",
	        ref: "capsGrid",
	        //title: "PLAN INTERNE ETECH CONSULTING",
	        region: "north",
	        height: 0,
	        viewConfig: {
	            forceFit: true
	        },
	        // service utiliser
	        store: new GeoExt.data.WMSCapabilitiesStore({
	            url: constants.adresseIP + "/geoserver/wms?SERVICE=WMS&REQUEST=GetCapabilities&VERSION=1.1.1",
	            autoLoad: true
	        }),
	        columns: [],
	        bbar: [{
	        	 html: '<div class="p-header-logo">'
	             	+ '<a class="menu-link" data-toggle="modal" data-target="#menuModal">'
	             +'<img src="img/pds_menu.svg" class="img-menu-plan" alt="menu">'
	            +'</a><div class="logo-section-plan"><img class="pHeaderLogo-img" src="./extjs-3.3.1-src/docs/resources/images/pds_logo.svg" alt="logo">' +
	            '<span class="text-logo">AREA MANAGEMENT</span></div></div>'
	            +'<div id="menuModal" class="modal animated bounceIn menuModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
	            +'<div class="modal-content menu-container"><div class=" menu-list">'
	            +'<a class="menu-item double-width" id="home"><span class="menu-item-icon menu-accueil-icon"></span><span class="menu-item-label">ACCUEIL</span></a>'
	            + '<a class="menu-item" id="userForm"><span class="menu-item-icon menu-user-icon"></span><span class="menu-item-label">UTILISATEURS</span></a>'
	            + '<a class="menu-item" id="plan"><span class="menu-item-icon menu-plan-icon"></span><span class="menu-item-label">PLAN</span></a>'
	           + ' <a class="menu-item" id="down"><span class="menu-item-icon menu-export-icon"></span><span class="menu-item-label">EXPORT</span></a>'
	           +' <a class="menu-item" id="recap"><span class="menu-item-icon menu-recap-icon"></span><span class="menu-item-label">RECAPITULATIF</span></a>'
	          + ' <a class="menu-item" id="validation"><span class="menu-item-icon menu-validation-icon"></span><span class="menu-item-label">VALIDATIONS</span></a>'
	          +' <a class="menu-item"><span class="menu-item-icon menu-document-icon"></span><span class="menu-item-label" th:href="@{/uploadForm}">DOCUMENTS</span></a>'
	          + '</div>'
	        	+'</div></div>',
	            listeners: {
	                afterrender: function (component) {
	                	var userForm = component.getEl().down('#userForm');
	                	var plan = component.getEl().down('#plan');
	                	var recap = component.getEl().down('#recap');
	                	var down = component.getEl().down('#down');
	                	var home = component.getEl().down('#home');
	                	var validation = component.getEl().down('#validation');
	                	userForm.on('click', function () {
	                		location.href = constants.dns + "/plan-de-surface/userForm"
	                	});
	                	plan.on('click', function () {
	                		location.href = constants.dns + "/plan-de-surface/plan"
	                	});
	                	recap.on('click', function () {
	                		location.href = constants.dns + "/plan-de-surface/recapitulatif"
	                	});
	                	down.on('click', function () {
	                		location.href = constants.dns + "/plan-de-surface/export-preview"
	                	});
	                	home.on('click', function () {
	                		location.href = constants.dns + "/plan-de-surface/home"
	                	});
	                	validation.on('click', function () {
	                		location.href = constants.dns + "/plan-de-surface/approuve"
	                	});
	                }
	                
	            }
	        },
	     
	
	       '->',
	        {
	            xtype: "button",
	            text: ' ',
	            id: 'pds_historique',
	            cls: 'pds_historique',
	            handler: function () {
	                location.href = constants.dns + "/plan-de-surface/historique"
	            }
	
	        }, 
	        {
	            xtype: "button",
	            text: ' ',
	            id: 'pds_notification',
	            cls: 'pds_notification',
                hidden: false,
	            html: displayNumber,
	            handler: function () {
	                location.href = constants.dns + "/plan-de-surface/validation"
	            }
	
	        }, 
	        {
	            // user info
	            xtype: 'tbsplit',
	            id: 'user_info',
	            cls: 'user-info',
	            width: 125,
	            text: '<div class="user-job">' +
               '<div class="name-user"><tr><td><span>'+ lastName+'</span></td></tr></div>' +
               '<small class="role-user">Administrator</small>' +
               '</div>', 
	            menu: [{
	                text: "Mon Profil",
	                id: "pds_profil",
	                cls: "pds-profil",
	                handler: function () {
	                    location.href = constants.dns + "/plan-de-surface/editProfil/"+id
	                }
	            }, {
	                text: 'Deconnecter',
	                id: 'pds_logout',
	                cls: "pds-logout",
	                handler: function () {
	                    location.href = constants.dns + "/plan-de-surface/logout"
	                }
	            }
	            ],
	
	        },
	        ]
	    });
	
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
	
	            new Ext.Panel({ // premier ï¿½lement
	                title: 'Légendes',
	                autoScroll: true,
	                xtype: "panel",
	                id: "legends"
	            })
	        ]
	    });
	    
	    //gestion des rôles user et admin
	    lastName ==="user" ? tab[2].bbar[3].hidden=true : tab[2].bbar[3].hidden=false;
	    
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