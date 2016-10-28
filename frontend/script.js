"use strict";

$("#fact-list").empty();
$("#archives").empty();

$.getJSON("http://localhost:8080/backend/facts", null, function callback(facts) {
    // Convert date field to actual date objects and sort
    facts = facts.map(function setDate(fact) {
        fact.date = new Date(fact.date);
        return fact;
    }).sort(function compare(fact1, fact2) {
        return fact1.date - fact2.date;
    })

    // Populate facts
    facts.forEach(function modifyHtml(fact) {
        $("#fact-list").prepend(buildCard(fact.title, fact.date, fact.body, fact.sources));
    });

    // TODO: this is getting too messy, I should bring in a date library
    var monthNames = [
        "January", "February", "March",
        "April", "May", "June", "July",
        "August", "September", "October",
        "November", "December"
    ];

    var monthAndYearSet = {};
    facts.map(function mapToMonthOnly(fact) {
        return monthNames[fact.date.getMonth()] + " " + fact.date.getFullYear();
    }).forEach(function addToSet(date) {
        monthAndYearSet[date] = date;
    });
    for (var month in monthAndYearSet) {
        $("#archives").prepend(buildArchiveLink(month));
    }
});

function buildArchiveLink(month){
    return '<li><a href="#">' + 
    month + '</a></li>';
}

/**
 * lol quick and dirty, but oh so dirty
 */
function buildCard(title, date, body, sources) {
    return '<div class="card">' +
        '<div class="card-header"  data-toggle="collapse" data-target="#' + date.getTime() + '">' +
        '<h4 class="card-title">' +
        title +
        '</h4>' +
        '<h6 class="card-subtitle text-muted">' +
        date.toDateString() +
        '</h6>' +
        '</div>' +
        '<div class="card-block collapse in" id="' + date.getTime() + '">' +
        '<p class="card-text">' +
        body +
        '</p>' +
        buildSourceLinks(sources) +
        '</div>' +
        '</div>';
}

function buildSourceLinks(sources) {
    var html = "";
    for (var i = 0; i < sources.length; i++) {
        html += '<a href="' +
            sources[i].url +
            '" class="card-link">' +
            sources[i].name +
            '</a>';
    }
    return html;
}

function saveFact(fact){
    //Example format needed to send data
/*    var fact = '{ "title": "Dogs","body": "Did you know that cats are an ecological disaster! These invasive predators live in the artificial shelters of humans roam the wildness killing large numbers of birds and rodents. This has caused the extinction of over 33 different birds. They are also one of the few animals the kill for fun, freaking metal man. This has caused many birds to refer to them as.","date": "2016-09-25","sources": [{"source": "https://en.wikipedia.org/wiki/List_of_invasive_species_in_North_America","name": "Wikipedia"}]}';*/

    console.log(fact);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/backend/facts",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: fact,
        success: function(json) {

    }});
}


$( "#add-fact" ).submit(function( event ) {
    //Quick and dirty, clean this up
    var formSubmittion = $(this).serializeArray();
    if(!formSubmittion[0].value){
        console.log("Please provide a title");
    }else if(!formSubmittion[1].value){
        console.log("Please provide a fact")
    }else if(!formSubmittion[2]){
        console.log("Please provide a source")
    }
    var fact = {
        title: formSubmittion[0].value,
        body: formSubmittion[1].value,
        sources:[{
            source:formSubmittion[2].value,
            name:"User Submitted"}] 
    };
    saveFact(JSON.stringify(fact));
    alert( "Handler for .submit() called." );
    event.preventDefault();
});