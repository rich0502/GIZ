import { app, mapUI, vectorLayer } from './plandyn.js'
import { RGBToHex, combobox } from './commun/utils.js'; 
import constants from './commun/constants.js';

export function mapColor(opts, data_layer, layer) {
    if (opts.feature.data.color != undefined) {
        var unik = [];
        var model = data_layer.data.items;
        for (let i = 0; i < model.length; i++) {
            unik.push(model[i].data.feature.data);
        }
        const filteredItems = unik.filter(item => item.layer !== opts.feature.data.layer);
        var nav = new Ext.FormPanel({
            region: 'center',
            width: 30,
            id: 'formColor',
            frame: true,
            labelWidth: 75,
            defaults: {
                width: 200
            },
            items: [
                new Ext.Panel({ // premier ï¿½lement
                    autoScroll: true,
                    xtype: "panel",
                    id: 'map_io',
                    html: '<form name="myForm">'
                    	+ '<a href="#" id="basic" class="popup-parent" id="basic" style="background-color:'+ opts.feature.data.color
                        + ';border:1px solid #C4C4C4;text-decoration: none;border: none;font-size: 2px;width:auto"></a>'
                        + '<select id="type"><option value="' + opts.feature.data.layer + '">' + opts.feature.data.layer + '</option>' + combobox(filteredItems) + '</select>'
                        // + '<input type="button" name="saveMap" id="saveMap" value="save">'
                        + '<div class="float-right">'
                        + '<input type="button" name="saveMap" id="saveMap" value="">'
                        + '<input type="button" name="cancelMap" id="cancelMap" value="">'
                        + '</div>'
                        + '</form>',
                    listeners: {
                        afterrender: function (component) {
                            var getcolor;
                            function $(selector, context) {
                                console.log(selector);
                                return (context || document).querySelector(selector);
                            }
                            var parentBasic = $('#basic');
                            var popupBasic;
                            var save = component.getEl().down('#saveMap');
                            var couleur;
                            var initColor = opts.feature.data.color ;
                            var initType = opts.feature.data.layer ;
                            var type = component.getEl().down('#type');
                            var cancel = component.getEl().down('#cancelMap');
                            cancel.on('click', function (){
                                Ext.getCmp("mapColors").close(); 
                            });
                        	
                            /* Basic example */
                            popupBasic = new Picker(parentBasic);
                            popupBasic.onDone = color => {
                                parentBasic.style.background = color.rgbaString;
                                couleur = RGBToHex(color.rgba[0],color.rgba[1],color.rgba[2]);
                            };
                        	
                            save.on('click', function () {
                                app.featureGrid.store.proxy.protocol.commit(
                                    vectorLayer.features, {
                                        callback: function () {
                                            var models = app.featureGrid.getStore().getRange();
                                            var clr = couleur || initColor;
                                            var fin = parseInt(app.featureGrid.store.getCount());
                                            if(opts.feature.data.layer == type.getValue()) {
                                                for (let j = 0; j < fin; j++) {
                                                    if (models[j].data.layer == type.getValue()) {
                                                        models[j].set("color", clr);
                                                    }
                                                }
                                            }else if(opts.feature.data.layer != type.getValue() && opts.feature.data.color != clr){
                                                for (let j = 0; j < fin; j++) {
                                                    if (models[j].data.fid == opts.feature.fid) {
                                                        models[j].set("layer", type.getValue());
                                                    }
                                                }
                                                for (let j = 0; j < fin; j++) {
                                                    if (models[j].data.layer == type.getValue()) {
                                                        models[j].set("color", clr);
                                                    }
                                                }
                                                
                                            }else{
                                                for (let j = 0; j < fin; j++) {
                                                    if (models[j].data.layer == type.getValue()) {
                                                        getcolor = models[j].data.color;
                                                    }
                                                }
                                                for (let j = 0; j < fin; j++) {
                                                    if (models[j].data.fid == opts.feature.fid) {
                                                        models[j].set("layer", type.getValue());
                                                        models[j].set("color", getcolor);
                                                    }
                                                }
                                            }
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
                                            for (let i = 0; i < unik.length; i++) {
                                                if (unik[i].layer == type.getValue()) {
                                                    var chang = component.getEl().down('#textcolor' + i);
                                                    chang.dom.style.backgroundColor = clr;
                                                }
                                            }
                                            layer.redraw(true);
                                            const colorCapitalized = type.getValue().charAt(0).toUpperCase() + type.getValue().slice(1);
                                            var response = Ext.Ajax.request({
                                                async: false,
                                                url: constants.dns + '/plan-de-surface/floorChange/'+ colorCapitalized +'/' + clr.substring(1)
                                            });
                                            var piece_modif,color_modif;
                                            initType === type.getValue() ? piece_modif = null : piece_modif = "pieces";
                                            initColor.substring(1) === clr.substring(1) ? color_modif = null : color_modif = "couleur";
                                            var desc_modif = piece_modif || color_modif;
                                        	var addHisto = Ext.Ajax.request({
                                                async: false,
                                                url: constants.dns + '/plan-de-surface/addhistorique/'+ layer.name +'/' + initType +'/' + initColor.substring(1) +'/' + clr.substring(1) +'/' + desc_modif +'/' + type.getValue()      
                                            });
                                            vectorLayer.refresh({ force: true });
                                            Ext.getCmp("mapColors").close();
                                        }

                                    });

                            });
                            // Use .down('#colorPickerBackground', true) to get actual DOM element
                        }
                    }
                })]
        });
        var win = new Ext.Window({
            closable: false,
            id: 'mapColors',
            width: 372,
            height: 73,
            plain: true,
            layout: 'border',
            items: [nav]
        });
        win.show(this);
    } // temps d'attente en ms
}