//Set margins and sizes
var margin = {
top: 20,
bottom: 50,
right: 30,
left: 50
};

var width = 900 - margin.left - margin.right;
var height = 500 - margin.top - margin.bottom;
//Create date parser
var ParseDate = d3.time.format("%Y-%m-%d").parse;
//Create x and y scale to scale inputs
var xScale = d3.time.scale().range([0, width]);
var yScale = d3.scale.linear().range([height, 0]);

//Create x and y axes
var xAxis = d3.svg.axis().scale(xScale)
.orient("bottom")
.ticks(5 );
var yAxis = d3.svg.axis().scale(yScale)
.orient("left")
.ticks(5);

//Create a line generator
var valueline = d3.svg.line()
.x(function(d){
return xScale(d.release_Date);
})

.y(function(d){
return yScale(d.core_Speed);
});
//Create an SVG element and append it to the DOM
var svgElement = d3.select("body").append("svg")
.attr({"width": width+margin.left+margin.right, "height": height+margin.top+margin.bottom})
.append("g")
.attr("transform","translate("+margin.left+","+margin.top+")");
//Read TSV file

d3.json('/api/dto1', function(data) {
//d3.tsv("http://simplysanad.com/d3js/data.tsv", function(data){
//Parse Data into useable format
data.forEach(function(d){
d.release_Date = ParseDate(d.release_Date);
d.core_Speed = +d.core_Speed;
//the + sign converts string automagically to number
});

//Set the domains of our scales
xScale.domain(d3.extent(data, function(d){ return d.release_Date; }));
yScale.domain([0, d3.max(data, function(d){ return d.core_Speed; })]);

//append the svg path
var path = svgElement.append("path")
.attr("d", valueline(data));

//Add X Axis
var x = svgElement.append("g")
.attr("transform", "translate(0,"+height+")")
.call(xAxis);

//Add Y Axis
var y = svgElement.append("g")
.call(yAxis);

//Add label to y axis
y.append("text")
.attr("fill", "#000")
.attr("transform", "rotate(-90)")
.attr("y", 6)
.attr("dy", "0.71em")
.attr("text-anchor", "end")
.text("Core speed");
});