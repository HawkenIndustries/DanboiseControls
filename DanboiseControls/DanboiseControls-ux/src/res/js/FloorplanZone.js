/***
*A popup widget with select device information
*Author: Victor Smolinski
*Date: 06/04/2019
**/

define([
    'bajaux/Widget',
    'bajaux/mixin/subscriberMixIn',
    'baja!driver:Device',
    'baja!control:NumericPoint',
    'baja!control:BooleanPoint',
    'baja!control:NumericWritable',
    'baja!control:BooleanWritable',
    'baja!',
    'nmodule/DanboiseControls/res/jqm/jquery.mobile-1.4.5.min.js',
    'nmodule/DanboiseControls/res/jqm/jquery.mobile-1.4.5.min.map',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.theme-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.structure-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.inline-svg-1.4.5.min.css',
    'css!nmodule/DanboiseControls/res/jqm/jquery.mobile.icons-1.4.5.min.css',
], function(
    widget,
    subscriberMixIn,
    device,
    nPoint,
    nWritable,
    bPoint,
    bWritable,
    baja,
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

    FloorplanZone.prototype.doInitialize = function(e){
        var self = this;
        e("<label for'zones' style='color: black; text-shadow: 0px 0px 0px darkgray'>Number of Beers: </label>"+
            "<input type='number' name='zones' pattern='[0-9]*' id='zones' value='0' data-theme='a'>")
            .appendTo(e(".ui-content"));
    }

    
});