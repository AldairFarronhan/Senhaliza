

const opcion_Desplazar = document.querySelector('.opcion_desplazar'); 
const opcion_desplaza_icono = document.querySelector('.opcion_desplazar i');
const menu_Responsive = document.querySelector('.menu_responsive'); 

// si se hace clic en la clase opcion_Desplazar 
opcion_Desplazar.onclick = function(){
    // classList.toggle : si la lista de clases no esta  "abrir_menu" no agregar, y si ya esta lo quita
    menu_Responsive.classList.toggle('abrir_menu')
    // classList.contains : verifica si la clase "abrir_menu" existe en la etiqueta (true / false)
    // const icono_abierto = menu_Responsive.classList.contains('abrir_menu')
    // menu_Responsive.classList = icono_abierto 
    // ? 'fa-solid fa-x':'fa-solid fa-bars' 
}
