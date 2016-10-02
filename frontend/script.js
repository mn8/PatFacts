"use strict";

$("#fact-list").empty();
$("#archives").empty();

$.getJSON("http://ec2-52-55-8-54.compute-1.amazonaws.com:8080/backend/facts", null, function callback(facts) {
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