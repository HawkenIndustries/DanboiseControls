/***
*A popup widget with select device information
*Author: Victor Smolinski
*Date: 06/04/2019
**/

define([
    'bajaux/Widget',
    'bajaux/mixin/subscriberMixIn',
    'd3',
    'baja!driver:Device',
    'baja!control:NumericPoint',
    'baja!control:BooleanPoint',
    'baja!control:NumericWritable',
    'baja!control:BooleanWritable',
    'baja!',
    'd3',
    'nmodule/DanboiseControls/res/jqm/jquery.mobile-1.4.5.min.js',
    'nmodule/DanboiseControls/res/jqm/jquery.mobile-1.4.5.min.map',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.theme-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.structure-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.inline-svg-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.icons-1.4.5.min.css'
], function(
    widget,
    subscriberMixIn,
    device,
    nPoint,
    nWritable,
    bPoint,
    bWritable,
    baja,
    d3,
    jqm
){
    'use strict';

    var FloorplanZone = function(){
        var self = this;
        widget.apply(self, args);
        subscriberMixIn(self);
    }
    
    FloorplanZone.prototype = Object.create(widget.prototype);
    FloorplanZone.prototype.constructor = FloorplanZone

    FloorplanZone.prototype.doInitialize = function(element){
        var self = this;
        var w = d3.select(element[0])
            .append('<h1>VAV Name</h1>');
    }

    
});