/**
 * Created by jejeTabadzki on 2/16/2017.
 */
$(document).ready(function(){
    $("main").show();
    var editor = CKEDITOR.replace("editor1");
    var formData = $("form input").serialize();

    var title = $("#title");

    title.bind('input',function(){
        $("#titleHeader").html($(this).val());
    });

    editor.on('change', function (evt) {
        var ckEditorData = CKEDITOR.instances.editor1.getData();
        $(".contentData").html(ckEditorData);
    });

    $("#submit-btn").click(function(event) {
        event.preventDefault();
        $.ajax({
            url: "/post",
            type: "post",
            data: formData
        }).success(function(response){
            console.log(response);
        }).error(function(a){
            console.log(a);
        });
    });

});