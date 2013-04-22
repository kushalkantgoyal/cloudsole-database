package com.example.util;

import java.util.Map;

public class GraphMapper {
	
	public static <T> String lineGraphBuilder(Map<T,T> linegrapMap)
	{
		StringBuilder lineGraph = new StringBuilder();
		for (T linegraph : linegrapMap.keySet())
		{
			lineGraph.append("[").append(linegraph).append(",").append(linegrapMap.get(linegraph)).append("],");
		}
		return lineGraph.substring(0, lineGraph.length()-1);
	}
	public static <T> String donutChartBuilder(Map<T,T> donotgraphMap)
	{
			/*
			 {
				label: "Series1",
				data: 50
			}, */
		
		StringBuilder donutGraph = new StringBuilder();
		for (T donugraph : donotgraphMap.keySet())
		{
			donutGraph.append("{").append("label:\"").append(donugraph).append("\"").append(",").append("data: ").append(donotgraphMap.get(donugraph)).append("},");
		}
		return donutGraph.substring(0, donutGraph.length()-1);
	}
}
