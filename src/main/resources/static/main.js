
var svg = d3.select("svg"),
    margin = {top: 20, right: 20, bottom: 30, left: 50},
    width = +svg.attr("width") - margin.left - margin.right,
    height = +svg.attr("height") - margin.top - margin.bottom,
    g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

var parseTime = d3.timeParse("%Y-%m-%d");

var x = d3.scaleTime()
    .rangeRound([0, width]);

var y = d3.scaleLinear()
    .rangeRound([height, 0]);

var area = d3.area()
    .x(function(d) { return x(d.release_Date); })
    .y1(function(d) { return y(d.memory); });

d3.json("/api/dto1", function(data) {
    console.log(data);
  data.id =  +data.id;
  data.core_Speed = +data.core_Speed;
  data.memory = +data.memory;
  data.release_Date = parseTime(data.release_Date);
  return data;
}, function(error, data) {
  if (error) throw error;

  x.domain(d3.extent(data, function(d) { return data.release_Date; }));
  y.domain([0, d3.max(data, function(d) { return data.core_Speed; })]);
  area.y0(y(0));

  g.append("path")
      .datum(data)
      .attr("fill", "steelblue")
      .attr("data", area);

  g.append("g")
      .attr("transform", "translate(0," + height + ")")
      .call(d3.axisBottom(x));

  g.append("g")
      .call(d3.axisLeft(y))
    .append("text")
      .attr("fill", "#000")
      .attr("transform", "rotate(-90)")
      .attr("y", 6)
      .attr("dy", "0.71em")
      .attr("text-anchor", "end")
      .text("Price ($)");
});
