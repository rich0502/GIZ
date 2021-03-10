import constants from './constants.js';
export default function datajson(wfs) {
    var gjson = new GeoExt.data.FeatureStore({
        proxy: new GeoExt.data.ProtocolProxy({
            protocol: new OpenLayers.Protocol.HTTP({
                url: constants.adresseIP + wfs,
                format: new OpenLayers.Format.GeoJSON()
            })
        }),
        autoLoad: true
    });
    return gjson;
}
