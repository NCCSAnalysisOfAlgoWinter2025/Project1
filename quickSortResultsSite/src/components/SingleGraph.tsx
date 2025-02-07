export type dataPoint = {
    arrSize: number;
    deltaTime: number;
    success: boolean;
};

import * as d3 from "d3";
import React, { useEffect, useMemo, useRef } from "react";

const WIDTH = 500;
const HEIGHT = WIDTH;
const MARGIN = { top: 30, right: 30, bottom: 50, left: 100 };

const SingleGraph: React.FC<{
    className?: string;
    title: string;
    dataPoints: dataPoint[];
}> = ({ className, title, dataPoints }) => {
    let everFailed = false;
    dataPoints.forEach((d) => {
        if (!d.success) {
            everFailed = true;
        }
    });

    let maxTime = 0;
    dataPoints.forEach((d) => {
        if (d.deltaTime > maxTime) {
            maxTime = d.deltaTime;
        }
    });

    // bounds = area inside the graph axis = calculated by substracting the margins
    const axesRef = useRef(null);
    const boundsWidth = WIDTH - MARGIN.right - MARGIN.left;
    const boundsHeight = HEIGHT - MARGIN.top - MARGIN.bottom;

    // Y axis
    const [min, max] = d3.extent(dataPoints, (d: dataPoint) => d.deltaTime);
    const yScale = useMemo(() => {
        return d3
            .scaleLinear()
            .domain([1, max || 0])
            .range([boundsHeight, 0]);
    }, [dataPoints, HEIGHT]);

    // X axis
    const [xMin, xMax] = d3.extent(dataPoints, (d: dataPoint) => d.arrSize);
    const xScale = useMemo(() => {
        return d3
            .scaleLinear()
            .domain([1, xMax || 0])
            .range([0, boundsWidth]);
    }, [dataPoints, WIDTH]);

    // Render the X and Y axis using d3.js, not react
    useEffect(() => {
        const svgElement = d3.select(axesRef.current);
        svgElement.selectAll("*").remove();
        const xAxisGenerator = d3.axisBottom(xScale);
        svgElement
            .append("g")
            .attr("transform", "translate(0," + boundsHeight + ")")
            .call(xAxisGenerator);

        const yAxisGenerator = d3.axisLeft(yScale);
        svgElement.append("g").call(yAxisGenerator);
    }, [xScale, yScale, boundsHeight]);

    // Build the line
    const lineBuilder = d3
        .line<dataPoint>()
        .x((d: dataPoint) => xScale(d.arrSize))
        .y((d: dataPoint) => yScale(d.success ? d.deltaTime : 1));
    const linePath = lineBuilder(dataPoints);
    if (!linePath) {
        return null;
    }

    return (
        <div className={className}>
            <h3 className="text-xl text-center">{title}</h3>
            <svg width={WIDTH} height={HEIGHT}>
                <g
                    width={boundsWidth}
                    height={boundsHeight}
                    transform={`translate(${[MARGIN.left, MARGIN.top].join(
                        ","
                    )})`}
                >
                    <path
                        d={linePath}
                        opacity={1}
                        stroke="#306fff"
                        fill="none"
                        strokeWidth={2}
                    />
                </g>
                <g
                    width={boundsWidth}
                    height={boundsHeight}
                    ref={axesRef}
                    transform={`translate(${[MARGIN.left, MARGIN.top].join(
                        ","
                    )})`}
                />
            </svg>
            <span>
                Max time: {new Intl.NumberFormat("en-Latn-US").format(maxTime)}{" "}
                ns
            </span>
            <span className="mx-5">
                Ever crashed: {everFailed ? "Yes" : "No"}
            </span>
        </div>
    );
};

export default SingleGraph;
