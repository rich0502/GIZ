import { legendColor } from './legendColor.js';
import urlJson from './commun/urlJson.js';
import datajson from './commun/datajson.js';
import constants from './commun/constants.js';
const rdc = new OpenLayers.Layer.WMS("RDC",
    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
        layers: [
        	"rdc_commentaire",
            "rdc_pieces",
            "rdc_annotation",
            "rdc_line"

        ],
        transparent: true,
        format: "image/gif"
    }, {
        buffer: 0,
        displayInLayerSwitcher: true,
        visibility: false,
        eventListeners: {
            "loadstart": function (opts) {
                legendColor(rdc, datajson(urlJson.rdc));
                datajson(urlJson.ssol1);
                datajson(urlJson.ssol2);
                datajson(urlJson.ssol3);
                datajson(urlJson.ssol4);
                datajson(urlJson.etage1);
                datajson(urlJson.etage2);
                datajson(urlJson.etage3);
                datajson(urlJson.etage4);
                datajson(urlJson.etage5);
                datajson(urlJson.etage6);
                datajson(urlJson.etage7);
                datajson(urlJson.etage8);
                datajson(urlJson.etage9);
                datajson(urlJson.etage10);
            }
        }
    });
const ssol1 = new OpenLayers.Layer.WMS("SOUS-SOL 1",
    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
        layers: [
        	"ssol1_commentaire",
            "ssol1_pieces",
            "ssol1_annotation",
            "ssol1_line"
        ],
        transparent: true,
        format: "image/gif"
    }, {
        buffer: 0,
        displayInLayerSwitcher: false,
        visibility: false,
        eventListeners: {
            "loadstart": function (opts) {
                legendColor(ssol1, datajson(urlJson.ssol1));
                datajson(urlJson.rdc);
                datajson(urlJson.ssol2);
                datajson(urlJson.ssol3);
                datajson(urlJson.ssol4);
                datajson(urlJson.etage1);
                datajson(urlJson.etage2);
                datajson(urlJson.etage3);
                datajson(urlJson.etage4);
                datajson(urlJson.etage5);
                datajson(urlJson.etage6);
                datajson(urlJson.etage7);
                datajson(urlJson.etage8);
                datajson(urlJson.etage9);
                datajson(urlJson.etage10);
            }

        }

    });
