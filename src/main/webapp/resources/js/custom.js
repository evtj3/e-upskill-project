/**
 * Created by jejeTabadzki on 2/16/2017.
 */
$(document).ready(function(){
    $("main").show();
    var editor = CKEDITOR.replace("editor1");


    var mainTopic = $("#mainTopic");
    var title = $("#title");

    mainTopic.bind('input',function(){
        $("#topicHeader").html($(this).val());
    });
    title.bind('input',function(){
        $("#titleHeader").html($(this).val());
    });

    editor.on('change', function (evt) {
        var ckEditorData = CKEDITOR.instances.editor1.getData();
        $(".contentData").html(ckEditorData);
    });

    $("#submit-btn").click(function(event) {
        event.preventDefault();
        var formData = ({
            _csrf:$("#_csrf").val(),
            mainTopic: mainTopic.val(),
            title:title.val(),
            content:CKEDITOR.instances.editor1.getData()
        });
        console.log(formData);
        $.ajax({
            url: "/post",
            type: "post",
            DataType:'json',
            data: formData
        }).success(function(response){
            console.log(response);
            if(response === "success"){
                location.reload();
            }else{

            }
        }).error(function(a){
            console.log(a);
        });
    });

});