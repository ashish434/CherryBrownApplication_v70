//Hamdan: JQuery Code for HIT COUNTER of HOMEPAGE

$(window).load(function(){
if (localStorage.mysitehits)
      {
          localStorage.mysitehits = Number(localStorage.mysitehits) + 1;
      }
      else
      {
          localStorage.mysitehits = 1;
      }
$("#hitcounter").html("<span class='myfont'>SITE HITS: <span style='color:red;'>"+localStorage.mysitehits+"</span></span>");

}); 
