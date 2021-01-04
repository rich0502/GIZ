import {app, layer_bat, drawControl, vectorLayer, mapUI, lastName, rect, vector, vectorPoint, activPts} from './plandyn.js'
import * as utils from './commun/utils.js'; 

var layerName, point1, point2, point3, point4, end_point;


export function enddraw(event){
		mapUI.map.addControl(activPts);
	    //tracage multiligne
		 point2 = new OpenLayers.Geometry.Point(event.feature.geometry.components[0].components[2].x,event.feature.geometry.components[0].components[2].y);
		 point3 = new OpenLayers.Geometry.Point(event.feature.geometry.components[0].components[3].x,event.feature.geometry.components[0].components[3].y);
		 point4 = new OpenLayers.Geometry.Point(event.feature.geometry.components[0].components[4].x,event.feature.geometry.components[0].components[4].y);
		 point1 = new OpenLayers.Geometry.Point(event.feature.geometry.components[0].components[1].x,event.feature.geometry.components[0].components[1].y);
		rect.deactivate();
		activPts.activate(); 
}
export function endPoint(event){
	//popup	
	var nav = new Ext.FormPanel({
	        region: 'center',
	        width: 331,
	        height: 62,
	        id: 'ajoutAnnotation',
	        cls:'pds-annotation',
	        frame: true,
	        labelWidth: 0,
	        defaults: {
	            width: 200
	        },
	        defaultType: 'textfield',
	        items: [{
	            // fieldLabel: 'Libéllé',
	            width: 216,
	            name: 'libele',
	            cls:'pds-annot-input',
	            allowBlank: false
	        }],

	        buttons: [{
	            cls:'pds-save',
	            text: '',
	            width:30,
	            height:30,
	            handler: function () {
	            	var lin0 = new OpenLayers.Geometry.LineString([point2, point3]);
	            	var lin1 = new OpenLayers.Geometry.LineString([point3,point4]);
	            	var lin2 = new OpenLayers.Geometry.LineString([point4,point1]);
	            	var lin3 = new OpenLayers.Geometry.LineString([point1,point2]);
	            	var lin4 = new OpenLayers.Geometry.LineString([point2,end_point]);
	            	console.log("zzz",lin0);
	            	var addFeats = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.MultiLineString([lin0,lin1,lin2,lin3,lin4]));
	            	addFeats.state = OpenLayers.State.INSERT;
	            	vectorLayer.addFeatures([addFeats]);
	                var models = app.featureGrid.getStore().getRange();
	                var fin = parseInt(app.featureGrid.store.getCount());
	                models[fin - 1].set("remarque", Ext.getCmp("ajoutAnnotation").getForm().findField("libele").getValue());
	                models[fin - 1].set("user", lastName);
	                app.featureGrid.store.proxy.protocol.commit(
	                    vectorLayer.features, {
	                        callback: function () {
	                            var layers = app.mapPanel.map.layers;
	                            for (var i = layers.length - 1; i >= 0; --i) {
	                                layers[i].redraw(true);
	                            }
	                            app.featureGrid.store.reload();
	                        }
	                    });
	                Ext.getCmp("add_popup").close();
	                rect.activate();
	                
	            }
	        }, 
	        {
	            cls:'pds-cancel',
	            width:30,
	            height:30,
	            text: '',
	            handler: function () {
	                Ext.getCmp("add_popup").close();
	                rect.deactivate();
	                activPts.deactivate();
	            }
	        }]
	    });
	var win = new Ext.Window({
	    header:false,
	    // title : 'Ajout annotation',
	    closable: false,
	    id: 'add_popup',
	    width: 331,
	    height: 62,
	    plain: true,
	    layout: 'border',
	    items: [nav]
	});

	end_point = new OpenLayers.Geometry.Point(event.feature.geometry.x,event.feature.geometry.y);
	activPts.deactivate();
    win.show(this);
	rect.activate();
}
export function addComm(){
	mapUI.map.addLayers([vector]);
	mapUI.map.addControl(rect);
	rect.activate();
	vector.events.on({      
		 "sketchcomplete": enddraw
     });
	vectorPoint.events.on({      
		 "sketchcomplete": endPoint
    });
}
