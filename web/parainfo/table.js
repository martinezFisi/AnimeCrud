$(function() {
    $("table.parainfo thead").addClass("ui-widget-header");
    $("table.parainfo tfoot").addClass("ui-widget-header");

    $("table.parainfo .crud .ins span").addClass("ui-icon ui-icon-plusthick");
    $("table.parainfo .crud .del span").addClass("ui-icon ui-icon-minusthick");
    $("table.parainfo .crud .upd span").addClass("ui-icon ui-icon-check");
    $("table.parainfo .crud .open span").addClass("ui-icon ui-icon-folder-open");

    $("table.parainfo .crud").mouseover(function() {
        $(this).addClass("ui-state-hover");
    }).mouseout(function() {
        $(this).removeClass("ui-state-hover");
    });
});

