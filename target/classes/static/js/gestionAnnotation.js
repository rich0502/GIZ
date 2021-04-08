import {app, layer_bat, drawControl, vectorLayer, mapUI, lastName, rect, activPts} from './plandyn.js'
import * as utils from './commun/utils.js'; 

var layerName;

export function draw (vectorLayer){
    var drawAnnotation = new OpenLayers.Control.DrawFeature(vectorLayer,OpenLayers.Handler.Point,
        { handlerOptions: { multi: true } }
    );
    return drawAnnotation;
}


// Fonction ajout popup
export function onAdded() {
    drawControl.deactivate();
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
                var models = app.featureGrid.getStore().getRange();
                var fin = parseInt(app.featureGrid.store.getCount());
                models[fin - 1].set("libelle", Ext.getCmp("ajoutAnnotation").getForm().findField("libele").getValue());
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
                drawControl.activate();
                
            }
        }, 
        {
            cls:'pds-cancel',
            width:30,
            height:30,
            text: '',
            handler: function () {
                var models1 = app.featureGrid.getStore().getRange();
                var fin1 = parseInt(app.featureGrid.store.getCount());
                vectorLayer.removeFeatures([models1[fin1-1].data.feature]);
                models1[fin1-1].data.feature.state = OpenLayers.State.DELETE;
                vectorLayer.addFeatures([models1[fin1-1].data.feature]);
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
    win.show(this);
}

function activateAnnotation(n) {        
    var checkedItems = app.tree.getChecked();
    var sizeCheckedItems =  utils.objectSize(checkedItems);
    try{
        	//commentaire
        /*	if((layerName.includes("commentaire")) && (sizeCheckedItems > 0)){
        		//drawControl.activate();
        		var vector = new OpenLayers.Layer.Vector();
        		mapUI.map.addLayers([vector]);
        		 rect = new OpenLayers.Control.DrawFeature(vector,
                        OpenLayers.Handler.RegularPolygon,
                        {handlerOptions: {sides: 4,irregular:true}});
        		mapUI.map.addControl(rect);
        		rect.activate();
        		vector.events.on({      
        			 "sketchcomplete": enddraw
                 });
        	}*/
        	
        	
            if ((layerName.includes("commentaire")) && (sizeCheckedItems > 0)){
                for (let i = 1; i < sizeCheckedItems; i++) {
                    var isChecked = (checkedItems[i].item).toString();
                    if (isChecked.includes("commentaire")){
                        utils.showButtonsCommentaire();
                        utils.hideButtonsPolygon();
                        utils.hideButtonsAnnotation();
                        break;
                    }else{
                        utils.hideButtonsComm();
                        rect.deactivate();
                        activPts.deactivate();
                    }
                  }
            }else if ((layerName.includes("annotation")) && (sizeCheckedItems > 0)){
	            for (let i = 1; i < sizeCheckedItems; i++) {
	                var isChecked = (checkedItems[i].item).toString()
	                if (isChecked.includes("annotation")){
	                    utils.showButtonsAnnotation();
	                    utils.hideButtonsPolygon();
	                    break;
	                }else{
	                    utils.hideButtonsAnnotation();
	                    drawControl.deactivate();
	                }
	              }
            }else{
	            utils.hideButtonsAnnotation();
	            utils.hideButtonsComm();
	            utils.showButtonsPolygon();
	            drawControl.deactivate();
	            rect.deactivate();
	            activPts.deactivate();
            } 
    }catch{
    	utils.hideButtonsAnnotation();
        utils.hideButtonsComm();
        utils.showButtonsPolygon();
        drawControl.deactivate();
        rect.deactivate();
        activPts.deactivate();
    } 
}


export function onClickAnnotation(n){
	 app.tree.getSelectionModel().on(
        "selectionchange", function () {
            var layerTrue = app.tree.getSelectionModel().selNode.layer.name;
            for (let i = 0; i < layer_bat.length; i++) {
                if(layer_bat[i].name === layerTrue){
                    layer_bat[i].setVisibility(false);
                    layer_bat[i].setVisibility(true);
                }
            }
        });
    layerName = n.attributes.text;
    activateAnnotation(n);
}

export function onCheckchangeAnnotation(n){
    activateAnnotation(n);
}
