

//One global variable to set, use true if you want the menus to reinit when the user changes text size (recommended):
resizereinit=true;

menu[1] = {
id:'menu1', //use unique quoted id (quoted) REQUIRED!!
hdingbgcolor:'#8B2500',  // heading - non linked horizontal cells background color
fontsize:'80%', // express as percentage with the % sign
linkheight:23 ,  // linked horizontal cells height
hdingwidth:165 ,  // heading - non linked horizontal cells width
// Finished configuration. Use default values for all other settings for this particular menu (menu[1]) ///

menuItems:[ // REQUIRED!!
//[name, link, target, colspan, endrow?] - leave 'link' and 'target' blank to make a header
["MENU"], //create header
["Home", "home.action", ""],
["Register Customer", "customerRegistration.action", ""],
["Room Services", "#",""],
["Photogallery", "photoGallery.action", ""],
["Tour Packages", "#", ""],
["Location", "#", ""],
["Contacts", "#", ""]
]}; // REQUIRED!! do not edit or remove


////////////////////Stop Editing/////////////////

make_menus();