//Hamdan: JQuery Code for HITS COUNTER of Other pages!

	$(window).load(
			function() {
				localStorage.mysitehits = Number(localStorage.mysitehits);
				$("#hitcounter").html(
						"<span class='myfont'>SITE HITS: <span style='color:red;'>"
								+ localStorage.mysitehits + "</span></span>");
			});