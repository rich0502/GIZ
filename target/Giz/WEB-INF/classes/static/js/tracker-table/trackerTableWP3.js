$(document).ready(function () {
    
    /* focus editable div on td click */
    $('.d-table-tracker td').each(function(elem) {
        if ($(this).find('div.editable-field')[0])      
            $(this).on('click', function(subeleme) {
                $(this).find('div.editable-field').focus()
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


    $(".draggable-circ").draggable({containment: "parent",  grid: [ 0, 30 ] });            



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
            var newData = imgageData.src.replace(/^data:image\/png/, "");
            // $("#btn-Convert-Html2Image").attr("download", "your_pic_name.png").attr("href", newData);
            // $("#btn-Convert-Html2Image").click()
            console.log(element_to_export)
            var a = document.createElement('a');
            // toDataURL defaults to png, so we need to request a jpeg, then convert for file download.
            a.href = newData;
          //  a.download = 'tracker.jpg';
          //  a.click();

            /* pdf */
            
           var imgData = canvas.toDataURL("image/jpeg", 1.0);
            var pdf = new jsPDF({
                orientation: "landscape",
                unit: "mm"
            });

            document.body.innerHTML += '<form id="dynForm" action="http://168.119.185.165:8080/Giz/TrackerTableWP3" method="post">'
            	+'<input type="hidden" name="imageValue" value="'+newData+'">'
            	+'</form>';
            document.getElementById("dynForm").submit();
            
            // var pdfWidth = pdf.internal.pageSize.getWidth();
            // var pdfHeight = pdf.internal.pageSize.getHeight();
            
           /* pdf.addImage(imgData, 'JPEG', 2, 2);
            pdf.save("download.pdf");*/
        });
    });


});
