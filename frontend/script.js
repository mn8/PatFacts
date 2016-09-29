"use strict";

$("#fact-list").empty();

$.getJSON("http://ec2-52-90-84-9.compute-1.amazonaws.com:8080/backend/facts", null, function callback(facts){
    for (var i = 0; i < facts.length; i++){
        $("#fact-list").append(buildCard(facts[i].title, facts[i].date, facts[i].body, facts[i].sources));
    }
});


/**
 * lol quick and dirty, but oh so dirty
 */
function buildCard(title, date, body, sources){
    return '<div class="card">' + 
                '<div class="card-header"  data-toggle="collapse" data-target="#'+date+'">' + 
                    '<h4 class="card-title">' + 
                        title + 
                    '</h4>' + 
                    '<h6 class="card-subtitle text-muted">' + 
                        date + 
                    '</h6>' + 
                '</div>' + 
                '<div class="card-block collapse in" id='+date+'>' + 
                    '<p class="card-text">' + 
                        body + 
                    '</p>' + 
                    buildSourceLinks(sources) + 
                '</div>' + 
            '</div>';
} 

function buildSourceLinks(sources){
    var html = "";
    for (var i = 0; i < sources.length; i++){
        html += '<a href="' + 
                sources[i].url + 
                '" class="card-link">' + 
                sources[i].name + 
                '</a>';
    }
    return html;
}