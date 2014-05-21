//Hamdan: JAVASCRIPT CODE FOR SHOWING/HIDING ELEMENTS..

function show(target){
document.getElementById(target).style.display = 'block';
}
function hide(target){
document.getElementById(target).style.display = 'none';
}


//Hamdan: JQuery code for loading 'Homepage' page
$(document).ready(function(){
$("#item1").click(function(event){
$(".block").load('Home.html');
});
});


//Hamdan: JQuery code for loading 'About our Hotel' page
$(document).ready(function(){
$("#item2").click(function(event){
$(".block").load('AboutOurHotel.html');
});
});



//Hamdan: JQuery code for loading 'Room Services' page
$(document).ready(function(){
$("#item3").click(function(event){
$(".block").load('RoomServices_Ajax.html');

});
});



//Hamdan: JQuery code for loading 'Photogallery' page
$(document).ready(function(){
$("#item4").click(function(event){
$(".block").load('imageshow1.html');
});
});



//Hamdan: JQuery code for loading 'Tour Packages' page
$(document).ready(function(){
$("#item5").click(function(event){
$(".block").load('TourPackages_Ajax.html');
});
});



//Hamdan:  JQuery code for loading 'Locations' page
$(document).ready(function(){
$("#item6").click(function(event){
$(".block").load('Locations.html');
});
});


//Hamdan: JQuery code for loading 'Contacts' page
$(document).ready(function(){
$("#item7").click(function(event){
$(".block").load('Contacts.html');
});
});
