import { useState } from "react";
import "./App.css";
import DataUpload from "./components/DataUpload";
import { GiWarhammer } from "react-icons/gi";
import Results, { AlgoTests } from "./Results";

function App() {
    const [stage, setStage] = useState(0);
    const [data, setData] = useState<AlgoTests[]>();

    return (
        <>
            <h1>
                Goofy ah hammer: <GiWarhammer className="inline" /> can you tell
                I put some time into this
            </h1>
            {stage == 0 ? (
                <DataUpload
                    curStage={stage}
                    updateStage={setStage}
                    setJsonData={setData}
                />
            ) : null}
            {stage == 1 ? (
                <>
                    <Results
                        curStage={stage}
                        data={data}
                        updateStage={setStage}
                    />
                </>
            ) : null}
        </>
    );
}

export default App;
