
function AnimeDel(){
    //Array donde se guardarán los ids
    var ids = [];
    
    //Selección de los inputs con name=anime_del y estado checked
    $("input[name='anime_del']:checked").each(//Recorre los inputs
        function(){
            //Agrega el id del input actual
            ids.push($(this).val());
        }
    );
    
    //
    if(ids.length === 0){
        $("#message").html("No hay filas seleccionadas");
    }
    else {
       //Envío de la petición
       window.location = "Anime?accion=DEL&ids=" + ids.toString();
    }
    
    
}

//En JS las variables se inicializan con null

function AnimeGet(){
    var id = $("input[name='anime_get']:checked").val();
    
    if (id === undefined){
        console.log("Es undefined");
        $("#message").html("Seleccione una fila");
    } else {
        window.location = "Anime?accion=GET&id=" + id;
    }
    
}

function AnimeIns(){
    window.location = "AnimeIns.jsp";
}


