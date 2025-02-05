import { dataPoint } from "./components/SingleGraph";

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
            <h1 className="text-center text-3xl m-20">Results</h1>
            <div className="flex flex-row w-4/5 mx-auto">
                {data?.map((algoTests, i, arr) => {
                    return (
                        <>
                            <div className="mx-auto">
                                <h2>{algoTests.algoName}</h2>
                            </div>
                        </>
                    );
                })}
            </div>
        </>
    );
};

export default Results;
