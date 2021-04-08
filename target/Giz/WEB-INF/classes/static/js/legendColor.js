import {app, tab,mapUI,layer_bat, vectorLayer} from './plandyn.js'
import {activateLayer, RGBToHex, combobox, roundTo} from './commun/utils.js'; 
import constants from './commun/constants.js';
export function legendColor(couche,data_layer) {
    var pieces,only = [];
    tab[3].setTitle(couche.name);
                activateLayer(layer_bat,couche);
                setTimeout(function () {
                    var model  = data_layer.data.items;
                    for (let i = 0; i < model.length; i++) {
                        only.push(model[i].data.feature.data);
                    }
                    var nom_var = [["textcolor0", only[0].layer]];
                    pieces = '<li class="panel-list-items"><input type="button"'
                        + 'style="background-color: ' + only[0].color + ';border:1px solid #C4C4C4;'
                        + 'color: white;text-decoration: none;border: none;'
                        + 'font-size: 2px;cursor: pointer;"'
                        + '" id="textcolor' + [0] + '" name="textcolor' + [0] + '"><span class="name-piece">' +only[0].layer +'</span><span class="measure-piece">'+ roundTo(only[0].surf, 1)+ ' </span></li>';
                        for (let i = 1; i < only.length; i++) {
                            pieces = pieces + '<li class="panel-list-items"><input type="button"'
                                + 'style="background-color: ' + only[i].color + ';border: none;'
                                + 'color: white;text-decoration: none;border: none;'
                                + 'font-size: 2px;cursor: pointer;"'
                                + '" id="textcolor' + [i] + '" name="textcolor' + [i] + '"><span class="name-piece">' + only[i].layer + '</span><span class="measure-piece">'+roundTo(only[i].surf, 1)+ ' m² </span></li>';
                            nom_var.push(["textcolor" + [i], only[0].layer]);
                        }

                        Ext.getCmp('legends').update('<div class="panel-list-title">Surface Utiles Brutes (S.U.B) </div>' + '<ul class="panel-list">' + pieces + '</ul>' + '<div class="orange-title">TOTAL S.U.B.L  <span>1674.2 m²</span></div> <div class="panel-list-title"> Annexes</div>');
                    var component = tab[4].items[0];
                    // Color input is Ext.dom.Element instance  
                    var num;
                    for (let i = 0; i < nom_var.length; i++) {
                        var colorInput = component.getEl().down("#" + nom_var[i]);
                        colorInput.on('click', function () {
                            num = nom_var[i][0].substring(9, 11);
                            const filteredItems = only.filter(item => item.layer !== only[num].layer);
                            var navs = new Ext.FormPanel({
                                region: 'center',
                                width: 30,
                                id: 'modifColor',
                                frame: true,
                                labelWidth: 75,
                                defaults: {
                                    width: 200
                                },
                                items: [
                                    new Ext.Panel({ // premier ï¿½lement
                                        autoScroll: true,
                                        xtype: "panel",
                                        id: "io",
                                        html: '<form name="myForm">'
                                        	 + '<a href="#" id="basic" class="popup-parent" style="background-color:'+only[num].color
                                             + ';border: none;text-decoration: none;border: none;font-size: 2px;width:auto"></a>'
                                            + '<select id="type"><option value="' + only[num].layer + '">' + only[i].layer + '</option>' + combobox(filteredItems) + '</select>'
                                            + '<div class="float-right">'
                                            + '<input type="button" name="save" id="save" value="">'
                                            + '<input type="button" name="save" id="cancel" value="">'
                                            + '</div>'
                                            + '</form>',
                                        listeners: {
                                            afterrender: function (component) {
												function $(selector, context) {
                                                    console.log(selector);
                                                    return (context || document).querySelector(selector);
                                                }
                                                var parentBasic = $('#basic');
                                                var popupBasic;
                                                var save = component.getEl().down('#save');
                                                var couleur;
                                                var initColor = only[num].color;
                                                var type = component.getEl().down('#type');
                                                var cancel = component.getEl().down('#cancel');
                                                cancel.on('click', function (){
                                                    Ext.getCmp("legendsColor").close(); 
                                                });
                                               
                                                /* color picker */
                                                popupBasic = new Picker(parentBasic);
                                                popupBasic.onDone = color => {
                                                    parentBasic.style.background = color.rgbaString;
                                                    console.log("color.rgbaString",color.rgbaString);
                                                    couleur = RGBToHex(color.rgba[0],color.rgba[1],color.rgba[2]);
                                                };
                                                
                                                //event save color
                                                save.on('click', function () {
                                                    var models = app.featureGrid.getStore().getRange();
                                                    var clr = couleur || initColor;
                                                    var fin = parseInt(app.featureGrid.store.getCount());
                                                    
                                                    for (let j = 0; j < fin; j++) {
                                                        if (models[j].data.layer == type.getValue()) {
                                                            models[j].set("color", clr);
                                                        }
                                                    }
                                                   
                                                    if(app.featureGrid.store.proxy){
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
                                                    var chang = component.getEl().down('#'+nom_var[i][0]);
                                                    chang.dom.style.backgroundColor=clr;
                                                    // Refresh map
                                                    vectorLayer.rendered = false;
                                                    couche.redraw(true);
                                                    const colorCapitalized = type.getValue().charAt(0).toUpperCase() + type.getValue().slice(1);
                                                    var response = Ext.Ajax.request({
                                                        async: false,
                                                        url: constants.dns + '/plan-de-surface/floorChange/'+ colorCapitalized +'/' + clr.substring(1)
                                                    });
                                                   console.log("niveau",couche.name);
                                                   console.log("pieces",type.getValue());
                                                   console.log("intiale",initColor);
                                                   console.log("final",clr);
                                                   var desc_modif = "couleur";
                                                   var piece_modif = false;
                                                   var addHisto = Ext.Ajax.request({
                                                        async: false,
                                                        url: constants.dns + '/plan-de-surface/addhistorique/'+ couche.name +'/' + type.getValue() +'/' + initColor.substring(1) +'/' + clr.substring(1) +'/' + desc_modif +'/' + piece_modif
                                                    });
                                                    vectorLayer.refresh({force: true});
                                                    Ext.getCmp("legendsColor").close(); 
                                                               
                                                  
                                                })
                                            }
                                        }
                                    })]
                            });
                            var winLegends = new Ext.Window({
                                closable: false,
                                id: 'legendsColor',
                                width: 372,
                                height: 73,
                                plain: true,
                                layout: 'border',
                                items: [navs]
                            });
                            winLegends.show(this);
                        });
                    }
                }, 2000)
       /* }
    );*/
}