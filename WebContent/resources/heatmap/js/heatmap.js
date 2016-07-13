var heatmapChart = function(url, target) { 
	d3.json(url,     
      function(error, json) {
		  console.log(target);
	      var scale = 960;
	      var minHeight = 300;
	      var columnNumber = 12;
	    	  
	      var xAxis = json['xAxis'];
	      var yAxis = json['yAxis'];
	      var pontos = json['pontos'];

	      var margin = { top: 50, right: 0, bottom: 0, left: 200 },
	          
	      width = (scale) - margin.left - margin.right,
	          height = minHeight - margin.top - margin.bottom,
	          
	          gridWidth = Math.floor(width / columnNumber),
	          gridHeight = Math.floor(gridWidth/2),
	          
	          buckets = 9,
	          colors = ["#ffffd9","#edf8b1","#c7e9b4","#7fcdbb","#41b6c4","#1d91c0","#225ea8","#253494","#081d58"]
	      ;
	
	      var svg = d3.select(target).append("svg")
	          .attr("width", width + margin.left + margin.right)
	          .attr("height", height + margin.top + margin.bottom)
	          .append("g")
	          .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
	     
	      var yLabels = svg.selectAll(".yLabel")
	          .data(yAxis)
	          .enter().append("text")
	            .text(function (d) { return d; })
	            .attr("x", 0)
	            .attr("y", function (d, i) { return i * gridHeight; })
	            .style("text-anchor", "end")
	            .attr("transform", "translate(-6," + gridHeight / 1.5 + ")")
	            .attr("class", "yLabel mono axis");
	
	      var xLabels = svg.selectAll(".timeLabel")
	          .data(xAxis)
	          .enter().append("text")
	            .text(function(d) { return d; })
	            .attr("x", function(d, i) { return i * gridWidth; })
	            .attr("y", 0)
	            .style("text-anchor", "middle")
	            .attr("transform", "translate(" + gridWidth / 2 + ", -6)")
	            .attr("class", "xLabel mono axis");
	
	      var colorScale = d3.scale.quantile()
	              .domain([0, buckets - 1, d3.max(pontos, function (d) { return d.value; })])
	              .range(colors);

          var cards = svg.selectAll(".x")
          	.data(pontos, function(d) {
          		return d.y+':'+d.x;
          		}
          );

          cards.enter().append("rect")
              .attr("x", function(d) { return (d.x - 1) * gridWidth; })
              .attr("y", function(d) { return (d.y - 1) * gridHeight; })
              .attr("rx", 4)
              .attr("ry", 4)
              .attr("class", "x bordered")
              .attr("width", gridWidth)
              .attr("height", gridHeight)
              .style("fill", colors[0]);

          cards.transition().duration(1000)
              .style("fill", function(d) { return colorScale(d.value); });

          cards.select("title").text(function(d) { return d.value; });
          
          cards.exit().remove();

        });  
 };

  

  
