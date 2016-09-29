"use strict";

$("#fact-list").empty();

$.getJSON("http://ec2-52-90-84-9.compute-1.amazonaws.com:8080/backend/facts", null, function callback(facts){
    console.log(typeof facts)
    facts.map(function setDate(fact) {
        fact.date = new Date(fact.date);
        return fact;
    }).sort(function compare(fact1, fact2){
        return fact1.date - fact2.date;
    }).forEach(function modifyHtml(fact){
        $("#fact-list").prepend(buildCard(fact.title, fact.date, fact.body, fact.sources));
    });
    // for (var i = 0; i < facts.length; i++){
    //     facts[i].date = new Date(facts[i].date);
    //     console.log(facts[i].date.toDateString());
    // }
    console.log(JSON.stringify(facts));
});


/**
 * lol quick and dirty, but oh so dirty
 */
function buildCard(title, date, body, sources){
    return '<div class="card">' + 
                '<div class="card-header"  data-toggle="collapse" data-target="#'+date.getTime()+'">' + 
                    '<h4 class="card-title">' + 
                        title + 
                    '</h4>' + 
                    '<h6 class="card-subtitle text-muted">' + 
                        date.toDateString() + 
                    '</h6>' + 
                '</div>' + 
                '<div class="card-block collapse in" id="'+date.getTime()+'">' + 
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