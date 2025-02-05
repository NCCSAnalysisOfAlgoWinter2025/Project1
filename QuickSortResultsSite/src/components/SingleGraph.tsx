export type dataPoint = {
    arrSize: number;
    deltaTime: number;
    success: boolean;
};

import * as d3 from "d3";

const SingleGraph: React.FC<{
    className?: string;
    title: string;
    dataPoints: dataPoint[];
}> = ({ className, title, dataPoints }) => {
    return (
        <>
            <div className={"" + className}>
                <h2>{title}</h2>
                <svg width={100} height={100}></svg>
            </div>
        </>
    );
};

export default SingleGraph;
