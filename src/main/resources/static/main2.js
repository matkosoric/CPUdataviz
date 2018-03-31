var margin = {
top: 20,
bottom: 50,
right: 30,
left: 50
};

var width = 1100 - margin.left - margin.right;
var height = 500 - margin.top - margin.bottom;
var ParseDate = d3.time.format("%Y-%m-%d").parse;
var xScale = d3.time.scale().range([0, width]);
var yScale = d3.scale.linear().range([height, 0]);

var xAxis = d3.svg.axis().scale(xScale)
.orient("bottom")
.ticks(5 );
var yAxis = d3.svg.axis().scale(yScale)
.orient("left")
.ticks(5);

var valueline = d3.svg.line()
.x(function(d){
return xScale(d.release_Date);
})

.y(function(d){
return yScale(d.memory);
});
var svgElement = d3.select("#graph2").append("svg")
.attr({"width": width+margin.left+margin.right, "height": height+margin.top+margin.bottom})
.append("g")
.attr("transform","translate("+margin.left+","+margin.top+")");

d3.json('/api/dto1', function(data) {
data.forEach(function(d){
d.release_Date = ParseDate(d.release_Date);
d.memory = +d.memory;
});

xScale.domain(d3.extent(data, function(d){ return d.release_Date; }));
yScale.domain([0, d3.max(data, function(d){ return d.memory; })]);

var path = svgElement.append("path")
.attr("d", valueline(data));

var x = svgElement.append("g")
.attr("transform", "translate(0,"+height+")")
.call(xAxis);

var y = svgElement.append("g")
.call(yAxis);

y.append("text")
.attr("fill", "#000")
.attr("transform", "rotate(-90)")
.attr("y", 6)
.attr("dy", "0.71em")
.attr("text-anchor", "end")
.text("Memory");
});