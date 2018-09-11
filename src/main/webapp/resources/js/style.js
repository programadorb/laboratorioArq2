function validarTipoTarjeta(){
    if($(".numeroTarjeta")[0].value){
        var numero=parseInt($(".numeroTarjeta")[0].value);
        if(numero>=11111 && numero<=22222){
            document.getElementById("tipoTarjetaAmerican").click();
        }else if(numero>=33334 && numero<=44444){
            document.getElementById("tipoTarjetaDiners").click();
        }else if(numero>=55555 && numero<=66666){
            document.getElementById("tipoTarjetaVisa").click();
        }else if(numero>=77777 && numero<=88888){
            document.getElementById("tipoTarjetaMastercard").click();
        }
    }
}

function rellenarMetodoPago(){
    if($){
        if($(".tipoTarjeta")[0].value){
            var tipo =$(".tipoTarjeta")[0].value;
            if(tipo="mastercard"){
                document.getElementById("tipoTarjetaMastercard").click();
            }else if(tipo=="american"){
                document.getElementById("tipoTarjetaAmerican").click();
            }else if(tipo=="diners"){
                document.getElementById("tipoTarjetaDiners").click();
            }else if(tipo=="visa"){
                document.getElementById("tipoTarjetaVisa").click();
            }
        }
    }
}

function exito(){
    alert("todo salio bien");
}

window.onload = function () {
//    rellenarMetodoPago();
}