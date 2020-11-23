$(document).ready(function () {
    
    /* focus editable div on td click */
    $('.d-table-tracker td').each(function(elem) {        
        $(this).on('click', function(subeleme){
            $(this).find('div').focus()
            console.log(this)
        })
    })
    
    var dndHeightSum = 0;
    $('#dynamicTableTracker .row-dnd').each(function(element) {
        dndHeightSum += parseInt($(this).height())
    })
    $('.dnd-field').each(function(element) {               
        $(this).css({height: dndHeightSum+'px'})
    })


    $(".draggable-circ").draggable({containment: "parent",  grid: [ 100, 30 ] });            



    var element_to_export = $("#dynamicTableTracker")[0];
    var getCanvas;

    console.log(element_to_export)
    $("#btn-Preview-Image").on('click', function () {
        html2canvas(element_to_export)
        .then(function (canvas) {
            // $("#previewImage").append(canvas);
            
            var imgageData = new Image();
            imgageData.crossOrigin = 'Anonymous';
            imgageData.src =  canvas.toDataURL("image/png");
            
            // Now browser starts downloading it instead of just showing it
            var newData = imgageData.src.replace(/^data:image\/png/, "data:application/octet-stream");
            // $("#btn-Convert-Html2Image").attr("download", "your_pic_name.png").attr("href", newData);
            // $("#btn-Convert-Html2Image").click()
            console.log(element_to_export)
            var a = document.createElement('a');
            // toDataURL defaults to png, so we need to request a jpeg, then convert for file download.
            a.href = newData;
            a.download = 'somefilename.jpg';
            a.click();
        });
    });


});
