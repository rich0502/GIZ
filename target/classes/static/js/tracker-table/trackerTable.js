$(document).ready(function () {
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
            var newData = imgageData.src.replace(/^data:image\/png/, "");
            // $("#btn-Convert-Html2Image").attr("download", "your_pic_name.png").attr("href", newData);
            // $("#btn-Convert-Html2Image").click()
            var desc_file = document.getElementById("desc").value;
            var a = document.createElement('a');
            // toDataURL defaults to png, so we need to request a jpeg, then convert for file download.
            a.href = newData;
            document.body.innerHTML += '<form id="dynForm" action="http://localhost:8080/Giz/saveTracker" method="post">'
            	+'<input type="hidden" name="imageValue" value="'+newData+'">'
            	+'<input type="hidden" name="desc_file" value="'+desc_file+'">'
            	+'</form>';
            document.getElementById("dynForm").submit();
           // a.download = 'somefilename.jpg';
            //a.click();
        });
    });
});
