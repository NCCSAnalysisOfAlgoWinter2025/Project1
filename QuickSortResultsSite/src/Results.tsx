import SingleGraph, { dataPoint } from "./components/SingleGraph";

type AlgoTest = {
    testName: string;
    dataPoints: dataPoint[];
};

export type AlgoTests = {
    algoName: string;
    tests: AlgoTest[];
};

const Results: React.FC<{
    curStage: number;
    data: AlgoTests[] | undefined;
    updateStage: React.Dispatch<React.SetStateAction<number>>;
}> = ({ data, curStage, updateStage }) => {
    return (
        <>
            <h1 className="text-center text-3xl m-10">Results</h1>
            <p className="text-center m-10">
                The Y axis is the time in nano seconds and the X axis is the
                array's size
            </p>
            <div className="flex flex-row w-4/5 mx-auto">
                {data?.map((algoTests) => {
                    return (
                        <>
                            <div className="mx-auto flex flex-col gap-20 border-1 border-slate-900">
                                <h2 className="text-2xl text-center">
                                    {algoTests.algoName}
                                </h2>
                                {algoTests.tests.map((algoTest) => {
                                    return (
                                        <>
                                            <SingleGraph
                                                dataPoints={algoTest.dataPoints}
                                                title={algoTest.testName}
                                                className="motion-preset-slide-down-md motion-opacity-in-0 motion-duration-[2s]"
                                            />
                                        </>
                                    );
                                })}
                            </div>
                        </>
                    );
                })}
            </div>
        </>
    );
};

export default Results;
