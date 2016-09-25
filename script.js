$("#fact-list").empty();

$.getJSON("test_resources/facts.json", null, function callback(facts){
    for (var i = 0; i < facts.length; i++){
        $("#fact-list").append(buildCard(facts[i].title, facts[i].date, facts[i].body, facts[i].sources));
    }
});


/**
 * lol quick and dirty, but oh so dirty
 */
function buildCard(title, date, body, sources){
    return '<div class="card">' + 
            '<div class="card-header">' + 
            '<h4 class="card-title">' + 
            title + 
            '</h4>' + 
            '<h6 class="card-subtitle text-muted">' + 
            date + 
            '</h6>' + 
            '</div>' + 
            '<div class="card-block">' + 
            '<p class="card-text">' + 
            body + 
            '</p>' + 
            '<a href="' + 
            sources[0].url + 
            '" class="card-link">' + 
            sources[0].name + 
            '</a>' + 
            '</div>' + 
            '</div>';
}