const ssol2 = new OpenLayers.Layer.WMS("SOUS-SOL 2",
    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
        layers: [
        	"ssol2_commentaire",
            "ssol2_pieces",
            "ssol2_annotation",
            "ssol2_line"
        ],
        transparent: true,
        format: "image/gif"
    }, {
        buffer: 0,
        displayInLayerSwitcher: false,
        visibility: false,
        eventListeners: {
            "loadstart": function (opts) {
                legendColor(ssol2, datajson(urlJson.ssol2));
                datajson(urlJson.rdc);
                datajson(urlJson.ssol1);
                datajson(urlJson.ssol3);
                datajson(urlJson.ssol4);
                datajson(urlJson.etage1);
                datajson(urlJson.etage2);
                datajson(urlJson.etage3);
                datajson(urlJson.etage4);
                datajson(urlJson.etage5);
                datajson(urlJson.etage6);
                datajson(urlJson.etage7);
                datajson(urlJson.etage8);
                datajson(urlJson.etage9);
                datajson(urlJson.etage10);
            }

        }
    });
    const ssol3 = new OpenLayers.Layer.WMS("SOUS-SOL 3",
    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
        layers: [
            "ssol3_commentaire",
            "ssol3_pieces",
            "ssol3_annotation",
            "ssol3_line"
        ],
        transparent: true,
        format: "image/gif"
    }, {
        buffer: 0,
        displayInLayerSwitcher: false,
        visibility: false,
        eventListeners: {
            "loadstart": function (opts) {
                legendColor(ssol3, datajson(urlJson.ssol3));
                datajson(urlJson.rdc);
                datajson(urlJson.ssol1);
                datajson(urlJson.ssol2);
                datajson(urlJson.ssol4);
                datajson(urlJson.etage1);
                datajson(urlJson.etage2);
                datajson(urlJson.etage3);
                datajson(urlJson.etage4);
                datajson(urlJson.etage5);
                datajson(urlJson.etage6);
                datajson(urlJson.etage7);
                datajson(urlJson.etage8);
                datajson(urlJson.etage9);
                datajson(urlJson.etage10);
            }

        }
    });
    const ssol4 = new OpenLayers.Layer.WMS("SOUS-SOL 4",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "ssol4_commentaire",
    	            "ssol4_pieces",
    	            "ssol4_annotation",
    	            "ssol4_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(ssol4, datajson(urlJson.ssol4));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage1 = new OpenLayers.Layer.WMS("ETAGE 1",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage1_commentaire",
    	            "etage1_pieces",
    	            "etage1_annotation",
    	            "etage1_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage1, datajson(urlJson.etage1));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage2 = new OpenLayers.Layer.WMS("ETAGE 2",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage2_commentaire",
    	            "etage2_pieces",
    	            "etage2_annotation",
    	            "etage2_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage2, datajson(urlJson.etage2));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage3 = new OpenLayers.Layer.WMS("ETAGE 3",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage3_commentaire",
    	            "etage3_pieces",
    	            "etage3_annotation",
    	            "etage3_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage3, datajson(urlJson.etage3));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage4 = new OpenLayers.Layer.WMS("ETAGE 4",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage4_commentaire",
    	            "etage4_pieces",
    	            "etage4_annotation",
    	            "etage4_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage4, datajson(urlJson.etage4));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage5 = new OpenLayers.Layer.WMS("ETAGE 5",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage5_commentaire",
    	            "etage5_pieces",
    	            "etage5_annotation",
    	            "etage5_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage5, datajson(urlJson.etage5));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage6 = new OpenLayers.Layer.WMS("ETAGE 6",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage6_commentaire",
    	            "etage6_pieces",
    	            "etage6_annotation",
    	            "etage6_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage6, datajson(urlJson.etage6));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage7 = new OpenLayers.Layer.WMS("ETAGE 7",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage7_commentaire",
    	            "etage7_pieces",
    	            "etage7_annotation",
    	            "etage7_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage7, datajson(urlJson.etage7));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage8 = new OpenLayers.Layer.WMS("ETAGE 8",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage8_commentaire",
    	            "etage8_pieces",
    	            "etage8_annotation",
    	            "etage8_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage8, datajson(urlJson.etage8));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage9);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage9 = new OpenLayers.Layer.WMS("ETAGE 9",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage9_commentaire",
    	            "etage9_pieces",
    	            "etage9_annotation",
    	            "etage9_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage9, datajson(urlJson.etage9));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage10);
    	            }

    	        }
    	    });
    const etage10 = new OpenLayers.Layer.WMS("ETAGE 10",
    	    constants.adresseIP + "/geoserver/PlanDyn/wms/PlanDyn", {
    	        layers: [
    	            "etage10_commentaire",
    	            "etage10_pieces",
    	            "etage10_annotation",
    	            "etage10_line"
    	        ],
    	        transparent: true,
    	        format: "image/gif"
    	    }, {
    	        buffer: 0,
    	        displayInLayerSwitcher: false,
    	        visibility: false,
    	        eventListeners: {
    	            "loadstart": function (opts) {
    	            	legendColor(etage10, datajson(urlJson.etage10));
    	                datajson(urlJson.rdc);
    	                datajson(urlJson.ssol1);
    	                datajson(urlJson.ssol2);
    	                datajson(urlJson.ssol3);
    	                datajson(urlJson.ssol4);
    	                datajson(urlJson.etage1);
    	                datajson(urlJson.etage2);
    	                datajson(urlJson.etage3);
    	                datajson(urlJson.etage4);
    	                datajson(urlJson.etage5);
    	                datajson(urlJson.etage6);
    	                datajson(urlJson.etage7);
    	                datajson(urlJson.etage8);
    	                datajson(urlJson.etage9);
    	            }

    	        }
    	    });
export { rdc, ssol1, ssol2, ssol3, ssol4, etage1, etage2, etage3, etage4, etage5, etage6, etage7, etage8, etage9, etage10};