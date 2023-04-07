function validation(){
    var nom=document.getElementById("Form").elements["Nom"].value;

    if(nom.length==0){
        alert("Nom est obligatoire");
        return false;
    }
    return true;
 }