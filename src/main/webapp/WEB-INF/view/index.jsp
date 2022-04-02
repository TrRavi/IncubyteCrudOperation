<!doctype html>
<%@ include file="tags/tags.jsp" %>
<html lang="en">

<head>

    <title>Incubyte CRUD Operation</title>
    <%@ include file="tags/staticFiles.jsp" %>
</head>

<body>
<%-- <%@ include file = "common/navbar.jsp" %> --%>
<div class="container-fluid" style="border:2px solid black;">
    <div class="row" style="border:1px solid black;">
        <div class="col-sm-12 col-lg-6">
            <div class="card-body" data-aos-duration="1000">
                <blockquote class="blockquote">
                    <p class="mb-0 display-4" style="color:#e0a80d">Crud Operation</p>
                    <footer class="blockquote-footer"><a href="https://github.com/TrRavi/IncubyteCrudOperation.git">Code Link</a></footer>
                </blockquote>
            </div>
            <!--  <hr style="margin-top:100px;" /> -->
            <button type="button" class="btn btn-primary newEntry" value="NewWordEntry" id="newWordEntry">NewWordEntry</button>
            <div class=”col-6 align-self-center”>
                <div class="table-responsive" style="margin-top:30px;">
                    <table class="table" style="overflow-x: hidden;overflow-y: hidden;">
                        <thead>
                        <th>Id</th>
                        <th>Word</th>
                        <th colspan="2" style="text-align:center">
                            Action
                        </th>
                        </thead>
                        <tbody id="wordListTableBody">
                        <c:forEach items="${wordList}" var="element">
                            <tr id = "row_${element.getId()}">
                                <td>${element.getId()}</td>
                                <td>${element.getWord()}</td>
                                <td>
                                    <button type="button" class="btn btn-primary updateOperation" value="Update">
                                        Update
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-danger deleteOperation" value="Delete">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
    <%--Models for update and new entry--%>
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">Operation</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="text"  id="wordId" value="" placeholder="Enter Id"/>
                    <input type="text"  id="wordText" value="" placeholder="enter word"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button  type="button" class="btn btn-primary " id="save">Save changes</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $("#newWordEntry").click(function(){
        $("#wordId").val("");
        $("#wordText").val("");
        $("#updateModalLabel").text("New Entry");
        $("#updateModal").modal('show')

    });

    $(document).on('click','.updateOperation',function(){
        let id = $(this).closest("tr").children('td').eq(0).text();
        let wordText = $(this).closest("tr").children('td').eq(1).text();
        $("#wordId").val(id);
        $("#wordId").attr("disabled", "disabled");
        $("#wordText").val(wordText);
        $("#updateModalLabel").text("update");
        $("#updateModal").modal('show');
    });



    $(document).on('click','.deleteOperation',function(){
        let id = $(this).closest("tr").children('td').eq(0).text();
        $.ajax({
            url: "${contextPath}/api/words?id="+id,
            type: "DELETE",
            success: function(result){
                alert(result);
                $("#row_"+id).remove();
            },
            error: function(){
            }
        });
    });



    $("#save").click(function(){
       let id = $("#wordId").val();
       if(id ==""){
        alert("id is required");
        return;
       }
       let wordText = $("#wordText").val();
       let isDisabled = $("#wordId").prop('disabled');
       let reqData =  {"id":id, "word":wordText};
        $.ajax({
            url: "${contextPath}/api/words",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(reqData),
            success: function(result){
                if (isDisabled){
                    $("#row_"+id).children('td').eq(0).text(result.id);
                    $("#row_"+id).children('td').eq(1).text(result.word);
                }else{
                    let trId = "row_"+result.id;
                    let newTr = "<tr id ='"+trId+"'>";
                    newTr += "<td>"+result.id+"</td>";
                    newTr += "<td>"+result.word+"</td>";
                    newTr += "<td><button type='button' class='btn btn-primary updateOperation' value='Update'>Update</button></td>";
                    newTr += "<td><button type='button' class='btn btn-danger deleteOperation' value='Deletepdate'>Delete</button></td>";
                    newTr += "</tr>";
                    $("#wordListTableBody").append(newTr);
                }
            },
            error: function(){
            }
        });
        $("#wordId").removeAttr("disabled", "disabled");
       $("#updateModal").modal('hide')
    });




</script>
</body>
</html>