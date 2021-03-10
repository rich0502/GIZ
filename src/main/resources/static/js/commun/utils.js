import nodChange from './nodChange.js';

export function objectSize(obj) {
    var size = 0, key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
};

export function hideButtonsPolygon() {
    Ext.getCmp('bt_surf').hide();
    Ext.getCmp('bt_cat').hide();
}

export function hideButtonsComm() {
    Ext.getCmp('bt_comm').hide();
    Ext.getCmp('bt_delcomm').hide();
}

export function showButtonsPolygon() {
    Ext.getCmp('bt_surf').show();
    Ext.getCmp('bt_cat').show();
}

export function showButtonsAnnotation() {
    Ext.getCmp('bt_annot').show();
    Ext.getCmp('bt_delAnnot').show();
}

export function showButtonsCommentaire() {
    Ext.getCmp('bt_comm').show();
    Ext.getCmp('bt_delcomm').show();
}

export function hideButtonsAnnotation() {
    Ext.getCmp('bt_annot').hide();
    Ext.getCmp('bt_delAnnot').hide();
    Ext.getCmp('bt_annot').toggle(false);
    Ext.getCmp('bt_delAnnot').toggle(false);
}
export function activateLayer(listLayer, layerTrue) {
  for (let i = 0; i < listLayer.length; i++) {
      if(listLayer[i] !== layerTrue){
            listLayer[i].setVisibility(false);
      } 
   }
}
export function RGBToHex(r,g,b) {
    r = r.toString(16);
    g = g.toString(16);
    b = b.toString(16);
  
    if (r.length == 1)
      r = "0" + r;
    if (g.length == 1)
      g = "0" + g;
    if (b.length == 1)
      b = "0" + b;
  
    return "#" + r + g + b;
  }
export function hexToRgb(hex) {
	var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
	return result ? {
	  r: parseInt(result[1], 16),
	  g: parseInt(result[2], 16),
	  b: parseInt(result[3], 16)
	} : null;
}
export function combobox(only){
    var comb_type = '<option value="' + only[0].layer + '">' + only[0].layer + '</option>';
    for (let i = 1; i < only.length; i++) {
        comb_type = comb_type + '<option value="' + only[i].layer + '">' + only[i].layer + '</option>';
       
    }
    return comb_type;
}

export function roundTo(value, places){
    var power = Math.pow(10, places);
    return Math.round(value * power) / power;
}

export function delEltArray(array,layer){
	const index = array.indexOf(layer);
    if (index > -1) {
    	array.splice(index, 1);
    }
    return array;
}

export const nodLayer = [nodChange.ssol4,nodChange.ssol3,nodChange.ssol2,nodChange.ssol1,
	nodChange.rdc, nodChange.etage1, nodChange.etage2, nodChange.etage3, nodChange.etage4, nodChange.etage5, nodChange.etage6, nodChange.etage7, nodChange.etage8, nodChange.etage9, nodChange.etage10];